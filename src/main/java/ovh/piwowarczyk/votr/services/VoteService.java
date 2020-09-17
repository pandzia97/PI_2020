package ovh.piwowarczyk.votr.services;

import ovh.piwowarczyk.votr.model.Survey;
import ovh.piwowarczyk.votr.model.Vote;

import java.util.List;

/**
 * <p>Interfejs serwisu VoteService do obsługi persystencji obiektów klasy Vote</p>
 *
 * @author jpiwowarczyk
 */
public interface VoteService {
    /**
     * <p>Zapis obiektu klasy {@link Vote} do Bazy Danych</p>
     *
     * @param vote obiekt {@link Vote} do zapisu.
     * @return Obiekt {@link Vote} uzupełniony o pola definiujące parametry zapisu.
     */
    Vote createNew(Vote vote);
    /**
     * <p>Aktualizacja obiektu klasy {@link Vote} istniejącego w Bazie Danych</p>
     *
     * @param vote Obiekt  {@link Vote} do aktualizacji.
     */
    void updateExisting(Vote vote);
    /**
     * <p>Pobieranie listy obiektów klasy {@link Vote} dla danego id obiektu klasy {@link Survey}</p>
     *
     * @param surveyId Identyfikator obiektu klasy {@link Survey} podany jako wartość numeryczna ({@link Long})
     * @return a {@link List} object.
     */
    List<Vote> getVotesForSurveyId(Long surveyId);
    /**
     * <p>Pobieranie pojedynczego obiektu klasy {@link Vote} na podstawie zadanego hasza</p>
     *
     * @param hashedIdentifier Wyszukiwany hasz obiektu klasy {@link Vote} podany jako ciąg
     * zanków alfanumerycznych ({@link String}).
     * @return znaleziony obiekt typu {@link Vote}
     */
    Vote getVoteForHashedIdentifier(String hashedIdentifier);
}
