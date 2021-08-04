package com.techelevator.dao;

import com.techelevator.model.FlashCard;
import com.techelevator.model.FlashCardKeyword;
import com.techelevator.model.FlashCardUser;

import java.util.List;

public interface FlashCardDao {

    boolean createFlashCard(FlashCard flashCard);

    FlashCard getFlashCardByQuestion(String question);

    void updateFlashCard(FlashCard flashCard);

     FlashCard getFlashCardById(Integer flashCardId);

    boolean addFlashCardUser(FlashCard flashCardUser);

    boolean addFlashCardKeywords(FlashCard flashCardKeyword);

    List<FlashCard> getFlashcardsByUserId(Integer id);
}
