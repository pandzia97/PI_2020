package ovh.piwowarczyk.votr.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Abstrakcyjna klasa DAO dla encji obiektów frameworka Hibernate</p>
 *
 * @param <T> klasa Obiektu w klasie dziedziczącej
 * @author jpiwowarczyk
 */

@Repository
public abstract class HibernateDAO<T extends Serializable> {
    private Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <p>Setter dla pola <code>clazz</code>.</p>
     *
     * @param newClazz a {@link Class} object.
     */
    public void setClazz(Class<T> newClazz) {
        clazz = newClazz;
    }

    /**
     * <p>pobranie pojedynczego obiektu encji na podstawie id</p>
     *
     * @param id long
     * @return T Klasa obiektu encji
     */
    public T findOne(long id){
        return (T) getCurrentSession().get(clazz, id);
    }

    /**
     * <p>pobranie wszystkich obiektów encji na podstawie id</p>
     *
     * @return {@link List}.
     */
    public List<T> findAll(){
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    /**
     * <p>zapis obiektu do bazy danych</p>
     *
     * @param entity obiekt o klasie T.
     */
    public void save(T entity){
        getCurrentSession().persist(entity);
    }

    /**
     * <p>aktualizacja obiektu w bazie danych</p>
     *
     * @param entity obiekt o klasie T.
     * @return obiekt o klasie T.
     */
    public T update(T entity){
        return (T) getCurrentSession().merge(entity);
    }

    /**
     * <p>delete.</p>
     *
     * @param entity obiekt o klasie T.
     */
    public void delete(T entity){
        getCurrentSession().delete(entity);
    }

    /**
     * <p>deleteById.</p>
     *
     * @param id long.
     */
    public void deleteById(long id){
        final T entity = findOne(id);
        delete(entity);
    }

    /**
     * <p>getCurrentSession.</p>
     *
     * @return a {@link Session} object.
     */
    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
