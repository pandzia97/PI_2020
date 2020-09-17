package ovh.piwowarczyk.votr.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.piwowarczyk.votr.model.Vote;
import ovh.piwowarczyk.votr.utils.VoteHasher;

import java.util.List;

/**
 * <p>Implementacja serwisu {@link VoteService} dla frameworka Hibernate</p>
 *
 * @author jpiwowarczyk
 */
@Service("HibernateVoteController")
public class HibernateVoteService implements VoteService {

    Logger logger = LoggerFactory.getLogger(HibernateVoteService.class);

    @Autowired
    private SessionFactory sessionFactory;

    /** {@inheritDoc} */
    @Override
    public Vote createNew(Vote vote) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();


            session.save(vote);
            vote.setHashedIdentifier(VoteHasher.hashVote(vote));
            session.update(vote);

            transaction.commit();
        }catch (Exception e){
            logger.info(e.getMessage(), e);
            if (transaction!=null) {
                transaction.rollback();

            }
        }

        return vote;
    }

    /** {@inheritDoc} */
    @Override
    public void updateExisting(Vote vote) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();

            session.update(vote);

            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Vote> getVotesForSurveyId(Long surveyId) {
        List<Vote> voteList = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM Vote where survey = " + surveyId.toString();
            voteList = session.createQuery(query, Vote.class).getResultList();
            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return voteList;
    }

    /** {@inheritDoc} */
    @Override
    public Vote getVoteForHashedIdentifier(String hashedIdentifier) {
        Vote vote = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM Vote WHERE hashedIdentifier = '" + hashedIdentifier + "'";
            List<Vote> voteList = session.createQuery(query, Vote.class).list();
            if(voteList.size()==1){
                vote = voteList.get(0);

            }
            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
//
//        if(!vote.getHashedIdentifier().equals(VoteHasher.hashVote(vote))){
//            return new Vote();
//        }
            return vote;
    }
}

