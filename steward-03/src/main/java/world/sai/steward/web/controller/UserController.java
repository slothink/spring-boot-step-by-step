package world.sai.steward.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import world.sai.steward.core.user.User;
import world.sai.steward.core.user.UserService;
import world.sai.steward.web.model.ApiResult;

import java.util.List;

/**
 * Created by sai on 2016. 3. 18..
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 사용자를 등록한다
     * @param command 등록할 사용자 정보
     * @return 등록된 사용자 정보를 담은 Api 처리 결과
     */
    @RequestMapping(value = "/rest/v1/users", method = RequestMethod.POST)
    public ApiResult<User> add(@RequestBody User command) {
        try {
            User createdUser =  userService.create(command);
            return new ApiResult<>(createdUser);
        }catch(RuntimeException e) {
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

}
