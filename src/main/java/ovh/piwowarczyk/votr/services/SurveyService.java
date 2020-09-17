package ovh.piwowarczyk.votr.services;

import ovh.piwowarczyk.votr.model.Survey;

import java.util.List;

/**
 * <p>Interfejs serwisu SurveyService do obsługi persystencji obiektów klasy Survey</p>
 *
 * @author jpiwowarczyk
 */
public interface SurveyService {
    /**
     * <p>Zapis obiektu klasy {@link Survey} do Bazy Danych</p>
     *
     * @param survey obiekt {@link Survey} do zapisu.
     */
    void createNew(Survey survey);
    /**
     * <p>Aktualizacja obiektu klasy {@link Survey} istniejącego w Bazie Danych</p>
     *
     * @param survey Obiekt  {@link Survey} do aktualizacji.
     */
    void updateExisting(Survey survey);
    /**
     * <p>Pobieranie wszystkich obiektów klasy {@link Survey}</p>
     *
     * @return kolekcja ({@link List}) obiektów klasy {@link Survey}.
     */
    List<Survey> getAllSurveys(); //TODO: Znaleźć sposób na dynamiczne filtrowanie
    /**
     * <p>Pobieranie wszystkich aktywnych obiektów klasy {@link Survey}</p>
     *
     * @return kolekcja ({@link List}) obiektów klasy {@link Survey}.
     */
    List<Survey> getAllActiveSurveys();
    /**
     * <p>Pobieranie wszystkich zakończonych obiektów klasy {@link Survey}</p>
     *
     * @return kolekcja ({@link List}) obiektów klasy {@link Survey}.
     */
    List<Survey> getAllFinishedSurveys();
    /**
     * <p>Pobieranie pierwszego obiektu klasy {@link Survey} o określonej nazwie</p>
     *
     * @param name Poszukiwana nazwa obiektu jako {@link String}
     * @return Obiekt klasy {@link Survey}
     */
    Survey getSurveyForName(String name);
    /**
     * <p>Pobieranie obiektu klasy {@link Survey} o określonym id</p>
     *
     * @param id Poszukiwana nazwa obiektu jako id
     * @return Obiekt klasy {@link Survey}
     */
    Survey getSurveyForId(long id);
}
