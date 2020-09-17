package ovh.piwowarczyk.votr.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * <p>Klasa encji obiektu przechowująca informacje o możliwej opcji odpowiedzi głosie</p>
 *
 * @author jpiwowarczyk
 */

@Entity
@Table(name = "option")
public class Option {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Question question;

    private String value;

    /**
     * <p>Konstruktor</p>
     */
    public Option(){}

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
     * <p>Getter dla pola <code>value</code>.</p>
     *
     * @return {@link String}
     */
    public String getValue() {
        return value;
    }

    /**
     * <p>Setter dla pola <code>value</code>.</p>
     *
     * @param answer {@link String}
     */
    public void setValue(String answer) {
        this.value = answer;
    }
}
