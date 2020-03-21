package com.company;

public class Main {

    public static void main(String[] args) {
	     // write your code here
    }
}

class Card {
    enum Suit { clubs, diamonds, hearts, spades };
    char value;
    Suit suit;
    boolean errorFlag;

    Card() {
        // no arg constructor default card is A of spades
    }

    Card(char value, Suit suit) {
        // constructor that sets card with args
    }

    public String toString() {
        return ""; // stringify this Card
    }

    boolean set(char value, Suit suit) {
        // do validation and set card
        return true; // return true if validation passed or false
    }

    public Suit getSuit() {
        return Suit.clubs; // return this to be actual suit of card
    }

    public char getValue() {
        return 'T'; // return this to be actual value of card
    }

    private boolean isValid(char value, Suit suit) {
        return true;
    }
}

class Hand {

}

class Deck {

}
