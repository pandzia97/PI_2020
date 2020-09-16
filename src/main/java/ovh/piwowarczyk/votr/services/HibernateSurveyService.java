package ovh.piwowarczyk.votr.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.piwowarczyk.votr.model.Survey;

import java.util.List;

@Service("HibernateSurveyService")
public class HibernateSurveyService implements SurveyService {
    Logger logger = LoggerFactory.getLogger(HibernateSurveyService.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void createNew(Survey survey) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();

            session.save(survey);

            transaction.commit();
        }catch (Exception e){
            logger.info(e.getMessage(), e);
            if (transaction!=null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateExisting(Survey survey) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();

            session.update(survey);

            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<Survey> getAllSurveys() {
        List<Survey> surveyList = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM Survey";
            surveyList = session.createQuery(query, Survey.class).getResultList();
            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return surveyList;
    }

    @Override
    public List<Survey> getAllActiveSurveys() {
        List<Survey> surveyList = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM Survey WHERE active = true";
            surveyList = session.createQuery(query, Survey.class).getResultList();
            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return surveyList;
    }

    @Override
    public List<Survey> getAllFinishedSurveys() {
        List<Survey> surveyList = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM Survey WHERE finished = true";
            surveyList = session.createQuery(query, Survey.class).getResultList();
            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return surveyList;
    }

    @Override
    public Survey getSurveyForName(String name) {
        Survey survey = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM Survey WHERE  name like \"%" + name.trim() + "%\"";
            List<Survey> surveyList = session.createQuery(query, Survey.class).list();
            if(surveyList.size()==1){
                survey = surveyList.get(0);
            }
            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return survey;
    }

    @Override
    public Survey getSurveyForId(long id) {
        Survey survey = null;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "FROM Survey WHERE id =" + id;
            List<Survey> surveyList = session.createQuery(query, Survey.class).list();
            if(surveyList.size()==1){
                survey = surveyList.get(0);
            }
            transaction.commit();
        }catch(Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return survey;
    }
}
