package com.ecommerce.api_gateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiRoutes = List.of(
            "/auth/signup",
            "/auth/login",
            "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecuredRoute =
            request -> openApiRoutes
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}