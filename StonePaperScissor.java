package LogicGames;

import java.util.Scanner;

public class StonePaperScissor {

	public static void main(String[] args) {
		initial();
	}
	public static void initial() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your choice:-(Stone, Paper, Scissor): ");
		String str = input.nextLine();
		str = str.toUpperCase();
		if(str.equals("STONE") || str.equals("PAPER") || str.equals("SCISSOR")){
			decision(str);
			input.close();
		}
		else {
			System.out.println("Invalid Input?");
			System.out.print("Enter your choice:-(Stone, Paper, Scissor): ");
			initial();
		}
	}
	public static int winner(String comp, String play) {
		String st = "STONE", paper = "PAPER", sci = "SCISSOR";
		if(comp.equals(paper) && play.equals(st)) {
			return 1;
		}
		else if(comp.equals(st) && play.equals(sci)) {
			return 1;
		}
		else if(comp.equals(sci) && play.equals(paper)) {
			return 1;
		}
		else if(play.equals(st) && comp.equals(sci)) {
			return 2;
		}
		else if(play.equals(sci) && comp.equals(paper)) {
			return 2;
		}
		else if(play.equals(paper) && comp.equals(st)) {
			return 2;
		}
		else {
			return 0;
		}
	}
	public static void decision(String s) {
		String random_choices[] = {"STONE", "PAPER", "SCISSOR"};
		int i = Random.randint(0, 2);
		String choice = random_choices[i];
		int n = winner(choice, s);
//		System.out.println(choice);
		if(n==1) {
			System.out.println("System Wins!");
		}
		else if(n==2){
			System.out.print("You Wins!");
		}
		else {
			System.out.print("Match Tie!");
		}
	}

}
