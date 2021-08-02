package com.techelevator.model;

public class FlashCard {
    private Integer flashCardId;
    private String question;
    private String answer;

    public FlashCard() {
    }

    public FlashCard(Integer flashCardId, String question, String answer) {
        this.flashCardId = flashCardId;
        this.question = question;
        this.answer = answer;
    }

    public Integer getFlashCardId() {
        return flashCardId;
    }

    public void setFlashCardId(Integer flashCardId) {
        this.flashCardId = flashCardId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
