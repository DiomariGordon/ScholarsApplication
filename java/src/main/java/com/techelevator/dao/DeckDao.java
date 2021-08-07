package com.techelevator.dao;

import com.techelevator.model.Deck;
import com.techelevator.model.DeckUser;
import com.techelevator.model.FlashCard;

import java.util.List;

public interface DeckDao {

    boolean createDeck(Deck Deck);

    boolean addDeckUser(Deck deck);

    Deck getDeckByDeckId(Integer deckId);

    boolean updateDeckName(Deck deck);

    boolean updateDeckContents(FlashCard flashCard);

    List<Deck> getDeckByUserId(Integer userId);

    boolean addCardToDeck(FlashCard flashCard);

    Integer getUserIdByDeckId(Integer deckId);

}
