package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class InventoryRestTemplate {
    private  final WebClient.Builder webClient;
    @Autowired
    @Lazy
    private RestTemplate restTemplate;



    public InventoryRestTemplate(WebClient.Builder webClient) {
        this.webClient = webClient;
    }


    public Mono<Boolean> callApiEndpoint(String skuCode, int quantity) {
        System.out.println("calll");
        String apiUrl = "http://INVENTORY-SERVICE/api/inventory";

        String urlWithParams = String.format("%s?skucode=%s&quantity=%d", apiUrl, skuCode, quantity);

        return webClient.build().get()
                .uri(urlWithParams)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Boolean.class)
                .timeout(Duration.ofSeconds(60))
                .onErrorResume(ex -> {
                    ex.printStackTrace();
                    System.err.println("Error calling inventory service: " + ex.getMessage());
                    return Mono.just(false); // Or handle the error as needed
                });

    }



    public Boolean callApiEndpoint2(String skuCode, int quantity) {
        System.out.println("calll");
        String apiUrl = "http://inventory-service/api/inventory";

      String urlWithParams = String.format("%s?skucode=%s&quantity=%d", apiUrl, skuCode, quantity);
        System.out.println("url::"+urlWithParams);
            ResponseEntity<Boolean> response = restTemplate.exchange(
                    urlWithParams,
                    HttpMethod.GET,
                    new HttpEntity<>(null, getHeaders()),
                    Boolean.class
            );
            return response.getBody();
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // Add any additional headers if needed
        return headers;
    }
}
