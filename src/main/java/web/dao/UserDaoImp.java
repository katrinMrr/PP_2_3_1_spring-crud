package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }
}
