package com.techelevator.model;

public class FlashCard {

    private Integer flashCardId;
    private String question;
    private String answer;
    private Integer userId;
    private String [] keywords;


    public FlashCard() {
    }

    public FlashCard(Integer flashCardId, String question, String answer, Integer userId, String[] keywords) {
        this.flashCardId = flashCardId;
        this.question = question;
        this.answer = answer;
        this.userId = userId;
        this.keywords = keywords;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
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
