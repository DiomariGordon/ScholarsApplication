package com.techelevator.service;


import com.techelevator.Exception.BadRequestException;
import com.techelevator.dao.DeckDao;
import com.techelevator.dao.FlashCardDao;
import com.techelevator.model.Deck;
import com.techelevator.model.FlashCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {

    private DeckDao deckDao;

    public DeckService (DeckDao deckDao) {
        this.deckDao = deckDao;
    }

    public boolean createDeck( Deck deck) {
        deckDao.createDeck(deck);
        deckDao.addDeckUser(deck);
        deckDao.addCardToDeck(deck);



        return true;
    }

    public List<Deck> getDeckByUser(Integer userId){

        return deckDao.getDeckByUserId(userId);
    }

    public void updateExistingDeck(Deck deck) throws Exception{

        Deck existingDeck =  deckDao.getDeckByDeckId(deck.getDeckId());
        if(existingDeck == null){
            throw new BadRequestException("Deck does not Exist");
        }
        deckDao.updateDeckName(deck);

    }

    public boolean  addFlashCardToDeck( FlashCard flashCard) throws Exception {

        /*Integer userId = deckDao.getUserIdByDeckId(flashCard.getDeckId());
        if(userId == null){
            throw new BadRequestException("Deck does not Exist");
        }*/
        //deckDao.addCardToDeck(flashCard);

        return true;

    }

    public List<FlashCard>  getFlashcardsByDeckId(Integer deckId) {
        return deckDao.getFlashcardsIdByDeckId(deckId);
    }




}
