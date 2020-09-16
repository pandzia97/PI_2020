package ovh.piwowarczyk.votr.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    private Long voteID;
    private String hashedIdentifier;
    @ManyToOne
    @JsonManagedReference
    private Survey survey;
    private Date date;
    @OneToMany(mappedBy = "vote")
    private List<Answer> answers;

    public Vote() {}

    public Long getVoteID() {
        return voteID;
    }

    public void setVoteID(Long voteID) {
        this.voteID = voteID;
    }

    public String getHashedIdentifier() {
        return hashedIdentifier;
    }

    public void setHashedIdentifier(String hashedIdentifier) {
        this.hashedIdentifier = hashedIdentifier;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
