package pg.eti;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
        RouteLocatorBuilder builder,
        @Value("${library.book.url}") String bookUrl,
        @Value("${library.publishing-house.url}") String publishingHouseUrl,
        @Value("${library.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("books", route -> route
                                .host(host)
                                .and()
                                .path(
                                        "/api/books/{id}",
                                        "/api/books"
                                )
                                .uri(bookUrl)
                        )
                .route("publishing-houses", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/publishing-houses/{id}",
                                "/api/publishing-houses"
                        )
                        .uri(publishingHouseUrl)
                )
                .build();
    }
}
