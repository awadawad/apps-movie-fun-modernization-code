package org.superbiz.moviefun.moviesapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class MoviesClient {

    private String moviesUrl;
    private RestTemplate restTemplate;

    public MoviesClient(String moviesUrl, RestTemplate restTemplate) {
        this.moviesUrl = moviesUrl;
        this.restTemplate = restTemplate;
    }

    public void addMovie(MovieInfo movie) {
        restTemplate.postForEntity(moviesUrl, movie, MovieInfo.class);
    }

    public void deleteMovieId(Long movieId) {
        restTemplate.delete(moviesUrl + "/" + movieId);
    }

    public int countAll() {
        return restTemplate.getForObject(moviesUrl + "/count", Integer.class);
    }


    public int count(String field, String key) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(moviesUrl + "/count")
                .queryParam("field", field)
                .queryParam("key", key);

        return restTemplate.getForObject(builder.toUriString(), Integer.class);
    }


    public List<MovieInfo> findAll(int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(moviesUrl)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<MovieInfo>>() {}).getBody();
    }

    public List<MovieInfo> findRange(String field, String key, int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(moviesUrl)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<MovieInfo>>() {}).getBody();
    }

    public List<MovieInfo> getMovies() {
        return restTemplate.exchange(moviesUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<MovieInfo>>() {}).getBody();
    }
}
