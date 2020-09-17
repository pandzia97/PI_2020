package ovh.piwowarczyk.votr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Klasa encji obiektu przechowująca informacje o użytkowniku</p>
 *
 * @author jpiwowarczyk
 */

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int userID;
    private String login;
    private String password;
    private String email;
    @Column(name = "display_name")
    private String displayName;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Survey> surveys;

    /**
     * <p>Konstrutor</p>
     */
    public User() {}

    /**
     * <p>Getter dla pola <code>userID</code>.</p>
     *
     * @return int.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * <p>Setter dla pola <code>userID</code>.</p>
     *
     * @param userID int.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * <p>Getter dla pola <code>login</code>.</p>
     *
     * @return {@link String}
     */
    public String getLogin() {
        return login;
    }

    /**
     * <p>Setter dla pola <code>login</code>.</p>
     *
     * @param login {@link String}
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * <p>Getter dla pola <code>password</code>.</p>
     *
     * @return {@link String}
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>Setter dla pola <code>password</code>.</p>
     *
     * @param password {@link String}
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <p>Getter dla pola <code>email</code>.</p>
     *
     * @return {@link String}
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>Setter dla pola <code>email</code>.</p>
     *
     * @param email {@link String}
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p>Getter dla pola <code>displayName</code>.</p>
     *
     * @return {@link String}
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * <p>Setter dla pola <code>displayName</code>.</p>
     *
     * @param displayName {@link String}
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * <p>Getter dla pola <code>userRole</code>.</p>
     *
     * @return {@link UserRole}
     */
    public UserRole getUserRole() {
        return userRole;
    }

    /**
     * <p>Setter dla pola <code>userRole</code>.</p>
     *
     * @param userRole {@link UserRole}
     */
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    /**
     * <p>Getter dla pola <code>surveys</code>.</p>
     *
     * @return {@link List}
     */
    public List<Survey> getSurveys() {
        return surveys;
    }

    /**
     * <p>Setter dla pola <code>surveys</code>.</p>
     *
     * @param surveys {@link List}
     */
    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }
}
