package com.company;
class Hand 
  {
      // Limit size of array
      public static final int MAX_CARDS = 50;    

      private Card myCards[];
      private int numCards;

      // Default constructor
      Hand()
      {
          resetHand();
      }
      // Remove all cards from the hand
      public void resetHand()
      {
          System.out.println("reset hand");
          this.myCards = new Card[MAX_CARDS];
          this.numCards = 0;
          System.out.println(myCards.length);
      }
      // Add a copy of the card to the next available position in the myCards array, returns true on success (took this to mean room in myCards)
      public boolean takeCard(Card card)
      {
          if(numCards < MAX_CARDS)
          {
              Card newCard = new Card(card.getValue(), card.getSuit());
              System.out.println(newCard.toString());
              myCards[numCards] = newCard;
              System.out.println("added to myCards: " + newCard.toString());
              this.numCards += 1;
              return true;
          }
          return false;
      }
      // Removes and returns the card in the top occupied position of the array
      public Card playCard()
      {
          Card card = myCards[numCards-1];
          myCards[numCards-1] = null;
          numCards -= 1;
          return card;
      }
      // Diplay the entire hand
      public String toString()
      {
          String result = "Hand = ( ";
          for(int i = 0; i < numCards; i++)
          {
              result = result + myCards[i].toString() + ", ";
          }
          // Remove last trailing comma and add closing parenthesis
          if(numCards > 0) result = result.substring(0, result.length() - 2);
          return result + " )";
      }
      // Diplay the entire hand
      public int getNumCards()
      {
          return numCards;
      }
      // Access individual card. Return card with error flag if k is bad
      public Card inspectCard(int k)
      {
          if(0 <= k && k < numCards)
          {
              return myCards[k];
          }
          // Return a card with an error flag
          return new Card('1', Card.Suit.CLUBS);
      }
  }
