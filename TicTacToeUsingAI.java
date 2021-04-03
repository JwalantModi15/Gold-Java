package LogicGames;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToeUsingAI {
	static char board [][];
	static ArrayList<String> arr = new ArrayList<>();
	static char opt[] = {'O','X'};
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		String name[] = new String[1];
		board = new char[3][3];
		System.out.print("Enter First Player Name: ");
		name[0] = input.next();
		System.out.println();
		System.out.println("Player "+name[0]+" - (O)");
		System.out.println("Computer - (X)\n");
		int r,c;
		String n;
		char ch;
		printBoard(board);
		while(true) {
			System.out.print("\n\nPlayer 1 - O");
			System.out.print("\nEnter row and column (1,2,3): ");
			r = input.nextInt();
			c = input.nextInt();
			while(r <= 0 || r > 3 || c <= 0 || c > 3 || arr.contains(""+(r-1)+(c-1))) {
				System.out.println("Enter valid row and column number (1,2,3): ");
				r = input.nextInt();
				c = input.nextInt();
			}
			n = ""+(r-1)+(c-1);
//			System.out.println(n);
			arr.add(n);
			board[r-1][c-1] = 'O';
			if(winner('O')) {
				printBoard(board);
				System.out.println("\nPlayer 1 "+name[0]+" Wins!");
				System.out.print("\n Want to Play Again [Y/N]: ");
				ch = input.next().toUpperCase().charAt(0);
				if(ch=='Y') {
					reset();
					printBoard(board);
					continue;
				}
				else{
					break;
				}
				
			}else if(tie()){
				printBoard(board);
				System.out.println("\nMatch Ties!");
				System.out.print("\n Want to Play Again [Y/N]: ");
				ch = input.next().toUpperCase().charAt(0);
				if(ch=='Y') {
					reset();
					printBoard(board);
					continue;
				}
				else{
					break;
				}
				
			}else {
				printBoard(board);
			}
			
			System.out.print("\nPlayer 2 - X\n\n");
			AI();
			if(winner('X')) {
				printBoard(board);
				System.out.println("\nComputer Wins!");
				System.out.print("\n Want to Play Again [Y/N]: ");
				ch = input.next().toUpperCase().charAt(0);
				if(ch=='Y') {
					reset();
					printBoard(board);
					continue;
				}
				else{
					break;
				}
			}
			else if(tie()){
				printBoard(board);
				System.out.println("\nMatch Ties!");
				System.out.print("\n Want to Play Again [Y/N]: ");
				ch = input.next().toUpperCase().charAt(0);
				if(ch=='Y') {
					reset();
					printBoard(board);
					continue;
				}
				else{
					break;
				}
				
			}
			else{
				printBoard(board);
			}
		}
		input.close();

	}
	public static void printBoard(char board[][]) {
		int i,j;
		for(i=0;i<board.length;i++) {
			for(j=0;j<board[i].length;j++) {
				System.out.print(" "+board[i][j]);
				if(j<2) {
					System.out.print(" |");
				}
			}
			if(i<2) {
				System.out.println();
				System.out.println("---+---+---");
			}
		}
	}
	public static boolean winner(char ch) {
		return (board[0][0] == ch && board[0][1] == ch && board[0][2] == ch ||
				board[1][0] == ch && board[1][1] == ch && board[1][2] == ch ||
				board[2][0] == ch && board[2][1] == ch && board[2][2] == ch ||
				board[0][0] == ch && board[1][0] == ch && board[2][0] == ch ||
				board[0][1] == ch && board[1][1] == ch && board[2][1] == ch ||
				board[0][2] == ch && board[1][2] == ch && board[2][2] == ch ||
				board[0][0] == ch && board[1][1] == ch && board[2][2] == ch ||
				board[0][2] == ch && board[1][1] == ch && board[2][0] == ch);
	}
	public static boolean tie() {
		return (board[0][0] != '\0' && board[0][1] != '\0' && board[0][2] != '\0' &&
				board[1][0] != '\0' && board[1][1] != '\0' && board[1][2] != '\0' &&
				board[2][0] != '\0' && board[2][1] != '\0' && board[2][2] != '\0' &&
				board[0][0] != '\0' && board[1][0] != '\0' && board[2][0] != '\0' &&
				board[0][1] != '\0' && board[1][1] != '\0' && board[2][2] != '\0' &&
				board[0][2] != '\0' && board[1][2] != '\0' && board[2][2] != '\0' &&
				board[0][0] != '\0' && board[1][1] != '\0' && board[2][2] != '\0' &&
				board[0][2] != '\0' && board[1][1] != '\0' && board[2][0] != '\0');
	}
	public static void AI() {
		int i,j,count=0,r1,c1;
		String s;
		for (char ch:opt) {
			for(i=0;i<board.length;i++) {
				for(j=0;j<board[i].length;j++) {
					if(!arr.contains(""+i+j)) {
						board[i][j] = ch;
						if(winner(ch)) {
							board[i][j] = 'X';
							arr.add(""+i+j);
							count=1;
							return;
						}
						board[i][j] = '\0';
//						s = ""+i+j;
					}
				}
			}
		}
		if(count==0) {
			r1 = Random.randint(0, 2);
			c1 = Random.randint(0, 2);
			s = ""+r1+c1;
			while(arr.contains(s)) {
				r1 = Random.randint(0, 2);
				c1 = Random.randint(0, 2);
				s = ""+r1+c1;
			}
			arr.add(s);
			board[r1][c1] = 'X';
		}
	}
	public static void reset() {
		int i,j;
		for(i=0;i<board.length;i++) {
			for(j=0;j<board[i].length;j++) {
				board[i][j] = '\0';
			}
		}
			arr.clear();
	}

}
