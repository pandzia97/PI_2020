package ovh.piwowarczyk.votr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * <p>Klasa encji obiektu przechowująca informacje o ankiecie</p>
 *
 * @author jpiwowarczyk
 */

@Entity
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue
    private long id;

    //TODO usunięty z serializacji - brak autoryzacji w obecnej wersji
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User author;

    private String name;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Question> questions;

    @OneToMany(mappedBy = "survey")
    @JsonIgnore
    private List<Vote> votes;

    private Boolean active;

    private Boolean finished;


    /**
     * <p>Konstruktor</p>
     */
    public Survey() {}


    /**
     * <p>Getter dla pola <code>id</code>.</p>
     *
     * @return long.
     */
    public long getId() { return id; }

    /**
     * <p>Setter dla pola <code>id</code>.</p>
     *
     * @param id long.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * <p>Getter dla pola <code>author</code>.</p>
     *
     * @return {@link User} 
     */
    public User getAuthor() {
        return author;
    }

    /**
     * <p>Setter dla pola <code>author</code>.</p>
     *
     * @param author {@link User} 
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * <p>Getter dla pola <code>name</code>.</p>
     *
     * @return {@link String} 
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Setter dla pola <code>name</code>.</p>
     *
     * @param name {@link String} 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Getter dla pola <code>questions</code>.</p>
     *
     * @return {@link List} 
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * <p>Setter dla pola <code>questions</code>.</p>
     *
     * @param questions {@link List} 
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * <p>Getter dla pola <code>votes</code>.</p>
     *
     * @return {@link List} 
     */
    public List<Vote> getVotes() {
        return votes;
    }

    /**
     * <p>Setter dla pola <code>votes</code>.</p>
     *
     * @param votes {@link List} 
     */
    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    /**
     * <p>Getter dla pola <code>active</code>.</p>
     *
     * @return {@link Boolean} 
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * <p>Setter dla pola <code>active</code>.</p>
     *
     * @param active {@link Boolean} 
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * <p>Getter dla pola <code>finished</code>.</p>
     *
     * @return {@link Boolean} 
     */
    public Boolean getFinished() {
        return finished;
    }

    /**
     * <p>Setter dla pola <code>finished</code>.</p>
     *
     * @param finished {@link Boolean} 
     */
    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
