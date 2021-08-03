package com.techelevator.controller;

import com.techelevator.model.FlashCard;
import com.techelevator.model.FlashCardKeyword;
import com.techelevator.model.FlashCardUser;
import com.techelevator.service.FlashCardService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FlashCardController {

    private FlashCardService flashCardService;

    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }


    @RequestMapping(path ="/flashCards", method= RequestMethod.POST)
    public boolean createFlashCard(@RequestBody FlashCard flashCard) throws Exception{
        return flashCardService.createNewFlashCard((flashCard));
    }

    @RequestMapping(path ="/flashCards", method= RequestMethod.PUT)
    public void updateFlashCard(@RequestBody FlashCard flashCard) throws Exception{
         flashCardService.updateExistingFlashCard((flashCard));
    }

}
