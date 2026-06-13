package com.pup.taguig.app.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.taguig.app.dto.OrdersRequestDTO;
import com.pup.taguig.app.dto.OrdersResponseDTO;
import com.pup.taguig.app.dto.ProductItemRequestDTO;
import com.pup.taguig.app.dto.ProductItemResponseDTO;
import com.pup.taguig.app.model.OrderItem;
import com.pup.taguig.app.model.Orders;
import com.pup.taguig.app.model.Product;
import com.pup.taguig.app.repository.OrdersMapper;
import com.pup.taguig.app.repository.ProductMapper;
import com.pup.taguig.app.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public OrdersResponseDTO addOrder(OrdersRequestDTO request) {
		 
		if(!this.checkProductExist(request.getItems())) {
			return null;
		}
		
		if(!this.checkStock(request.getItems())) {
			return null;
		}
		
		Long STATUS_ID_PENDING = (long) 1;
		
		Orders orders = new Orders();
		
		orders.setCustomerId(request.getCustomerId());
		orders.setTotalQuantity(this.computeTotalQuantity(request.getItems()));
		orders.setStatusId(STATUS_ID_PENDING);
		orders.setOrderPriceTotal(this.computeOrderPriceTotal(request.getItems()));
		
		
		Long rowsAffected = ordersMapper.insertOrder(orders);
		
		Long orderId = orders.getId();
		
		if(rowsAffected != 0) {
			this.decreaseProductStocks(request.getItems());
			this.insertOrderItems(request.getItems(), orderId);
		}
		
		return null;
	}
	
	public Boolean checkProductExist(List<ProductItemRequestDTO> productItemList) {
		
//		This checks if the products in the order request exists
		for(ProductItemRequestDTO productItem: 
					productItemList) {
			
			Long productItemId = productItem.getProductId(); 
			
			Product product = productMapper.findById(productItemId);
			
			if(!Objects.nonNull(product)) {
				return false;
			}
		}
		
		return true;
	}
	
	public Boolean checkStock(List<ProductItemRequestDTO> productItemList) {
		
//		This checks if the stocks are sufficient
		
		for(ProductItemRequestDTO productItem: 
			productItemList) {
	
			Long productItemId = productItem.getProductId(); 
			
			Product product = productMapper.findById(productItemId);
			
			if(product.getStock() == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public int computeTotalQuantity(List<ProductItemRequestDTO> productItemList) {
		
		int totalQuantity = 0;
		
		for(ProductItemRequestDTO productItem: 
			productItemList) {
			
			totalQuantity = totalQuantity + productItem.getQuantity();
		}
		
		return totalQuantity;
		
	}
	
	public Float computeOrderPriceTotal(List<ProductItemRequestDTO> productItemList) {
		
		Float orderPriceTotal = (float) 0;
		
		for(ProductItemRequestDTO productItem: 
			productItemList) {
	
			Long productItemId = productItem.getProductId(); 
			
			Product product = productMapper.findById(productItemId);
			
			orderPriceTotal = orderPriceTotal + (product.getPrice() * productItem.getQuantity());
		}
		
		return orderPriceTotal;
		
	}
	
	public void decreaseProductStocks(List<ProductItemRequestDTO> productItemList) {
		
		for(ProductItemRequestDTO productItem: 
			productItemList) {
	
			Long productItemId = productItem.getProductId(); 
			
			productMapper.decreaseStock(productItemId, productItem.getQuantity());
		}
		
	}
	
	public void insertOrderItems(List<ProductItemRequestDTO> productItemList, Long orderId) {
		
		for(ProductItemRequestDTO productItem: 
			productItemList) {
	
			Long productItemId = productItem.getProductId(); 
			Product product = productMapper.findById(productItemId);
			
			OrderItem orderItem = new OrderItem();
			
			
			orderItem.setOrderId(orderId);
			orderItem.setProductId(product.getId());
			orderItem.setTotalPrice(product.getPrice() * productItem.getQuantity());
			orderItem.setQuantity(productItem.getQuantity());
			
			
			ordersMapper.insertOrderItem(orderItem);
		}
		
	}
	
	public OrderItem getOrderItemByOrderIdAndProductId(Long productId, Long orderId) {
		
		return ordersMapper.getOrderItemByOrderIdAndProductId(productId, orderId);
		
	}
	
	public ProductItemResponseDTO OrderItemTOProductItemResponseDTO(OrderItem orderItem) {
		
		return new ProductItemResponseDTO(
					orderItem.getProductId(),
					orderItem.getQuantity(),
					orderItem.getTotalPrice()
				);
	}
	
	public OrdersResponseDTO OrdersToOrdersDTO(Orders order) {
		
//		return new OrderResponseDTO(
//					order.getCustomerId(),
//					
//					order.getTotalQuantity(),
//					order.getOrderPriceTotal()
//				);
		
		return null;
		
	}

}
