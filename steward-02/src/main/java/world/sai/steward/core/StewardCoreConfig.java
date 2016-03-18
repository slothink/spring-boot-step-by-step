package world.sai.steward.core;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 비즈니스 로직 설정
 */
@Configuration
@ComponentScan(basePackages = "world.sai.steward.core")
public class StewardCoreConfig {

}
