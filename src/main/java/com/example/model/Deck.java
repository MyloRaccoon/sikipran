package com.example.model;

import java.util.ArrayList;

public class Deck {

    protected ArrayList<Card> cards;

    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> cards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void add(Card card) {
        cards.add(card);
    }

    public Card remove(int index) {
        return cards.remove(index);
    }

    public Card getCardFromNumber(int number) {
        Card card = null;
        int i = 0;
        while (i < cards.size() && card == null) {
            if (cards.get(i).number() == number)
                card = cards.get(i);
            i++;
        }
        if (card == null)
            card = new Card(-1);
        return card;
    }

    public int getIndexOf(Card card) {
        return cards.indexOf(card);
    }

    public int heads() {
        int v = 0;
        for (Card card : cards) {
            v += card.head();
        }
        return v;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString() + " ");
        }
        return sb.toString();
    }
}
