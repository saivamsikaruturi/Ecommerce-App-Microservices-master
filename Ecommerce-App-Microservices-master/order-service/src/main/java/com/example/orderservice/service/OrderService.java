package com.example.orderservice.service;

import com.example.orderservice.InventoryRestTemplate;
import com.example.orderservice.dto.OrderRequestDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.event.OrderPlacedEvent;
import com.example.orderservice.repository.order.OrderRepository;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RefreshScope
public class OrderService implements IOrderService{


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    InventoryRestTemplate inventoryRestTemplate;

    @Autowired
    KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;

    @Autowired
    ObservationRegistry observationRegistry;

    @Override
    public String placeOrder(OrderRequestDto orderRequestDto) {
        // Assuming inventoryRestTemplate is a RestTemplate bean configured with @LoadBalanced
        // and is capable of load balancing requests to the inventory service

        // Start an observation for the inventory service lookup
        Observation inventoryServiceObservation = Observation.createNotStarted("inventory-service-lookup",
                this.observationRegistry);
        inventoryServiceObservation.lowCardinalityKeyValue("call", "inventory-service");

        // Observe the operation using the observation framework
     //   return inventoryServiceObservation.observe(() -> {
            // Call the API endpoint in the inventory service using the load-balanced RestTemplate
            Boolean aBoolean = inventoryRestTemplate.callApiEndpoint2(orderRequestDto.getSkuCode(),
                    orderRequestDto.getQuantity());// Process the response from the inventory service
            if (aBoolean) {
                // map order request to order
                Order order = new Order();
                order.setId(orderRequestDto.getId());
                order.setOrderNumber(UUID.randomUUID().toString());
                order.setPrice(orderRequestDto.getPrice());
                order.setQuantity(orderRequestDto.getQuantity());
                order.setSkuCode(orderRequestDto.getSkuCode());
                order.setProductDescription(orderRequestDto.getDescription());
                Order save = orderRepository.save(order);

              // Send order placed event to Kafka
                kafkaTemplate.send("notificationTopic", new OrderPlacedEvent(order.getOrderNumber()));

                return "Order placed successfully";
            } else {
                // Handle unsuccessful response from the inventory service
                return "Failed to place order. Inventory service returned ";
            }
      //  });
    }

}
