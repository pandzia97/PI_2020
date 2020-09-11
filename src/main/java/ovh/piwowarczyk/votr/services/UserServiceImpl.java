package ovh.piwowarczyk.votr.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ovh.piwowarczyk.votr.model.User;
import ovh.piwowarczyk.votr.utils.HibernateFactory;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public void createNew(User user) {
        Transaction transaction = null;
        try(Session session = HibernateFactory.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateExisting(User user) {
        Transaction transaction = null;
        try(Session session = HibernateFactory.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.update(user);

            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = null;

        Transaction transaction = null;
        try(Session session = HibernateFactory.getSessionFactory().openSession()){
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

    @Override
    public User getUserForLogin(String login) {
        User user = null;

        Transaction transaction = null;
        try(Session session = HibernateFactory.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String query = "FROM User WHERE login =\"" + login.trim() + "\"";
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

    @Override
    public User getUserForId(int id) {
        User user = null;

        Transaction transaction = null;
        try(Session session = HibernateFactory.getSessionFactory().openSession()){
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
