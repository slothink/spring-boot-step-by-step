package world.sai.steward.core.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sai on 2016. 4. 14..
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
