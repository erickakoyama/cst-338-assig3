package com.company;
/**
* Hand class represents a hand of cards held by a user.
*/
class Hand {
   // Limit size of array
   public static final int MAX_CARDS = 50;    

   private Card myCards[];
   private int numCards;

   /**
   * No argument constructor
   */
   Hand() {
      resetHand();
   }

   /**
   * Remove all cards from the hand.
   */
   public void resetHand() {
      this.myCards = new Card[MAX_CARDS];
      this.numCards = 0;
   }

   /**
   * Add a copy of the card to the next available position in the myCards array.
   * @param card Card instance to add to the hand.
   * @return true on success array insert, false otherwise
   */
   public boolean takeCard(Card card) {
      if(numCards < MAX_CARDS) {
         Card newCard = new Card(card.getValue(), card.getSuit());
         myCards[numCards] = newCard;
         this.numCards += 1;
         return true;
      }
      return false;
   }

   /**
   * Removes and returns the card in the top occupied position of the array.
   * @return the card that was removed from the top of the array, or Card with error flag if nocards to play.
   */
   public Card playCard() {
      if(numcards > 0) {
         numcards--;
         Card card = myCards[numCards];
         return card;
      }
      // No cards to play, return a card with an error flag
      return new Card('1', Card.Suit.CLUBS);
   }

   /**
   * Diplay the entire hand.
   * @return Hand data as a String.
   */
   public String toString() {
      String result = "Hand = ( ";
      for(int i = 0; i < numCards; i++) {
         result = result + myCards[i].toString() + ", ";
      }
      // Remove last trailing comma and add closing parenthesis
      if(numCards > 0) result = result.substring(0, result.length() - 2);
      return result + " )";
   }

   /**
   * Accessor for the current number of Cards held in the Hand.
   * @return the current number of Cards held in the Hand.
   */
   public int getNumCards() {
      return numCards;
   }

   /**
   * Access individual card. 
   * @param k the position in the array to pull a Card from.
   * @return Card at k position in hand or Card with error flag if k is bad.
   */
   public Card inspectCard(int k) {
      if(0 <= k && k < numCards) {
         return myCards[k];
      }
      // Return a card with an error flag
      return new Card('1', Card.Suit.CLUBS);
   }
}
