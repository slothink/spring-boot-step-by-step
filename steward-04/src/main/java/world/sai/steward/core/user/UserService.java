package world.sai.steward.core.user;

import java.util.List;

/**
 * Created by sai on 2016. 3. 18..
 */
public interface UserService {
    User findOne(Long id);

    List<User> getAllUsers();

    User create(User user) throws DuplicateLoginIdException;

    User update(User user);

    void delete(Long id);
}
