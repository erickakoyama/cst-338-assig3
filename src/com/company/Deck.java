package com.company;

public class Deck {
   public final int MAX_CARDS = 6*52; // 6 packs of 52 cards
   private static Card[] masterPack = new Card[52];
   private Card[] cards;
   private int topCard;

   Deck() {
      // no argument constructor, assume 1 pack
   }

   Deck(int numPacks) {
      // populate various arrays
   }

   public void init(int numPacks) {
   }

   public void shuffle() {
      // shuffle cards into random order
   }

   public Card dealCard() {
      // have to remove a card from cards
      return new Card();
   }

   public int getTopCard() {
      return topCard;
   }

   public Card inspectCard(int k) {
      // We need to return a Card with errorFlag = true, if k is out of range.
      return new Card();
   }

   /**
    * Should not be called more than once, so even if there are multiple
    * Deck instances in a client, this should only execute once.
    */
   private static void allocateMasterPack(){
      if (masterPack[0] != null) { // if there are already cards in masterPack we can return early
         return;
      }

      // allocate master pack
   }
}
