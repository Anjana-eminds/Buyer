package buyerdemo.application.Buyerapp.service.impl;

import buyerdemo.application.Buyerapp.dto.UserDto;
import buyerdemo.application.Buyerapp.entities.Status;
import buyerdemo.application.Buyerapp.entities.User;
import buyerdemo.application.Buyerapp.repository.UserRepository;
import buyerdemo.application.Buyerapp.service.UserService;
import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Object saveUser(UserDto userDto) {
        Date currentDate = new java.util.Date();
        User user = User.builder()
                .firstName(userDto.getFirstName())
                .middleName(userDto.getMiddleName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .address(userDto.getAddress())
                .password(userDto.getPassword())
                .status(Status.ACTIVE)
                .createdAt(currentDate)
                .build();
        userRepository.save(user);
        return HttpStatus.OK;
    }

    @Override
    public Object fetchUserList() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(User -> modelMapper.map(User, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Object fetchUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException();
        }
        User user = optionalUser.get();
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public Object updateUser(Long id, UserDto updateUserDto) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new Exception("Not found");
        }
        User user = optionalUser.get();
        if (Objects.nonNull(updateUserDto.getFirstName()) && !"".equalsIgnoreCase(updateUserDto.getFirstName())){
            user.setFirstName(updateUserDto.getFirstName());
        }
        if (Objects.nonNull(updateUserDto.getMiddleName()) && !"".equalsIgnoreCase(updateUserDto.getMiddleName())){
            user.setMiddleName(updateUserDto.getMiddleName());
        }
        if (Objects.nonNull(updateUserDto.getLastName()) && !"".equalsIgnoreCase(updateUserDto.getLastName())){
            user.setLastName(updateUserDto.getLastName());
        }
        if (Objects.nonNull(updateUserDto.getEmail()) && !"".equalsIgnoreCase(updateUserDto.getEmail())){
            user.setEmail(updateUserDto.getEmail());
        }
        if (Objects.nonNull(updateUserDto.getPhoneNumber()) && !"".equalsIgnoreCase(updateUserDto.getPhoneNumber())){
            user.setPhoneNumber(updateUserDto.getPhoneNumber());
        }
        if (Objects.nonNull(updateUserDto.getAddress()) && !"".equalsIgnoreCase(updateUserDto.getAddress())){
            user.setAddress(updateUserDto.getAddress());
        }
        if (Objects.nonNull(updateUserDto.getPassword()) && !"".equalsIgnoreCase(updateUserDto.getPassword())){
            user.setPassword(updateUserDto.getPassword());
        }
        userRepository.save(user);
        return ResponseEntity.ok("Profile updated successfully ");
    }

    @Override
    public Object statusUpdate(Long id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new Exception("User Not Found!!");
        }
        User user = optionalUser.get();
        userRepository.updateStatusForUser(id, user.getStatus());
        return "User status updated successfully";
    }

    @Override
    public Object deleteUserById(Long id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new Exception("User Not Found!!");
        }
        userRepository.deleteUser(id);
        return "User deleted successfully";
    }

}
