package world.sai.steward.web.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import world.sai.steward.bootstrap.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port:0", "spring.datasource.url:jdbc:h2:mem:bookmark;DB_CLOSE_ON_EXIT=FALSE", "spring.datasource.driver-class-name:org.h2.Driver", "spring.jpa.hibernate.ddl-auto: update"})
public class MvcTester {

    @Value("${local.server.port}")
    protected  int port;

    protected RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testRun() {

    }

}
