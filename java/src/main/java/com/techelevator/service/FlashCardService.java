package com.techelevator.service;

import com.techelevator.Exception.BadRequestException;
import com.techelevator.dao.FlashCardDao;
import com.techelevator.model.FlashCard;
import com.techelevator.model.FlashCardUser;
import org.springframework.stereotype.Service;

@Service
public class FlashCardService {

    private FlashCardDao flashCardDao;

    public FlashCardService (FlashCardDao flashCardDao) {
        this.flashCardDao = flashCardDao;
    }



       public boolean  createNewFlashCard( FlashCard flashCard) throws Exception {
            FlashCard existingFlashCard =  flashCardDao.getFlashCardByQuestion(flashCard.getQuestion());
            if(existingFlashCard != null) {
                throw new BadRequestException("Flash Card Already Exist");
            }
            flashCardDao.createFlashCard(flashCard);
            flashCardDao.addFlashCardUser(flashCard);
            flashCardDao.addFlashCardKeywords(flashCard);

            return true;
        }

        public void updateExistingFlashCard(FlashCard flashCard) throws Exception{

            FlashCard existingFlashCard =  flashCardDao.getFlashCardById(flashCard.getFlashCardId());
            if(existingFlashCard == null){
                throw new BadRequestException("Flash Card does not Exist");
            }
            flashCardDao.updateFlashCard(flashCard);

        }

}
