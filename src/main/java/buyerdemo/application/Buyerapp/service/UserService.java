package buyerdemo.application.Buyerapp.service;

import buyerdemo.application.Buyerapp.entities.User;

import java.util.List;

public interface UserService {

    Object saveUser(User user);
    List<User> fetchUserList();
    User fetchUserById(Long id);
    Object updateUser(Long id, User user) throws Exception;
    void deleteUserById(Long id);
}
