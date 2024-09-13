package com.prashanth.jpaBasics;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
    private Date expiry;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne
    @JoinColumn//to use any other parameter as the foreign key use @JoinColumn(columnName)
    private User user;

    public Card(){

    }
    public Card(int cardId, Date expiry, Status status, User user) {
        this.cardId = cardId;
        this.expiry = expiry;
        this.status = status;
        this.user = user;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
