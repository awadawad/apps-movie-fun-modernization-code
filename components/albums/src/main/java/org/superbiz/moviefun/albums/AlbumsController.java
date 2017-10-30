package org.superbiz.moviefun.albums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private static final Logger logger = LoggerFactory.getLogger(AlbumsController.class);

    private AlbumsRepository albumsRepository;

    public AlbumsController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        logger.debug("Creating album for artist {}, and title {}", album.getArtist(), album.getTitle());
        albumsRepository.addAlbum(album);
    }

    @DeleteMapping("/{albumId}")
    public void deleteAlbumId(@PathVariable Long albumId) {
        Album album = albumsRepository.find(albumId);
        albumsRepository.deleteAlbum(album);
    }

    @GetMapping
    public List<Album> index() {
        logger.debug("Returning albums");
        return albumsRepository.getAlbums();
    }

    @GetMapping("/{albumId}")
    public Album getById(@PathVariable long albumId) {
        return albumsRepository.find(albumId);
    }
}