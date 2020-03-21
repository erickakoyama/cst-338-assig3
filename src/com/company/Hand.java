package com.company;

class Hand 
{
    // Limit size of array
    public static final int MAX_CARDS = 100;    

    private Card[] myCards;
    private int numCards;

    // Default constructor
    public void Hand()
    {
        resetHand();
    }
    // Remove all cards from the hand
    public void resetHand()
    {
        myCards = new int[MAX_CARDS];
        numCards = 0;
    }
    // Add a card to the next available position in the myCards array
    public boolean takeCard(Card card)
    {
        myCards[numCards] = card;
        numCards += 1;
    }
    // Removes and returns the card in the top occupied position of the array
    public Card playCard()
    {
        Card card = myCards[numCards];
        myCards[numCards] = null;
        numCards -= 1;
        return card;
    }
    // Diplay the entire hand
    public String toString()
    {
        String result = '';
        for(int i = 0; i< numCards; i++)
        {

        }
    }
    // Diplay the entire hand
    public int getNumCards()
    {

    }
    // Access individual card. Return card with error flag if k is bad
    public Card inspectCard(int k)
    {

    }
