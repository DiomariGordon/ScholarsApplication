package com.techelevator.controller;
import com.techelevator.model.Session;
import com.techelevator.service.SessionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class sessionController {

    private final SessionService sessionService;

    public sessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @RequestMapping(path ="/session", method= RequestMethod.POST)
    public boolean completeSession(@RequestBody Session session) {
        return sessionService.createSession((session));
    }
}
