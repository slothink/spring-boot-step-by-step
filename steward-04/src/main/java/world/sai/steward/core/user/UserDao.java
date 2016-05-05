package world.sai.steward.core.user;

import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by sai on 2016. 3. 18..
 */
@Repository
public class UserDao {

    private Map<Long, User> dataInMemory = new HashMap<>();

    public User findOne(Long id) {
        return dataInMemory.get(id);
    }

    public List<User> getAllUsers() {
        Collection<User> users = dataInMemory.values();
        return new ArrayList<>(users);
    }

    public User create(User user) {
        dataInMemory.put(user.getId(), user);
        return user;
    }

    public User update(User user) {
        dataInMemory.put(user.getId(), user);
        return user;
    }

    public void delete(Long id) {
        dataInMemory.remove(id);
    }
}
