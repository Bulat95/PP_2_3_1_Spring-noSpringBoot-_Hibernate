package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getListUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void updateUserById(Long id, User updateUser) {
        User anotherUser = findUserById(id);

        anotherUser.setFirstName(updateUser.getFirstName());
        anotherUser.setLastName(updateUser.getLastName());
        anotherUser.setEmail(updateUser.getEmail());

        entityManager.merge(anotherUser);
    }

    @Override
    public void removeUserById(Long id) {
        entityManager.remove(findUserById(id));
    }

    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
