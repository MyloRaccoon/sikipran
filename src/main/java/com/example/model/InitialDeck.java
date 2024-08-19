package com.example.model;

import java.util.Collections;

public class InitialDeck extends Deck {

    public InitialDeck() {
        super();
        for (int i = 1; i < 104; i++)
            cards.add(new Card(i));
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }

}
