package ovh.piwowarczyk.votr.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * <p>Klasa encji obiektu przechowująca informacje o pytaniu</p>
 *
 * @author jpiwowarczyk
 */

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Survey survey;
    private String question;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Option> options;


    /**
     * <p>Konstruktor</p>
     */
    public Question() {}


    /**
     * <p>Getter dla pola <code>id</code>.</p>
     *
     * @return long.
     */
    public long getId() {
        return id;
    }

    /**
     * <p>Setter dla pola <code>id</code>.</p>
     *
     * @param id long.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * <p>Getter dla pola <code>question</code>.</p>
     *
     * @return {@link String} 
     */
    public String getQuestion() {
        return question;
    }

    /**
     * <p>Setter dla pola <code>question</code>.</p>
     *
     * @param question {@link String} 
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * <p>Getter dla pola <code>options</code>.</p>
     *
     * @return {@link List} 
     */
    public List<Option> getOptions() {
        return options;
    }

    /**
     * <p>Setter dla pola <code>options</code>.</p>
     *
     * @param optionList {@link List} 
     */
    public void setOptions(List<Option> optionList) {
        this.options = optionList;
    }
}
