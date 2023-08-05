package buyerdemo.application.Buyerapp.service;

import buyerdemo.application.Buyerapp.dto.UserDto;
import buyerdemo.application.Buyerapp.entities.User;

import java.util.List;

public interface UserService {

    Object saveUser(UserDto userDto);

    Object fetchUserList();

    Object fetchUserById(Long id);

    Object updateUser(Long id, UserDto userUpdateDto) throws Exception;

    Object statusUpdate(Long id) throws Exception;

    Object deleteUserById(Long id) throws Exception;
}
