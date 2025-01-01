package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequestDto;

public interface IOrderService {
    public String placeOrder(OrderRequestDto orderRequestDto);
}
