package com.company;

public class Main {

    public static void main(String[] args) {
       Card cardOne = new Card('Q', Card.Suit.HEARTS);
       Card cardTwo = new Card('2', Card.Suit.CLUBS);
       Card cardThree = new Card('B', Card.Suit.SPADES);

       System.out.println(cardOne.toString());
       System.out.println(cardTwo.toString());
       System.out.println(cardThree.toString());
       System.out.println();

       cardTwo.set('F', Card.Suit.HEARTS); // make illegal
       cardThree.set('6', Card.Suit.DIAMONDS); // make legal

       System.out.println(cardOne.toString());
       System.out.println(cardTwo.toString());
       System.out.println(cardThree.toString());
    }
}
