package ovh.piwowarczyk.votr.dao;

import ovh.piwowarczyk.votr.model.Survey;

/**
 * <p>Klasa rozszerzająca {@link HibernateDAO} dla encji klasy {@link Survey}</p>
 *
 * @author jpiwowarczyk
 */
public class SurveyDAO extends HibernateDAO {
    /**
     * <p>Konstruktor</p>
     */
    public SurveyDAO(){
        setClazz(Survey.class);
    }
}
