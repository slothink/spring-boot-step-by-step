package world.sai.steward.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.sai.steward.core.StewardCoreConfig;
import world.sai.steward.web.StewardWebConfig;

/**
 * Created by sai on 2016. 3. 7..
 */
@RestController
@Import(value={StewardCoreConfig.class, StewardWebConfig.class})
@EnableAutoConfiguration
public class Application {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
