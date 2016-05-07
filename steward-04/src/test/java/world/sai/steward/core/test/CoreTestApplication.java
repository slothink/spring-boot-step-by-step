package world.sai.steward.core.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import world.sai.steward.core.StewardCoreConfig;

/**
 * Created by sai on 2016. 4. 14..
 */
@EnableAutoConfiguration
@Import(value={StewardCoreConfig.class})
public class CoreTestApplication {

}
