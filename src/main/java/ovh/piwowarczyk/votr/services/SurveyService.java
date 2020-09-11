package ovh.piwowarczyk.votr.services;

import ovh.piwowarczyk.votr.model.Survey;

import java.util.List;

public interface SurveyService {
    void createNew(Survey survey);
    void updateExisting(Survey survey);
    List<Survey> getAllSurveys(); //TODO: Znaleźć sposób na dynamiczne filtrowanie
    List<Survey> getAllActiveSurveys();
    List<Survey> getAllFinishedSurveys();
    Survey getSurveyForName(String name);
    Survey getSurveyForId(long id);
}
