package com.ecommerce.api_gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;

@Component
public class EcommerceApiAuthFilter extends AbstractGatewayFilterFactory<EcommerceApiAuthFilter.Config> {

	@Autowired
	private RouteValidator validator;

	@Autowired
	private JwtUtil jwtUtil;

	public EcommerceApiAuthFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {

		String AUTH_PREFIX = "Bearer ";

		return ((exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();

			boolean isSecuredApiRoute = validator.isSecuredRoute.test(request);
			HttpHeaders headers = request.getHeaders();
			// header contains token or not
			boolean hasAuthHeader = headers.containsKey(HttpHeaders.AUTHORIZATION);

			if (isSecuredApiRoute) {
				if (!hasAuthHeader) {
					throw new JwtException("Token Not found");
				}

				String token = headers.get(HttpHeaders.AUTHORIZATION).get(0);

				if (token != null && token.startsWith(AUTH_PREFIX)) {
					token = token.substring(AUTH_PREFIX.length());
				}

				// could use Auth Service, but validating JWT is faster & secure way
				jwtUtil.validateToken(token);
				var subject = jwtUtil.extractUsername(token);
				request = request.mutate().header("userId", subject).build();

			}
			return chain.filter(exchange.mutate().request(request).build());

		});

	}

	public static class Config {

	}
}