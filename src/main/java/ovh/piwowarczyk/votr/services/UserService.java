package ovh.piwowarczyk.votr.services;

import ovh.piwowarczyk.votr.model.User;
import ovh.piwowarczyk.votr.model.UserRole;

import java.util.List;

/**
 * <p>Interfejs UserService  do obsługi persystencji obiektów klasy User</p>
 *
 * @author jpiwowarczyk
 */
public interface UserService {
    /**
     * <p>Zapis obiektu klasy {@link User} do Bazy Danych</p>
     *
     * @param user obiekt {@link User} do zapisu.
     */
    void createNew(User user);
    /**
     * <p>Aktualizacja obiektu klasy {@link User} istniejącego w Bazie Danych</p>
     *
     * @param user Obiekt  {@link User} do aktualizacji.
     */
    void updateExisting(User user);
    /**
     * <p>Pobieranie listy wszystkich obiektów klasy {@link User}</p>
     *
     * @return kolekcja ({@link List}) obiektów typu {@link User}.
     */
    List<User> getAllUsers();
    /**
     * <p>Pobieranie listy wszystkich obiektów klasy {@link User}
     * posiadających określoną rolę</p>
     *
     * @param role enum definiujący rolę użytkownika {@link UserRole}
     * @return kolekcja ({@link List}) obiektów typu {@link User}.
     */
    List<User> getAllUsers(UserRole role);
    /**
     * <p>Pobieranie obiektu klasy {@link User} o określonej nazwie użytkownika</p>
     *
     * @param login nazwa użytkowanika ({@link String})
     * @return obiekt typu {@link User}.
     */
    User getUserForLogin(String login);
    /**
     * <p>Pobieranie obiektu klasy {@link User} o określonej nazwie użytkownika</p>
     *
     * @param email adres email użytkowanika ({@link String})
     * @return obiekt typu {@link User}.
     */
    User getUserForEmail(String email);
    /**
     * <p>Pobieranie obiektu klasy {@link User} o określonej nazwie użytkownika</p>
     *
     * @param id identyfikator użytkownika jako
     * @return obiekt typu {@link User}.
     */
    User getUserForId(int id);
}
