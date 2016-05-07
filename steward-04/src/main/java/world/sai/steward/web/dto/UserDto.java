package world.sai.steward.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String name;

    private Integer age;

    private String loginId;

    private String birthday;
}
