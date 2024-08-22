package com.example.model;

import java.util.ArrayList;

public class Row extends Deck {

    private String name;

    public Row(String name, Card first_card) {
        super(new ArrayList<Card>());
        cards.add(first_card);
        this.name = name;
    }

    public String name() {
        return name;
    }

    public int put(Card card, boolean taking) {
        Deck cards_return = new Deck();

        if (cards.size() == 5 || taking) {
            for (Card card_return : cards) {
                cards_return.add(cards.remove(cards.indexOf(card_return)));
            }
        }

        cards.add(card);

        return cards_return.heads();
    }

    public int put(Card card) {
        return this.put(card, false);
    }

    public Card getLastCard() {
        return cards.get(cards.size() - 1);
    }
}
