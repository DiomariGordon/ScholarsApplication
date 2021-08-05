package com.techelevator.model;

public class Deck {
    private Integer deckId;
    private Integer userId;
    private String deckName;
    private String description;

    public Deck() {
    }

    public Deck(Integer deckId, Integer userId, String deckName) {
        this.deckId = deckId;
        this.userId = userId;
        this.deckName = deckName;
    }

    public Deck(Integer deckId, Integer userId, String deckName, String description) {
        this.deckId = deckId;
        this.userId = userId;
        this.deckName = deckName;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}




