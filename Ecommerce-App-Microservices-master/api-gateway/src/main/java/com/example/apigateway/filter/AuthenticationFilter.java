package com.example.apigateway.filter;

import com.example.apigateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {


    @Autowired
    private RouteValidator routeValidator;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
          return (((exchange, chain) -> {
              if(routeValidator.isSecured.test(exchange.getRequest())){
                  if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
                  {
                      throw  new RuntimeException("missing auth header");
                  }
                  String authHeaders = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                  if(authHeaders!=null){
                      authHeaders = authHeaders.substring(7);
                  }
                  try{
                      System.out.println("auth::"+authHeaders);
                   // restTemplate.getForObject("http://localhost:9898/auth/validate?token"+authHeaders,String.class);
                 jwtUtil.validateToken(authHeaders);
                  }
                  catch (Exception e){
                      e.printStackTrace();
                      System.out.println("invalid access");
                      throw  new RuntimeException("un authorized access to the app");
                  }
              }
              return chain.filter(exchange);
          }));
    }

    public static class Config {

    }


}
