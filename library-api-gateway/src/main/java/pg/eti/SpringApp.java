package pg.eti;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;


@SpringBootApplication
@EnableDiscoveryClient
public class SpringApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
        RouteLocatorBuilder builder,
        @Value("${library.gateway.front.host}") String frontHost,
        @Value("${library.gateway.user.host}") String userHost
    ) {
        return builder
                .routes()
                .route("fbooks", route -> route
                        .host(frontHost)
                        .and()
                        .path(
                                "/api/books/{id}",
                                "/api/books"
                        )
                        .uri("lb://library-api-books")
                )
                .route("ubooks", route -> route
                        .host(userHost)
                        .and()
                        .path(
                                "/api/books/{id}",
                                "/api/books"
                        )
                        .uri("lb://library-api-books")
                )
                .route("fpublishing-houses", route -> route
                        .host(frontHost)
                        .and()
                        .path(
                                "/api/publishing-houses/{id}",
                                "/api/publishing-houses"
                        )
                        .uri("lb://library-api-publishing-houses")
                )
                .route("upublishing-houses", route -> route
                        .host(userHost)
                        .and()
                        .path(
                                "/api/publishing-houses/{id}",
                                "/api/publishing-houses"
                        )
                        .uri("lb://library-api-publishing-houses")
                )
                .build();
    }

    @Bean
    public CorsWebFilter corsWebFilter() {
        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "PATCH", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }


}
