package org.superbiz.moviefun.albums

import org.junit.ClassRule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule
import org.springframework.test.context.ActiveProfiles
import org.superbiz.moviefun.albumsapi.AlbumsController
import spock.lang.Shared
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("development")
class AlbumsControllerSpec extends Specification {

    @Autowired
    AlbumsController albumsController

    @ClassRule
    @Shared
    StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .workOffline(true)
            .downloadStub("org.superbiz:album-service:+:stubs:6565")

    def 'it should return albums in context'() {
        given:
        def modelMap = new HashMap<>();

        when:
        albumsController.index(modelMap)

        then:
        assertThat(modelMap["albums"]).isNotNull();
        assertThat(((List<?>) modelMap["albums"]).size()).isNotNull();
    }

}
