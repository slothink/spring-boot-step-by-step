package world.sai.steward.core;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 비즈니스 로직 설정
 */
@Configuration
@EnableJpaRepositories(basePackages = "world.sai.steward.core")
@EntityScan("world.sai.steward.core")
@ComponentScan(basePackages = "world.sai.steward.core")
public class StewardCoreConfig {

}
