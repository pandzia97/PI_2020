package ovh.piwowarczyk.votr.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * <p>Klasa encji obiektu przechowująca informacje o oddanym głosie</p>
 *
 * @author jpiwowarczyk
 */
@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    private Long voteID;
    private String hashedIdentifier;
    @ManyToOne
    private Survey survey;
    private Date date;
    @OneToMany(mappedBy = "vote", cascade = CascadeType.ALL)
    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answer> answers;

    /**
     * <p>Konstruktor</p>
     */
    public Vote() {}

    /**
     * <p>Getter dla pola <code>voteID</code>.</p>
     *
     * @return {@link Long}
     */
    public Long getVoteID() {
        return voteID;
    }

    /**
     * <p>Setter dla pola <code>voteID</code>.</p>
     *
     * @param voteID {@link Long}
     */
    public void setVoteID(Long voteID) {
        this.voteID = voteID;
    }

    /**
     * <p>Getter dla pola <code>hashedIdentifier</code>.</p>
     *
     * @return {@link String}
     */
    public String getHashedIdentifier() {
        return hashedIdentifier;
    }

    /**
     * <p>Setter dla pola <code>hashedIdentifier</code>.</p>
     *
     * @param hashedIdentifier {@link String}
     */
    public void setHashedIdentifier(String hashedIdentifier) {
        this.hashedIdentifier = hashedIdentifier;
    }

    /**
     * <p>Getter dla pola <code>survey</code>.</p>
     *
     * @return {@link Survey}
     */
    public Survey getSurvey() {
        return survey;
    }

    /**
     * <p>Setter dla pola <code>survey</code>.</p>
     *
     * @param survey {@link Survey}
     */
    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    /**
     * <p>Getter dla pola <code>date</code>.</p>
     *
     * @return {@link Date}
     */
    public Date getDate() {
        return date;
    }

    /**
     * <p>Setter dla pola <code>date</code>.</p>
     *
     * @param date {@link Date}
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * <p>Getter dla pola <code>answers</code>.</p>
     *
     * @return {@link List}
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * <p>Setter dla pola <code>answers</code>.</p>
     *
     * @param answers {@link List}
     */
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
