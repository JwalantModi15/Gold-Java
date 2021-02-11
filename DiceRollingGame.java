package LogicGames;

import java.util.Scanner;

public class DiceRollingGame {

	public static void main(String[] args) {
		player();

	}
	public static void player() {
		int turns = 6, n1,n2,round=1,pl1 = 0,pl2 = 0;
		while(turns > 0) {
			Scanner input = new Scanner(System.in);
			System.out.println("\nPlayer 1 Turns");
			System.out.print("\nEnter 'roll' To Roll The Dice: ");
			input.next();
			n1 = Random.randint(1, 6);
			System.out.print("\nPlayer 1 Dice Through: "+n1);
			System.out.println("\n\nPlayer 2 Turns");
			System.out.print("\nEnter 'roll' To Roll The Dice: ");
			input.next();
			n2 = Random.randint(1, 6);
			System.out.print("\nPlayer 2 Dice Through: "+n2);
			System.out.println();
			if (n1==n2) {
				System.out.println("\nMatch Tie!");
			}
			else if(n1>n2) {
				pl1++;
				System.out.println("\nPlayer 1 Wins in "+round+" Round");
			}else {
				pl2++;
				System.out.println("\nPlayer 2 Wins in "+round+" Round");
			}
			turns--;
			round++;
		}
		if(pl1>pl2) {
			System.out.println("\nPlayer 1 Wins!");
		}else {
			System.out.println("\nPlayer 2 Wins!");
		}
	}
}
