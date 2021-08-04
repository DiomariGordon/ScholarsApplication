package com.techelevator.controller;

import com.techelevator.model.Deck;
import com.techelevator.model.FlashCard;
import com.techelevator.service.DeckService;
import com.techelevator.service.FlashCardService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class DeckController {

    private DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }


    @RequestMapping(path ="/deck", method= RequestMethod.POST)
    public boolean createDeck(@RequestBody Deck deck) throws Exception{
        return deckService.createDeck((deck));
    }

    @RequestMapping(path ="/deck", method= RequestMethod.PUT)
    public void updateDeck(@RequestBody Deck deck) throws Exception{
        deckService.updateExistingDeck((deck));
    }

}