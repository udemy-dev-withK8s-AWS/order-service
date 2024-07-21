package com.codedecode.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codedecode.order.dto.OrderDto;
import com.codedecode.order.dto.OrderDtoFromFE;
import com.codedecode.order.dto.UserDto;
import com.codedecode.order.entity.Order;
import com.codedecode.order.mapper.OrderMapper;
import com.codedecode.order.repo.OrderRepo;

@Service
public class OrderService {
	
	public static final String USER_SERVICE_URL = "http://USERINFO-SERVICE/user/fetchUserById/";

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	SequenceGenerator sequenceGenerator;
	
	@Autowired
	RestTemplate restTemplate;
	
	public OrderDto saveOrder(OrderDtoFromFE orderDetails) {
		
		Integer newOrderId = sequenceGenerator.generateNextOrderId();
		UserDto userDto = fetchUserDetailsFromUserId(orderDetails.getUserId());
		
		Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDto);
		orderRepo.save(orderToBeSaved);
		
		return OrderMapper.INSTANCE.mapOrderToOrderDto(orderToBeSaved);
	}
	
	private UserDto fetchUserDetailsFromUserId(Integer userId) {
		
		return restTemplate.getForObject(USER_SERVICE_URL+userId, UserDto.class);
	}
}
