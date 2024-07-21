package com.codedecode.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.order.dto.OrderDto;
import com.codedecode.order.dto.OrderDtoFromFE;
import com.codedecode.order.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFE orderDetails){
		return new ResponseEntity<OrderDto>(orderService.saveOrder(orderDetails), HttpStatus.CREATED);
	}
}
