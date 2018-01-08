package com.mathhead200.blackjack;


public enum Rank
{
	ACE("A"), TWO("2"), THREE("3"), FOUR("4"),
	FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"),
	NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K");

	private String str;

	private Rank(String str) {
		this.str = str;
	}

	public String toString() {
		return str;
	}
}
