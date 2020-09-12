package ovh.piwowarczyk.votr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    private Long voteID;
    private String hashedIdentifier;
    @ManyToOne
    private Survey survey;
    private Date date;
    @OneToMany(mappedBy = "vote")
    @JsonIgnore
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
