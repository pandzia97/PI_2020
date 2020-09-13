package ovh.piwowarczyk.votr.dao;

import ovh.piwowarczyk.votr.model.Survey;

public class SurveyDAO extends HibernateDAO {
    public SurveyDAO(){
        setClazz(Survey.class);
    }
}
