package ovh.piwowarczyk.votr.model;


import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Option {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    private String answer;

    public Option(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
