package world.sai.steward.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Created by sai on 2016. 3. 18..
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<User> getAllUsers() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public User create(User user) throws DuplicateLoginIdException {
        if(repository.findByLoginId(user.getLoginId()) != null) {
            throw new DuplicateLoginIdException();
        }
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return user;
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

}
