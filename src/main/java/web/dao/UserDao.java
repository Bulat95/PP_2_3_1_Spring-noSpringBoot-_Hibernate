package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getListUsers();
    void updateUserById(Long id, User user);
    void removeUserById(Long id);
    User findUserById(Long id);
}
