package org.superbiz.moviefun.albums;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.superbiz.moviefun.albumsapi.AlbumsController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"org.superbiz:album-service:+:stubs:6565"}, workOffline = true)
@ActiveProfiles("development")
public class AlbumsControllerIntegrationTest {

    @Autowired
    AlbumsController albumsController;

    @Test
    public void shouldReturnAlbumsInRequestCtx() {

        // Given
        Map<String, Object> model = new HashMap<>();

        // When
        albumsController.index(model);

        // Then
        assertThat(model.get("albums")).isNotNull();
        assertThat(((List<?>) model.get("albums")).size()).isNotNull();
    }

}
