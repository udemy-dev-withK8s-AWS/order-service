package com.codedecode.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

	private Integer orderId;
	private List<FoodItemDto> foodItemsList;
	private RestaurantDto restaurant;
	private UserDto user;

}
