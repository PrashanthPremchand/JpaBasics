package com.prashanth.jpaBasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public ResponseEntity<String> addCard(Card card){
        cardRepository.save(card);
        return new ResponseEntity<>("Card added successfully", HttpStatus.CREATED);
    }
}
