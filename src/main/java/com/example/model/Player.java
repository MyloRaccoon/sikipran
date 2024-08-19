package com.example.model;

import java.util.ArrayList;

public class Player {

    private final String name;
    private Deck hand;
    private int points;

    public Player(String name, Deck hand) {
        this.name = name;
        this.hand = hand;
    }

    public Player(String name, ArrayList<Card> cards) {
        this(name, new Deck(cards));
    }

    public Deck hand() {
        return hand;
    }

    public void set_hand(Deck hand) {
        this.hand = hand;
    }

    public void set_hand(ArrayList<Card> cards) {
        this.hand = new Deck(cards);
    }

    public String name() {
        return name;
    }

    public int points() {
        return points;
    }

    public Card getCardIndex(int number) {
        return hand.getCardFromNumber(number);
    }

    public int getIndexOf(Card card) {
        return hand.getIndexOf(card);
    }

    public void play(Row row, int index, boolean taking) {
        points += row.put(hand.remove(index), taking);
    }

    public void play(Row row, int index) {
        points += row.put(hand.remove(index), false);
    }

    @Override
    public String toString() {
        return name + " : " + hand;
    }

}
