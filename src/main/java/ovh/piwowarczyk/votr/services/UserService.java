package ovh.piwowarczyk.votr.services;

import ovh.piwowarczyk.votr.model.User;
import ovh.piwowarczyk.votr.model.UserRole;

import java.util.List;

public interface UserService {
    void createNew(User user);
    void updateExisting(User user);
    List<User> getAllUsers();
    List<User> getAllUsers(UserRole role);
    User getUserForLogin(String login);
    User getUserForId(int id);
}
