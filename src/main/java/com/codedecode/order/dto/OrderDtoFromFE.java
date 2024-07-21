package com.codedecode.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDtoFromFE {

	private List<FoodItemDto> foodItemsList;
	private Integer userId;
	private RestaurantDto restaurant;
}
