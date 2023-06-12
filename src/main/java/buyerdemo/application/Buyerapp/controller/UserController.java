package buyerdemo.application.Buyerapp.controller;

import buyerdemo.application.Buyerapp.entities.User;
import buyerdemo.application.Buyerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Object saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> fetchUserList(){
        return userService.fetchUserList();
    }

    @GetMapping("/users/{id}")
    public Object fetchUserById(@PathVariable("id") Long userId){
        return userService.fetchUserById(userId);
    }

    @PutMapping("/users/{id}")
    public Object updateUser(@PathVariable("id") Long userId, @RequestBody User user) throws Exception{
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/users/{id}")
    public Object deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUserById(userId);
        return "User deleted successfully";
    }
}
