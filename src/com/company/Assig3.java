package com.company;

import java.util.*;

public class Assig3 {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);

      testDeck(2);

      System.out.println();  System.out.println(); // separate outputs

      testDeck(1);

      System.out.println();  System.out.println(); // separate outputs

      assign3Tester(keyboard);

      keyboard.close();
   }

   public static void dealDeckToScreen(Deck deck) {
      while (deck.getTopCard() > 0) {
         if (deck.getTopCard() > 0) {
            System.out.print(deck.dealCard() + " / ");
         }
      }
   }

   public static void testDeck(int numPacks) {
      Deck deck = new Deck(numPacks);

      dealDeckToScreen(deck); // unshuffled
      System.out.println();  System.out.println(); // separate outputs

      deck.init(numPacks);
      deck.shuffle();

      dealDeckToScreen(deck); //shuffled
   }

    /* 
    Test Hand Class
    */
    public static void handTester()
    {
        // Hand class test run
        Card c1 = new Card('3', Card.Suit.CLUBS);
        Card c2 = new Card('Q', Card.Suit.HEARTS);
        Card c3 = new Card('K', Card.Suit.DIAMONDS);
        Card c4 = new Card();

        Hand h = new Hand();

        boolean handNotFull = true;
        // Add cards to hand until full
        while(handNotFull)
        {
            h.takeCard(c1);
            h.takeCard(c2);
            h.takeCard(c3);
            handNotFull = h.takeCard(c4); // this will tell us if we've filled our hand in our latest iteration
        }
        System.out.println("Hand full \nAfter deal");

        System.out.println(h.toString());

        System.out.println("Testing inspectCard()");
        Card c = h.inspectCard(25);
        c.toString();

        // Play all cards in hand
        for(int i = h.getNumCards(); i > 0; i--)
        {
            Card topCard = h.playCard();
            System.out.println("Playing " + topCard.toString());
        }

        System.out.println("After playing all cards");
        System.out.println(h.toString());
    }
    
   /**
    * Test Deck and Hand class
    */
   public static void assign3Tester(Scanner keyboard) {
      int numPlayers;
      int minPlayers = 1;
      int maxPlayers = 10;
      Hand[] players = new Hand[maxPlayers];


      do {
         System.out.print("How many hands? (" + minPlayers + " - " + maxPlayers + ", please): ");
         numPlayers = keyboard.nextInt();

         for (int i = 0; i < numPlayers; i++) {
            players[i] = new Hand();
         }

         Deck deck = new Deck();
         dealOutDeck(deck, players, numPlayers);

         System.out.println("Here are our hands, from unshuffled deck:");
         printHands(players, numPlayers);

         // reset deck and hands
         deck.init(1);
         for (int i = 0; i < numPlayers; i++) {
            players[i].resetHand();
         }

         // shuffle deck and deal again
         deck.shuffle();
         dealOutDeck(deck, players, numPlayers);

         System.out.println("Here are our hands, from SHUFFLED deck:");
         printHands(players, numPlayers);

      } while (numPlayers < minPlayers || numPlayers > maxPlayers); // keep asking until we get a valid input.
   }

   public static void dealOutDeck(Deck deck, Hand[] players, int numPlayers) {
      while (deck.getTopCard() > 0) {
         for (int i = 0; i < numPlayers; i++) {
            if (deck.getTopCard() > 0) {
               players[i].takeCard(deck.dealCard());
            }
         }
      }
   }

   public static void printHands(Hand[] hands, int numPlayers) {
      for (int i = 0; i < numPlayers; i++) {
        System.out.println(hands[i].toString());
        System.out.println(); // separate outputs
      }
   }
}
