package ovh.piwowarczyk.votr.services;

import ovh.piwowarczyk.votr.model.User;

import java.util.List;

public interface UserService {
    void createNew(User user);
    void updateExisting(User user);
    List<User> getAllUsers();
    User getUserForLogin(String login);
    User getUserForId(int id);


}
