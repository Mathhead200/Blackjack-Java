package com.mathhead200.blackjack;


public class Card
{
	public final Rank rank;
	public final Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getValue() {
		if( rank.compareTo(Rank.TEN) <= 0 )
			return rank.ordinal() + 1;
		return 10;
	}

	public String toString() {
		return "[" + rank + suit + "]";
	}

	public boolean equals(Object obj) {
		if( obj == this )
			return true;
		if( !(obj instanceof Card) )
			return false;
		Card card = (Card)obj;
		return suit == card.suit && rank == card.rank;
	}
}
