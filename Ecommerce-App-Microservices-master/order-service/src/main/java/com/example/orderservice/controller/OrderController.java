package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderRequestDto;
import com.example.orderservice.service.IOrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import jakarta.annotation.security.RolesAllowed;
import lombok.extern.log4j.Log4j2;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@Log4j2

public class OrderController {

    @Autowired
    IOrderService orderService;
    public void setTraceAndSpanId() {
        String traceId = UUID.randomUUID().toString();
        String spanId = UUID.randomUUID().toString();

        log.info("Setting traceId and spanId");
        MDC.put("traceId", traceId);
        MDC.put("spanId", spanId);
        log.info("TraceId: {}, SpanId: {}", traceId, spanId);

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory",fallbackMethod = "fallbackMethod")
    @RolesAllowed("ROLE_ADMIN")
//    @TimeLimiter(name = "inventory")
//    @Retry(name = "inventory")
    public String placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        setTraceAndSpanId();
        log.info("inside order controller");
       return orderService.placeOrder(orderRequestDto);
    }

    public String fallbackMethod(OrderRequestDto orderRequestDto, RuntimeException runtimeException){
        return "Oops! Something went wrong, please try after sometime";
    }
}





