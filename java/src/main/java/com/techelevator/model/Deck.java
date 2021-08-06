package com.techelevator.model;

public class Deck {
    private Integer deckId;
    private Integer userId;
    private String name;
    private String description;

    public Deck() {
    }

    public Deck(Integer deckId, Integer userId, String name) {
        this.deckId = deckId;
        this.userId = userId;
        this.name = name;
    }

    public Deck(Integer deckId, Integer userId, String name, String description) {
        this.deckId = deckId;
        this.userId = userId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}




