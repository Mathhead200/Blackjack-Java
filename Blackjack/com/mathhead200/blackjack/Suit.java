package com.mathhead200.blackjack;


public enum Suit
{
	CLUB("c"), DIAMOND("d"),
	HEART("h"), SPADE("s");

	private String str;

	private Suit(String str) {
		this.str = str;
	}

	public String toString() {
		return str;
	}
}
