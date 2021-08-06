package com.techelevator.dao;

import com.techelevator.model.FlashCard;
import com.techelevator.model.FlashCardKeyword;
import com.techelevator.model.FlashCardUser;

import java.util.List;

public interface FlashCardDao {

    boolean createFlashCard(FlashCard flashCard);

    FlashCard getFlashCardByQuestion(String question, String answer, Integer userId);

    void updateFlashCard(FlashCard flashCard);

     FlashCard getFlashCardById(Integer flashCardId, Integer userId);

    boolean addFlashCardUser(FlashCard flashCardUser);

    boolean addFlashCardKeywords(FlashCard flashCardKeyword);

    List<FlashCard> getFlashcardsByUserId(Integer id);

    List<FlashCard> getFlashCardByKeyword( Integer userId , String keyword);

    void deleteAllFlashcardKeywords(int cardId);

    void deleteFlashcard(int cardId);

    void deleteFlashcardUser(int cardId);

    void deleteFlashcardFromDeck(int cardId);

    Integer getFlashcardIdByUserId(Integer userId);
}
