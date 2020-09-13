package ovh.piwowarczyk.votr.dao;

import ovh.piwowarczyk.votr.model.Vote;

public class VoteDAO extends HibernateDAO {
    public VoteDAO(){
        setClazz(Vote.class);
    }
}
