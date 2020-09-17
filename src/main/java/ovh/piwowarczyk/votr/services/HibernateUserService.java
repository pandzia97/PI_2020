package ovh.piwowarczyk.votr.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.piwowarczyk.votr.model.User;
import ovh.piwowarczyk.votr.model.UserRole;

import java.util.List;

/**
 * <p>Implementacja serwisu {@link UserService} dla frameworka Hibernate</p>
 *
 * @author jpiwowarczyk
 */
@Service("HibernateUserService")
public class HibernateUserService implements UserService {
    Logger logger = LoggerFactory.getLogger(HibernateUserService.class);

    @Autowired
    private SessionFactory sessionFactory;

    /** {@inheritDoc} */
    @Override
    public void createNew(User user) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
        }catch(Exception e) {
            logger.debug(e.getMessage(), e);
            if (transaction!=null) {
                transaction.rollback();
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void updateExisting(User user) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();

            session.update(user);

            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<User> getAllUsers() {
        List<User> userList = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM User";
            userList = session.createQuery(query, User.class).getResultList();
            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return userList;
    }

    /** {@inheritDoc} */
    @Override
    public List<User> getAllUsers(UserRole role) {
        List<User> userList = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM User WHERE userRole = \"" + role + "\""; 
            userList = session.createQuery(query, User.class).getResultList();
            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return userList;
    }

    /** {@inheritDoc} */
    @Override
    public User getUserForLogin(String login) {
        User user = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM User WHERE login =\"" + login.trim() + "\"";
            List<User> userList = session.createQuery(query, User.class).list();
            if(userList.size()==1){
                user = userList.get(0);
            }
            transaction.commit();
        }catch(Exception e) {
            logger.info(e.getMessage(), e);

            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return user;
    }

    /** {@inheritDoc} */
    @Override
    public User getUserForEmail(String email) {
        User user = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM User WHERE email =\"" + email.trim() + "\"";
            List<User> userList = session.createQuery(query, User.class).list();
            if(userList.size()==1){
                user = userList.get(0);
            }
            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return user;
    }

    /** {@inheritDoc} */
    @Override
    public User getUserForId(int id) {
        User user = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM User WHERE id =" + id;
            List<User> userList = session.createQuery(query, User.class).list();
            if(userList.size()==1){
                user = userList.get(0);
            }
            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return user;
    }
}
