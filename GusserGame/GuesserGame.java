package guesser;

import java.util.Scanner;

class Guesser {
	private String name;
	private int guessNum;

	public String getName() {
		return name;
	}

	public int getGuessNum() {
		return guessNum;
	}

	public void inputName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello Guesser, please give your name");
		name = sc.next();
	}

	public void guessNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println(name + ", Please tell the number between 1 to 100");
		guessNum = sc.nextInt();
		if (guessNum < 1 || guessNum > 100) {
			System.out.print("Invalid Number. ");
			guessNumber();
		}
	}
}

class Player {
	private String name;
	private int guessNum;

	public String getName() {
		return name;
	}

	public int getGuessNum() {
		return guessNum;
	}

	public void inputName(int index) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello Player" + index + " , please give your name");
		name = sc.next();
	}

	public void guessNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println(name + ", Please guess the number between 1 to 100");
		guessNum = sc.nextInt();
		if (guessNum < 1 || guessNum > 100) {
			System.out.print("Invalid Number. ");
			guessNumber();
		}
	}
}

class Umbire {
	Guesser g;
	Player players[];

	public void collectNames() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input number of players");
		int n = sc.nextInt();
		players = new Player[n];
		g = new Guesser();
		g.inputName();
		for (int i = 0; i < n; i++) {
			Player p = new Player();
			p.inputName(i + 1);
			players[i] = p;
		}
	}

	public void playGame() {
		collectNumFromGuesser();
		collectNumFromPlayer();
		findWinner();
		System.out.println("Please press 'Y' if you want to play again.");
		Scanner sc = new Scanner(System.in);
		String isRepeat = sc.next();
		if (isRepeat.equalsIgnoreCase("Y"))
			playGame();
		else {
			System.out.println("The Game Ends.");
			System.exit(0);
		}

	}

	private void collectNumFromGuesser() {
		g.guessNumber();
	}

	private void collectNumFromPlayer() {
		for (Player player : players) {
			player.guessNumber();
		}
	}

	private void findWinner() {
		String[] winners = new String[players.length];
		int j = 0;
		for (Player player : players) {
			if (g.getGuessNum() == player.getGuessNum()) {
				winners[j] = player.getName();
				j++;
			}
		}
		if (j == 1) {
			System.out.println(winners[0] + " Wins");
		} else if (j > 1) {
			System.out.println("The winners  are , ");
			for (int i = 0; i < j; i++) {
				System.out.println(winners[i]);
			}
		} else {
			System.out.println("Game Lost");
		}
	}
}

public class GuesserGame {

	public static void main(String[] args) {
		System.out.println("Welcome to the guessing game. ");
		Umbire u = new Umbire();
		u.collectNames();
		u.playGame();
	}

}
