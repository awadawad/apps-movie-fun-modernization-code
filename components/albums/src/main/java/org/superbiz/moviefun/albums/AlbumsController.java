package org.superbiz.moviefun.albums;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private AlbumsRepository albumsRepository;

    public AlbumsController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity addAlbum(@RequestBody Album album) {
        albumsRepository.addAlbum(album);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Album>> index() {
        return new ResponseEntity<>(albumsRepository.getAlbums(), HttpStatus.OK);
    }

    @GetMapping("/{albumId}")
    public Album details(@PathVariable long albumId) {
        return albumsRepository.find(albumId);
    }
}
