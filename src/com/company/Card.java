package com.company;

public class Card {
   enum Suit {
      CLUBS,
      DIAMONDS,
      HEARTS,
      SPADES
   };
   char value;
   Suit suit;
   boolean errorFlag;

   public Card() {
      value = 'A';
      suit = Suit.SPADES;
   }

   public Card(char value, Suit suit) {
      set(value, suit);
   }

   public boolean equals(Card card) {
      return card.getSuit() == suit && card.getValue() == value;
   }

   public boolean getErrorFlag() {
      return errorFlag;
   }

   public Suit getSuit() {
      return suit;
   }

   public char getValue() {
      return value;
   }

   private boolean isValid(char value, Suit suit) {
      if (value >= '2' && value <= '9') {
         return true;
      }

      switch(value) {
         case 'T':
         case 'J':
         case 'Q':
         case 'K':
         case 'A':
            return true;
         default:
            return false;
      }
   }

   public boolean set(char value, Suit suit) {
      if (isValid(value, suit)) {
         errorFlag = false;
         this.value = value;
         this.suit = suit;
      } else {
         errorFlag = true;
      }

      return !errorFlag;
   }

   public String toString() {
      if (!errorFlag) {
         return value + " of " + suit;
      } else {
         return "** illegal **";
      }
   }
}
