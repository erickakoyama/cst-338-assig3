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
      this.value = 'A';
      this.suit = Suit.SPADES;
   }

   public Card(char value, Suit suit) {
      this.set(value, suit);
   }

   public boolean equals(Card card) {
      return card.getSuit() == this.suit && card.getValue() == this.value;
   }

   public boolean getErrorFlag() {
      return this.errorFlag;
   }

   public Suit getSuit() {
      return this.suit;
   }

   public char getValue() {
      return this.value;
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
         this.errorFlag = false;
         this.value = value;
         this.suit = suit;
      } else {
         this.errorFlag = true;
      }

      return !this.errorFlag;
   }

   public String toString() {
      if (!errorFlag) {
         return this.value + " of " + this.suit;
      } else {
         return "** illegal **";
      }
   }
}
