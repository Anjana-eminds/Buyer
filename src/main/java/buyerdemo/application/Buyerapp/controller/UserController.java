package buyerdemo.application.Buyerapp.controller;

import buyerdemo.application.Buyerapp.dto.UserDto;
import buyerdemo.application.Buyerapp.entities.User;
import buyerdemo.application.Buyerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Object saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @GetMapping("/users")
    public Object fetchUserList(){
        return userService.fetchUserList();
    }

    @GetMapping("/users/{id}")
    public Object fetchUserById(@PathVariable("id") Long userId){
        return userService.fetchUserById(userId);
    }

    @PutMapping("/users/{id}")
    public Object updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userUpdateDto) throws Exception{
        return userService.updateUser(userId, userUpdateDto);
    }

    @PutMapping("/status/{id}")
    public Object statusUpdateForUser(@PathVariable(value = "id") Long id) throws Exception {
        return userService.statusUpdate(id);
    }

    @DeleteMapping("/users/{id}")
    public Object deleteUserById(@PathVariable("id") Long id) throws Exception{
        return userService.deleteUserById(id);
    }

}
