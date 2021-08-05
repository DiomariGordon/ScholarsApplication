package com.techelevator.service;


import com.techelevator.Exception.BadRequestException;
import com.techelevator.dao.DeckDao;
import com.techelevator.dao.FlashCardDao;
import com.techelevator.model.Deck;
import com.techelevator.model.FlashCard;
import org.springframework.stereotype.Service;

@Service
public class DeckService {

    private DeckDao deckDao;

    public DeckService (DeckDao deckDao) {
        this.deckDao = deckDao;
    }

    public boolean createDeck( Deck deck) {
        deckDao.createDeck(deck);
        deckDao.addDeckUser(deck);

        return true;
    }

    public void updateExistingDeck(Deck deck) throws Exception{

        Deck existingDeck =  deckDao.getDeckByDeckId(deck.getDeckId());
        if(existingDeck == null){
            throw new BadRequestException("Deck does not Exist");
        }
        deckDao.updateDeck(deck);

    }


}
