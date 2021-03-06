package ovh.piwowarczyk.votr.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * <p>Klasa encji obiektu przechowująca informacje o pojedynczej odpowiedzi na pytanie oddanym głosie</p>
 *
 * @author jpiwowarczyk
 */

@Entity
@Table(name="answer")
public class Answer {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    @JsonBackReference
    private Vote vote;

    @ManyToOne()
//    @JsonManagedReference
    private Question question;

    @ManyToOne()
//    @JsonManagedReference
    private Option option;


    /**
     * <p>Konstruktor</p>
     */
    public Answer() {}

    /**
     * <p>Getter dla pola <code>id</code>.</p>
     *
     * @return {@link Long} 
     */
    public Long getId() {
        return id;
    }

    /**
     * <p>Setter dla pola <code>id</code>.</p>
     *
     * @param id {@link Long} 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <p>Getter dla pola <code>vote</code>.</p>
     *
     * @return {@link Vote} 
     */
    public Vote getVote() {
        return vote;
    }

    /**
     * <p>Setter dla pola <code>vote</code>.</p>
     *
     * @param vote {@link Vote} 
     */
    public void setVote(Vote vote) {
        this.vote = vote;
    }

    /**
     * <p>Getter dla pola <code>question</code>.</p>
     *
     * @return {@link Question} 
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * <p>Setter dla pola <code>question</code>.</p>
     *
     * @param question {@link Question} 
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * <p>Getter dla pola <code>option</code>.</p>
     *
     * @return {@link Option} 
     */
    public Option getOption() {
        return option;
    }

    /**
     * <p>Setter dla pola <code>option</code>.</p>
     *
     * @param option {@link Option} 
     */
    public void setOption(Option option) {
        this.option = option;
    }
}
