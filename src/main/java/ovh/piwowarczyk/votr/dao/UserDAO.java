package ovh.piwowarczyk.votr.dao;

import ovh.piwowarczyk.votr.model.User;

/**
 * <p>Klasa rozszerzająca {@link HibernateDAO} dla encji klasy {@link User}</p>
 *
 * @author jpiwowarczyk
 */
public class UserDAO extends HibernateDAO {
    /**
     * <p>Konstruktor</p>
     */
    public UserDAO(){
        setClazz(User.class);
    }
}
