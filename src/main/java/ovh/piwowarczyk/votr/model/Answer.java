package ovh.piwowarczyk.votr.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Map;
@Entity
@Table(name="answer")
public class Answer {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    //@JsonBackReference
    private Vote vote;

    @ManyToOne
    //@JsonManagedReference
    private Question question;

    @ManyToOne
   //@JsonManagedReference
    private Option option;


    public Answer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
