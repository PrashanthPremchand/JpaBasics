package com.prashanth.jpaBasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;
    @PostMapping("/add_card")
    public ResponseEntity<String> addCard(@RequestBody Card card){
        return cardService.addCard(card);
    }
}
