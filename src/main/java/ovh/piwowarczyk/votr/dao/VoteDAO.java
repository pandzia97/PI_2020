package ovh.piwowarczyk.votr.dao;

import ovh.piwowarczyk.votr.model.Vote;

/**
 * <p>Klasa rozszerzająca {@link HibernateDAO} dla encji klasy {@link Vote}</p>
 *
 * @author jpiwowarczyk
 */
public class VoteDAO extends HibernateDAO {
    /**
     * <p>Konstruktor</p>
     */
    public VoteDAO(){
        setClazz(Vote.class);
    }
}
