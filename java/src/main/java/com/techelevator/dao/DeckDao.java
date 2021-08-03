package com.techelevator.dao;

import com.techelevator.model.Deck;
import com.techelevator.model.DeckUser;

public interface DeckDao {

    boolean createDeck(Deck Deck);

    boolean addDeckUser(DeckUser deckUser);

    Deck getDeckByDeckId(Integer deckId);

    void updateDeck(Deck deck);

}
