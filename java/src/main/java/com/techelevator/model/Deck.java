package com.techelevator.model;

public class Deck {
    private Integer deckId;
    private Integer userId;
    private String deckName;

    public Deck() {
    }

    public Deck(Integer deckId, Integer userId, String deckName) {
        this.deckId = deckId;
        this.userId = userId;
        this.deckName = deckName;
    }

    public Integer getDeckId() {
        return deckId;
    }

    public void setDeckId(Integer deckId) {
        this.deckId = deckId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }
}




