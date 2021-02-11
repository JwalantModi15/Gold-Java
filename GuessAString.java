package LogicGames;

import java.util.Scanner;

public class GuessAString {

	public static void main(String[] args) {
		guessString();
	}
	public static void decideString(String str) {
		Scanner input = new Scanner(System.in);
		String arr[] = {"JAVA","PYTHON","NETWORKING","ANDROID","WEBSITES"};
		int i = Random.randint(0, 4);
		String actString = arr[i];
//		System.out.println(actString);
		int trial = 5;
		while(trial > 1 && (!actString.equals(str))) {
			if(trial > 1) {
				trial--;
				System.out.println("You Lose one Chance guess one more time!");
				System.out.print("Enter a String: ");
				String name = input.nextLine();
				System.out.println();
				str = name.toUpperCase();
			}
			
		}
		if(actString.equals(str)) {
			System.out.println("You Wins!");
		}
		else if(trial == 1){
			System.out.println("You Lose!");
		}
		input.close();
	}
	public static void guessString() {
		Scanner input = new Scanner(System.in);
		System.out.println("Guess a String from group of Strings mention below");
		System.out.println("Java, Python, Networking, Android, Websites");
		System.out.print("\nEnter a String: ");
		String name = input.nextLine();
		decideString(name.toUpperCase());
		input.close();
	}

}
