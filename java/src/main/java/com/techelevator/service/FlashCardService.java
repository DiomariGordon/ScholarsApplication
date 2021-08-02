package com.techelevator.service;

import com.techelevator.dao.FlashCardDao;
import com.techelevator.model.FlashCard;
import org.springframework.stereotype.Service;

@Service
public class FlashCardService {

    private FlashCardDao flashCardDao;

    public FlashCardService (FlashCardDao flashCardDao){
        this.flashCardDao = flashCardDao;
    }

       public boolean  createNewFlashCard( FlashCard flashCard){
           flashCardDao.createFlashCard(flashCard);
           return true;
        }

}
