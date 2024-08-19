package com.example.model;

public class Card implements Comparable<Card> {

    private final int number;
    private final int head;

    public Card(int number) {
        this.number = number;
        if (number == 55)
            this.head = 7;
        else if (number % 11 == 0)
            this.head = 5;
        else if (number % 10 == 0)
            this.head = 3;
        else if (number % 5 == 0)
            this.head = 2;
        else
            this.head = 1;
    }

    public int number() {
        return number;
    }

    public int head() {
        return head;
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.number(), other.number());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(Integer.toString(number));

        builder.append("(");
        for (int i = 0; i < head; i++)
            builder.append("*");
        builder.append(")");

        return builder.toString();
    }
}
