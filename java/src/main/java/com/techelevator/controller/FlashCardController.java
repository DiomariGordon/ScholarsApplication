package com.techelevator.controller;

import com.techelevator.model.FlashCard;
import com.techelevator.service.FlashCardService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class FlashCardController {

    private final FlashCardService flashCardService;

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

    @RequestMapping(path ="/flashCards/{id}", method= RequestMethod.GET)
    public List<FlashCard> getFlashCards(@PathVariable Integer id) throws Exception{
       return flashCardService.getFlashCards(id);
    }

}
