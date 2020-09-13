package ovh.piwowarczyk.votr.api.v1.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ovh.piwowarczyk.votr.model.User;
import ovh.piwowarczyk.votr.services.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/management/users")
public class UserController {

    @Autowired
    @Qualifier("HibernateUserService")
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        userService.createNew(user);
        return "User " + user.getUserID() + " created successfully";
    }
    @PutMapping("{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody User user){
        userService.updateExisting(user);
        return "User " + user.getUserID() + " updated successfully";
    }
}
