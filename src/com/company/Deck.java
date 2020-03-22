package com.company;

import com.company.Card.Suit;

public class Deck {
   public final int MAX_CARDS = 312; // 6*52 packs of 52 cards
   private static int PACK_SIZE = 52;
   private static Card[] masterPack = new Card[PACK_SIZE];
   private Card[] cards = new Card[MAX_CARDS];
   private int topCard;

   /**
    * No argument constructor
    */
   Deck() {
      this(1); // default size of 1 pack

      allocateMasterPack();
   }


   Deck(int numPacks) {
      topCard = 0;
      allocateMasterPack();

      init(numPacks);
   }

   public void init(int numPacks) {
      // fill up cards array
      for (int i = 0; i < numPacks; i++) {
         for (int j = 0; j < PACK_SIZE; j++) {
            topCard++;
            cards[(PACK_SIZE * i) + j] = new Card(masterPack[j]);
         }
      }
   }

   public void shuffle() {
      // mixes up the cards with the help of the standard random number generator.
   }

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
    * @param k
    * @return
    */
   public Card inspectCard(int k) {
      if (k <= topCard) {
         return new Card(cards[k]);
      }

      return new Card('X', Suit.DIAMONDS);
   }

   /**
    * Should not be called more than once, so even if there are multiple
    * Deck instances in a client, this should only execute once.
    */
   private static void allocateMasterPack(){
      if (masterPack[0] != null) { // if there are already cards in masterPack we can return early
         return;
      }

      Suit[] suits = Suit.values();
      char[] values = {'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2', 'A'};

      // Load all the cards into the master pack
      for (int i = 0; i < values.length; i++) {
         for (int j = 0; j < suits.length; j++) {
            masterPack[(suits.length * i) + j] = new Card(values[i], suits[j]);
         }
      }
   }
}
