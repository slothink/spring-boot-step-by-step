package world.sai.steward.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sai on 2016. 3. 18..
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User findOne(Long id) {
        return dao.findOne(id);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public User create(User user) {
        return dao.create(user);
    }

    @Override
    public User update(User user) {
        return dao.update(user);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
