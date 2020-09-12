package ovh.piwowarczyk.votr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;
    private String question;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Option> optionList;


    public Question() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
}
