package ovh.piwowarczyk.votr.dao;

import ovh.piwowarczyk.votr.model.User;

public class UserDAO extends HibernateDAO {
    public UserDAO(){
        setClazz(User.class);
    }
}
