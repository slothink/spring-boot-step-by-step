package world.sai.steward.web.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import world.sai.steward.util.ISO8601Utils;
import world.sai.steward.web.model.ApiResult;
import world.sai.steward.web.test.MvcTester;

public class UserControllerTest extends MvcTester {

    private String apiEndPoint;

    @Before
    public void setUp() {
        apiEndPoint = "http://localhost:"+port+"/rest/v1/users";
    }

    @Test
    public void testUserPost() {
        UserController.CreateUserRequest command = new UserController.CreateUserRequest();
        command.setLoginId(UUID.randomUUID().toString());
        command.setAge(33);
        command.setName("sai");
        command.setBirthday("1984-09-11T02:33:45+09:00");

        HttpHeaders headers = new HttpHeaders();
        headers.add("http header key", "a value"); // just describe for how to write a header
        HttpEntity httpEntity = new HttpEntity<>(command, headers);

        ResponseEntity<ApiResult> result = restTemplate.exchange(apiEndPoint, HttpMethod.POST, httpEntity, ApiResult.class);
        Map data = (Map)result.getBody().getData();

        assertThat(data.get("id"), is(not(nullValue())));
        assertThat(data.get("loginId"), is(command.getLoginId()));
        assertThat(data.get("age"), is(33));
        assertThat(data.get("name"), is("sai"));
        assertThat(ISO8601Utils.parse((String)data.get("birthday")).getTime(), is(ISO8601Utils.parse("1984-09-11T02:33:45+09:00").getTime()));
    }
}
