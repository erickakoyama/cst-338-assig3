package com.company;

import com.company.Card.Suit;

/**
 * Deck class represents a deck of cards.
 */
public class Deck {
   public static final int MAX_CARDS = 312; // 6*52 packs of 52 cards
   private static int PACK_SIZE = 52;
   private static Card[] masterPack = new Card[PACK_SIZE];
   private Card[] cards;
   private int topCard; // 0 when the deck is empty

   /**
    * No argument constructor
    */
   Deck() {
      this(1); // default size of 1 pack
   }

   /**
    * Constructor with number of packs.
    *
    * @param numPacks Number of packs to include in deck.
    */
   Deck(int numPacks) {
      topCard = 0;
      cards = new Card[MAX_CARDS];

      allocateMasterPack();
      init(numPacks);
   }

   /**
    * Fill up the deck with the given number of card packs.
    *
    * @param numPacks Number of packs to initialize the deck.
    */
   public void init(int numPacks) {
      // fill up cards array
      topCard = numPacks * PACK_SIZE;
      for (int i = 0; i < numPacks; i++) {
         for (int j = 0; j < PACK_SIZE; j++) {
            cards[(PACK_SIZE * i) + j] = new Card(masterPack[j]);
         }
      }
   }

   /**
    * Shuffle the deck in a random order.
    */
   public void shuffle() {
      // mixes up the cards with the help of the standard random number generator.
      for (int i = 0; i < topCard; i++) {
         int index = (int) (Math.random() * (PACK_SIZE - 1));
         Card temp = cards[index];
         cards[index] = cards[i];
         cards[i] = temp;
      }
   }

   /**
    * Deal out a Card from cards.
    *
    * @return Card dealt.
    */
   public Card dealCard() {
      if (topCard > 0) {
         topCard--;
         return new Card(cards[topCard]);
      } else {
         return new Card('X', Suit.SPADES);
      }
   }

   public int getTopCard() {
      return topCard;
   }

   /**
    * Return a Card with errorFlag = true, if k is out of range.
    * pre-condition: deck is not empty and k is within range.
    *
    * @param k The index of the card to inspect.
    * @return The Card at the index or an illegal Card.
    */
   public Card inspectCard(int k) {
      if (topCard != 0 && k >= 0 && k < topCard) {
         return new Card(cards[k]);
      }

      return new Card('X', Suit.DIAMONDS);
   }

   /**
    * Fill the masterPack card array. We should only do this once,
    * regardless of how many Deck objects there are.
    */
   private static void allocateMasterPack() {
      if (masterPack[0] != null) { // return early if we have already executed this setup
         return;
      }

      Suit[] suits = Suit.values();
      char[] values = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};

      // fill every value of a suit before moving to the next suit
      for (int i = 0; i < suits.length; i++) {
         for (int j = 0; j < values.length; j++) {
            masterPack[(values.length * i) + j] = new Card(values[j], suits[i]);
         }
      }
   }
}
