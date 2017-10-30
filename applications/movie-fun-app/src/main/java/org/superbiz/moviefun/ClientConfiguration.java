package org.superbiz.moviefun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.superbiz.moviefun.albumsapi.AlbumsClient;
import org.superbiz.moviefun.moviesapi.MoviesClient;

@Configuration
public class ClientConfiguration {

    @Value("${movies.url}") String moviesUrl;
    @Value("${albums.url}") String albumsUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public MoviesClient moviesClient(RestTemplate restTemplate) {
        return new MoviesClient(moviesUrl, restTemplate);
    }

    @Bean
    public AlbumsClient albumsClient(RestTemplate restTemplate) {
        return new AlbumsClient(albumsUrl, restTemplate);
    }
}
