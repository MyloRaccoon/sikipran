package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import com.example.Menu;

public class Game {

    private InitialDeck deck;

    private Row row1;
    private Row row2;
    private Row row3;
    private Row row4;
    private ArrayList<Row> rows;

    private ArrayList<Player> players;

    public Game(ArrayList<String> playersNames) {
        this.deck = new InitialDeck();

        players = new ArrayList<Player>();

        for (String playerName : playersNames) {
            Deck hand = new Deck();
            for (int i = 0; i < 10; i++)
                hand.add(deck.draw());

            players.add(new Player(playerName, hand));
        }

        row1 = new Row("1", deck.draw());
        row2 = new Row("2", deck.draw());
        row3 = new Row("3", deck.draw());
        row4 = new Row("4", deck.draw());

        rows = new ArrayList<Row>(Arrays.asList(row1, row2, row3, row4));
    }

    public Game(String[] playersNames) {
        this(new ArrayList<String>(Arrays.asList(playersNames)));
    }

    public void game() {
        HashMap<Card, Player> playerCards = new HashMap<>();
        ArrayList<Card> cardsToOrder = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (Player player : players) {
                Card card = playerChooseCard(player);
                playerCards.put(card, player);
                cardsToOrder.add(card);
            }
            Collections.sort(cardsToOrder);
            for (Card card : cardsToOrder) {
                Player player = playerCards.get(card);
                int indexCard = player.getIndexOf(card);
                Row row = getRowFromCardIFuckingHateNamingThings(card);
                boolean taking = false;
                System.out.println(player.name() + " place " + card + " sur la ligne " + row.name());
                if (row.getLastCard().number() == -1) {
                    row = askForRow();
                    taking = true;
                }

                player.play(row, indexCard, taking);
            }
            playerCards.clear();
            cardsToOrder.clear();
        }
        System.out.println("~~~~~~~~~~~~~");
        System.out.println("Resultats : ");
        for (Player player : players) {
            System.out.println(player.name() + " : " + Integer.toString(player.points()) + "\n");
        }
    }

    public Row askForRow() {
        ArrayList<String> rowStrings = new ArrayList<>();
        for (Row row : rows)
            rowStrings.add(row.toString());
        Menu rowMenu = new Menu("choisissez une ligne.", rowStrings);
        return rows.get(rowMenu.ask());
    }

    public Row getRowFromCardIFuckingHateNamingThings(Card card) {
        ArrayList<Card> allLastCard = new ArrayList<>();
        HashMap<Card, Row> cardsNrows = new HashMap<>();
        Row rowToPut;

        for (Row row : rows) {
            Card lCard = row.getLastCard();
            allLastCard.add(lCard);
            cardsNrows.put(lCard, row);
        }
        Collections.sort(allLastCard);
        Collections.reverse(allLastCard);

        int i = -1;
        Card lastCard;
        do {
            i++;
            lastCard = allLastCard.get(i);
        } while (i < 3 && lastCard.number() > card.number());

        if (lastCard.number() > card.number())
            rowToPut = new Row("default", new Card(-1));
        else
            rowToPut = cardsNrows.get(lastCard);

        return rowToPut;
    }

    public Card playerChooseCard(Player player) {
        System.out.println(this);
        System.out.println(player);
        Card card = new Card(-1);
        while (card.number() == -1) {
            System.out.println("Quel carte jouer ?");
            int answer = new Scanner(System.in).nextInt();
            card = player.getCardIndex(answer);
            if (card.number() == -1)
                System.out.println("vous ne possedez pas cette carte.");
        }
        return card;
    }

    @Override
    public String toString() {
        StringBuilder game = new StringBuilder("~~Rows~~\n");
        for (int i = 0; i < 4; i++) {
            game.append(Integer.toString(i + 1));
            game.append(" : ");
            game.append(rows.get(i).toString());
            game.append("\n");
        }
        return game.toString();

    }

}
