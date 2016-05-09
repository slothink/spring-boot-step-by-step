package world.sai.steward.web.mapper;

import static javax.security.auth.login.Configuration.getConfiguration;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import world.sai.steward.core.user.User;
import world.sai.steward.util.ISO8601Utils;
import world.sai.steward.web.dto.UserDto;

@Service
public class Object2ObjectMapper extends ModelMapper {

    @PostConstruct
    public void init() {
        this.createTypeMap(Date.class, String.class).setConverter(new Converter<Date, String>() {
            public String convert(MappingContext<Date, String> context) {
                return ISO8601Utils.format(context.getSource(), true);
            }
        });
        getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
    }

    public UserDto toUserDto(User user) {
        return this.map(user, UserDto.class);
    }

}
