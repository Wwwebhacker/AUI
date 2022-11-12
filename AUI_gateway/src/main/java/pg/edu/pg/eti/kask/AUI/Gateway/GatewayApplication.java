package pg.edu.pg.eti.kask.AUI.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route("users", r -> r
						.host("localhost:8080")
						.and()
						.path("/api/companies/{id}", "/api/companies")
						.uri("http://localhost:8081"))
				.route("characters", r -> r
						.host("localhost:8080")
						.and()
						.path("/api/workers", "/api/workers/**", "/api/companies/{id}/workers", "/api/companies/{id}/workers/**")
						.uri("http://localhost:8082"))
				.build();
	}
}
