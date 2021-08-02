package com.techelevator.controller;

import com.techelevator.model.FlashCard;
import com.techelevator.service.FlashCardService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlashCardController {

    private FlashCardService flashCardService;

    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }


    @RequestMapping(path ="/flashCards", method= RequestMethod.POST)
    public boolean createFlashCard(@RequestBody FlashCard flashCard){
        return flashCardService.createNewFlashCard((flashCard));
    }

}
