package org.superbiz.moviefun.albumsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class AlbumsClient {

    private RestTemplate restTemplate;

    private String albumsUrl;

    public AlbumsClient(String albumsUrl, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.albumsUrl = albumsUrl;
    }

    public List<AlbumInfo> getAlbums() {

        return restTemplate.exchange(
                albumsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AlbumInfo>>() {}).getBody();
    }

    public AlbumInfo find(long albumId) {
        return restTemplate.getForEntity(String.format("%s/%s", albumsUrl, albumId),
                AlbumInfo.class).getBody();
    }

    public void addAlbum(AlbumInfo album) {
        restTemplate.postForEntity(albumsUrl, album, AlbumInfo.class);
    }
}
