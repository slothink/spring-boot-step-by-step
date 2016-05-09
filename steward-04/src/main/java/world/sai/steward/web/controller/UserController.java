package world.sai.steward.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;
import world.sai.steward.core.user.DuplicateLoginIdException;
import world.sai.steward.core.user.User;
import world.sai.steward.core.user.UserService;
import world.sai.steward.util.ISO8601Utils;
import world.sai.steward.web.dto.UserDto;
import world.sai.steward.web.mapper.Object2ObjectMapper;
import world.sai.steward.web.model.ApiErrorCode;
import world.sai.steward.web.model.ApiErrorType;
import world.sai.steward.web.model.ApiResult;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Created by sai on 2016. 3. 18..
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private Object2ObjectMapper mapper;

    /**
     * 사용자를 등록한다
     * @param command 등록할 사용자 정보
     * @return 등록된 사용자 정보를 담은 Api 처리 결과
     */
    @RequestMapping(value = "/rest/v1/users", method = RequestMethod.POST)
    public ApiResult<UserDto> add(@RequestBody CreateUserRequest command) {
        try {
            User user = new User();
            user.setName(command.getName());
            user.setBirthday(ISO8601Utils.parse(command.getBirthday()));
            user.setLoginId(command.getLoginId());
            user.setAge(command.getAge());
            User createdUser =  userService.create(user);
            return new ApiResult<>(mapper.toUserDto(createdUser));
        }catch (DuplicateLoginIdException e) {
            return new ApiResult<>(ApiErrorType.MESSAGE, ApiErrorCode.DUPLICATE_CODE, "로그인 ID가 중복됩니다");
        } catch(RuntimeException e) {
            return new ApiResult<>(e);
        }
    }

    /**
     * 특정 한 사용자를 조회한다
     * @return 등록된 사용자 정보를 담은 Api 처리 결과
     */
    @RequestMapping(value = "/rest/v1/users/{id}", method = RequestMethod.GET)
    public ApiResult<User> add(@PathVariable("id")Long id) {
        try {
            User user =  userService.findOne(id);
            return new ApiResult<>(user);
        }catch(RuntimeException e) {
            return new ApiResult<>(e);
        }
    }

    /**
     * 사용자 전체 조회
     * @return 사용자 리스트를 담은 Api 처리 결과
     */
    @RequestMapping(value = "/rest/v1/users", method = RequestMethod.GET)
    public ApiResult<List<User>> getUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return new ApiResult<>(users);
        }catch(RuntimeException e) {
            return new ApiResult<>(e);
        }
    }

    /**
     * 사용자를 삭제한다
     * @param id 사용할 사용자 ID
     * @return Api 처리 결과
     */
    @RequestMapping(value = "/rest/v1/users/{id}", method = RequestMethod.DELETE)
    public ApiResult delete(@PathVariable("id")Long id) {
        try {
            userService.delete(id);
            return new ApiResult();
        }catch(RuntimeException e) {
            return new ApiResult<>(e);
        }
    }

    @Getter
    @Setter
    public static class CreateUserRequest {

        private String name;

        private Integer age;

        private String loginId;

        private String birthday;
    }
}
