package com.mathhead200.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck
{
	private List<Card> deck = new ArrayList<Card>(52);
	private int remaining;

	public Deck(int n) {
		while( n-- > 0 )
			for( Suit suit : Suit.values() )
				for( Rank rank : Rank.values() )
					deck.add( new Card(rank, suit) );
		shuffle();
	}

	public Deck() {
		this(1);
	}

	public Card draw() {
		if( remaining == 0 )
			return null;
		Card card = deck.remove(0);
		remaining--;
		deck.add(card);
		return card;
	}

	public int getRemaining() {
		return remaining;
	}

	public void shuffle() {
		Collections.shuffle(deck);
		remaining = deck.size();
	}
}
