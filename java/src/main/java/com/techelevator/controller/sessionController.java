package com.techelevator.controller;


import com.techelevator.model.FlashCard;
import com.techelevator.service.FlashCardService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class sessionController {

//    private final SessionService sessionService;
//
//    public sessionController(FlashCardService flashCardService) {
//        this.sessionService = sessionService;
//    }
//
//    @RequestMapping(path ="/session", method= RequestMethod.POST)
//    public boolean completeSession(@RequestBody Session session) throws Exception{
//        return SessionService.completeSession((session));
//    }
}
