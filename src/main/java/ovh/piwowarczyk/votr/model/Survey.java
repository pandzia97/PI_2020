package ovh.piwowarczyk.votr.model;

import java.util.List;

public class Survey {
    private long id;
    private String question;
    private List<Question> questions;

    public Survey() {}

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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
