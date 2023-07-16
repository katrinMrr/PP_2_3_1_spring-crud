package springBoot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springBoot.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
