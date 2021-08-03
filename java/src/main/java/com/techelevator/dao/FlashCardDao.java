package com.techelevator.dao;

import com.techelevator.model.FlashCard;

public interface FlashCardDao {

    boolean createFlashCard(FlashCard flashCard);

    FlashCard getFlashCardByQuestion(String question);

    void updateFlashCard(FlashCard flashCard);

     FlashCard getFlashCardById(Integer flashCardId);
}
