package LogicGames;

import java.util.Scanner;

public class JumbleWordGame {

	public static void main(String[] args) {
		selector();
	}
	public static void selector() {
		String jumble[] = {"NIDIA","FLNANID","NZEWEAANLD","SUA","AJANP"};
		String act[] = {"INDIA","FINLAND","NEWZEALAND","USA","JAPAN"};
		Scanner input = new Scanner(System.in);
		int n = Random.randint(0, 4),c=0;
		System.out.println(jumble[n]+"\n");
		System.out.print("Enter a String: ");
		String name = input.next().toUpperCase();
		while(true) {
			for(String i:act) {
				if(name.equals(i)){
					System.out.println("\nYou Win!");
					c=1;
					break;
				}
			}
			if(c==0) {
				System.out.print("\nEnter a String: ");
				name = input.next().toUpperCase();
			}
			else {
				break;
			}
		}
		input.close();
	}
	

}
