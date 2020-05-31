package ovh.piwowarczyk.votr.model;

public class Answer {
    private long id;
    private String answer;

    public Answer(){}

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
