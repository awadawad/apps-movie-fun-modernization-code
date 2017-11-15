package org.superbiz.moviefun.albums;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class VerificationTest {

    @Before
    public void setup() {
        AlbumsRepository albumsRepository = mock(AlbumsRepository.class);

        Album album1 = new Album("Massive Attack", "Mezzanine", 1998, 9);
        album1.setId(1L);

        Album album2 = new Album("Radiohead", "OK Computer", 1997, 8);
        album2.setId(2L);

        List<Album> albums = Arrays.asList(album1, album2);

        when(albumsRepository.getAlbums()).thenReturn(albums);
        RestAssuredMockMvc.standaloneSetup(new AlbumsController(albumsRepository));
    }
}
