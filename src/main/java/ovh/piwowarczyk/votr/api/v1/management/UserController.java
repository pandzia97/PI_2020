package ovh.piwowarczyk.votr.api.v1.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ovh.piwowarczyk.votr.model.User;
import ovh.piwowarczyk.votr.services.UserService;

import java.util.List;

/**
 * <p>Kontroler REST dla obiektów klasy {@link User}</p>
 *
 * @author jpiwowarczyk
 */
@RestController
@RequestMapping("api/v1/management/users")
public class UserController {

    @Autowired
    @Qualifier("HibernateUserService")
    private UserService userService;

    /**
     * <p>Endpoint zwracający listę użytkowników</p>
     *
     * @return {@link List}
     */
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    /**
     * <p>Endpoint tworzący nowego użytkownika</p>
     *
     * @param user {@link User}
     * @return {@link String}
     */
    @PostMapping
    @CrossOrigin
    public String createUser(@RequestBody User user){
        userService.createNew(user);
        return "User " + user.getUserID() + " created successfully";
    }
    /**
     * <p>Endpoint wyszukujący użytkownika</p>
     *
     * @param userId {@link Long}
     * @param user {@link User}
     * @return {@link String}
     */
    @PutMapping("{userId}")
    @CrossOrigin
    public String updateUser(@PathVariable Long userId, @RequestBody User user){
        userService.updateExisting(user);
        return "User " + user.getUserID() + " updated successfully";
    }
}
