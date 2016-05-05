package world.sai.steward.core.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by sai on 2016. 4. 14..
 */
public class UserRepositoryTest extends DefaultTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCRUD() {
        User user = new User();
        user.setName("test");
        user = userRepository.save(user);
        assertThat(user, is(not(nullValue())));
        assertThat(user.getId(), is(not(nullValue())));

        User user2 = userRepository.findOne(user.getId());
        assertThat(user2.getName(), is("test"));

        userRepository.delete(user2);


    }
}
