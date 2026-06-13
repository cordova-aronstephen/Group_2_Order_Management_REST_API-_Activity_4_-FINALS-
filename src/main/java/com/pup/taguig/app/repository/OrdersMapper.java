package com.pup.taguig.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pup.taguig.app.model.OrderItem;
import com.pup.taguig.app.model.Orders;

@Mapper
public interface OrdersMapper {
	
	public Long insertOrder(Orders order);
	public Orders getOrderById(Long id);
	public Long insertOrderItem(OrderItem orderItem);
	public List<OrderItem> retrieveAllOrderItemByOrderId(Long orderId);
	public List<Orders> retrieveAllOrdersByCustomerId(Long customerId);
	public Boolean deleteOrderById(Long id);
}
