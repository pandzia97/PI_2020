package ovh.piwowarczyk.votr.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.piwowarczyk.votr.model.Vote;
import ovh.piwowarczyk.votr.utils.VoteHasher;

import java.util.List;

@Service("HibernateVoteController")
public class HibernateVoteService implements VoteService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Vote createNew(Vote vote) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Vote hashedVote;


            session.save(vote);
            hashedVote = VoteHasher.hashVote(vote);
            session.update(hashedVote);

            transaction.commit();
        }catch (Exception e){
            if (transaction!=null) {
                transaction.rollback();
            }
        }

        return vote;
    }

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

    @Override
    public Vote getVoteForHashedIdentifier(String hashedIdentifier) {
        Vote vote = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM Vote WHERE hashedIdentifier =" + hashedIdentifier;
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
        return vote;
    }
}

