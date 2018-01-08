package com.mathhead200.blackjack;

import java.util.Scanner;


public class Blackjack
{
	public static void main(String[] args) throws Exception
	{
		Deck deck = new Deck(6);
		Scanner stdin = new Scanner(System.in);

		while(true) {
			if( deck.getRemaining() < 104 ) {
				System.out.print("... ");
				deck.shuffle();
				System.out.println("Shuffled the deck.\n");
			}

			Hand dealer = new Hand(deck);
			Hand player = new Hand(deck);
			System.out.println("----------------------------------------");
			System.out.println( "Dealer: " + "[--]" + dealer.getCards().get(1) );
			System.out.println( "Player: " + player );

			if( player.getValue() == Hand.LIMIT )
				System.out.println("\nBlackjack!");

			//Player's turn
			String line;
			while(true) {
				System.out.print("\nHit or Stand: ");
				line = stdin.nextLine();
				if( line.equalsIgnoreCase("stand") ) {
					player.stand();
					System.out.println("Player stands with " + player.getValue() + ".");
					break;
				} else if( line.equalsIgnoreCase("hit") ) {
					player.hit();
					System.out.println("Player hits.");
					System.out.println( "Player: " + player );
					if( player.busted() ) {
						System.out.println("Player busted with " + player.getValue() + ".");
						break;
					}
				} else
					System.out.println("Invalid command.");
			}

			Thread.sleep(1500);
			if( player.busted() ) {
				System.out.println("\nDealer wins.\n");
				Thread.sleep(1500);
				continue;
			}
			System.out.println( "\nDealer: " + dealer );
			System.out.println( "Player: " + player );

			//Dealer's turn
			while(true) {
				System.out.print("\n... ");
				Thread.sleep(1500);
				if( dealer.getValue() >= 17 ) {
					dealer.stand();
					System.out.println("Dealer stands with " + dealer.getValue() + ".");
					break;
				} else {
					dealer.hit();
					System.out.println("Dealer hits.");
					System.out.println( "Dealer: " + dealer );
					if( dealer.busted() ) {
						System.out.println( "Dealer busted with " + dealer.getValue() + "." );
						break;
					}
				}
			}

			Thread.sleep(1500);
			if( dealer.busted() || player.getValue() > dealer.getValue() )
				System.out.println("\nPlayer wins!\n");
			else if( dealer.getValue() > player.getValue() )
				System.out.println("\nDealer wins!\n");
			else
				System.out.println("\nPush.\n");
			Thread.sleep(1500);
		}
	}
}
