package com.pup.taguig.app.repository;

import org.apache.ibatis.annotations.Mapper;

import com.pup.taguig.app.model.OrderItem;
import com.pup.taguig.app.model.Orders;

@Mapper
public interface OrdersMapper {
	
	public Long insertOrder(Orders order);
	public Orders getOrderById(Long id);
	public Long insertOrderItem(OrderItem orderItem);
	public OrderItem getOrderItemByOrderIdAndProductId(Long productId, Long orderId);
}
