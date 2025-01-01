//package com.example.apigateway.routes;
//
//import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
//import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.function.RequestPredicate;
//import org.springframework.web.servlet.function.RequestPredicates;
//import org.springframework.web.servlet.function.RouterFunction;
//import org.springframework.web.servlet.function.ServerResponse;
//
//import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
//
//@Configuration
//public class Routes {
//
//    @Bean
//    public RouterFunction<ServerResponse> productService() {
//        return GatewayRouterFunctions.route("product-service")
//                .route(RequestPredicates.path("/product/"),HandlerFunctions.http(lb("product-service")))
//                .filter(lb("apiservice"))
//                .build();
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> inventoryService() {
//        return GatewayRouterFunctions.route("inventory-service")
//                .route(RequestPredicates.path("/api/inventory"),
//                        r -> r.uri("lb://INVENTORY-SERVICE"))
//                .build();
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> orderService() {
//        return GatewayRouterFunctions.route("order-service")
//                .route(RequestPredicates.path("/api/order"),
//                        r -> r.uri("lb://ORDER-SERVICE"))
//                .build();
//    }
//}
