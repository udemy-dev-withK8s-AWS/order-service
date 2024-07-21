package com.codedecode.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.codedecode.order.dto.FoodItemDto;
import com.codedecode.order.dto.RestaurantDto;
import com.codedecode.order.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {

	private Integer orderId;
	private List<FoodItemDto> foodItemsList;
	private RestaurantDto restaurant;
	private UserDto user;
}
