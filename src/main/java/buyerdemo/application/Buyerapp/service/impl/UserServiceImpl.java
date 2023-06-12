package buyerdemo.application.Buyerapp.service.impl;

import buyerdemo.application.Buyerapp.dto.UserDto;
import buyerdemo.application.Buyerapp.entities.User;
import buyerdemo.application.Buyerapp.repository.UserRepository;
import buyerdemo.application.Buyerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Object saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException();
        }
        return optionalUser.get();
    }

    @Override
    public Object updateUser(Long id, User updateRequestBody) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new Exception("");
        }
        User user = optionalUser.get();

        if (Objects.nonNull(updateRequestBody.getFirstName())){
            user.setPassword(updateRequestBody.getPassword());
        }
        if (Objects.nonNull(updateRequestBody.getMiddleName())){
            user.setMiddleName(updateRequestBody.getMiddleName());
        }
        if (Objects.nonNull(updateRequestBody.getLastName())){
            user.setLastName(updateRequestBody.getLastName());
        }
        if(Objects.nonNull(updateRequestBody.getEmail())) {
            user.setEmail(updateRequestBody.getEmail());
        }
        if (Objects.nonNull(updateRequestBody.getPhoneNumber())){
            user.setPhoneNumber(updateRequestBody.getPhoneNumber());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    private UserDto mapToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setMiddleName(user.getMiddleName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setPassword(user.getPassword());
        userDto.setOtp(user.getOtp());
        userDto.setStatus(user.getStatus());
        userDto.setCountWrongPasssword(user.getCountWrongPasssword());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUpdatedAt(user.getUpdatedAt());
        return userDto;
    }

    private User mapToEntity(UserDto userDto){
        User user =new User();
        user.setUserId(userDto.getUserId());
        user.setFirstName(userDto.getFirstName());
        user.setMiddleName(userDto.getMiddleName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        user.setOtp(userDto.getOtp());
        user.setStatus(userDto.getStatus());
        user.setCountWrongPasssword(userDto.getCountWrongPasssword());
        user.setCreatedAt(userDto.getCreatedAt());
        user.setUpdatedAt(userDto.getUpdatedAt());
        return user;
    }
}
