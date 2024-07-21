package com.codedecode.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.codedecode.order.dto.OrderDto;
import com.codedecode.order.entity.Order;

@Mapper
public interface OrderMapper {

	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
	
	Order mapOrderDtoToOrder(OrderDto orderDto);
	OrderDto mapOrderToOrderDto(Order order);
}
