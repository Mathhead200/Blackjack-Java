package com.mathhead200.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Hand
{
	public static int LIMIT = 21;

	private Deck deck;
	private List<Card> cards = new ArrayList<Card>();
	private int value = 0;
	private int highAces = 0;
	private boolean standing = false;

	public Hand(Deck deck) {
		this.deck = deck;
		hit();
		hit();
	}

	public void hit() {
		Card card = deck.draw();
		cards.add(card);

		value += card.getValue();
		if( card.rank == Rank.ACE && value + 10 <= LIMIT ) {
			value += 10;
			highAces++;
		} else if( value > LIMIT && highAces > 0 ) {
			value -= 10;
			highAces--;
		}
	}

	public void stand() {
		standing = true;
	}

	public boolean busted() {
		return value > LIMIT;
	}

	public boolean standing() {
		return standing;
	}

	public int getValue() {
		return value;
	}

	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for( Card card : cards )
			sb.append( card.toString() );
		return sb.toString();
	}
}
