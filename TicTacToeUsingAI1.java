package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import LogicGames.Random;

public class TicTacToeUsingAI1 extends JFrame {

	/**
	 * 
	 */
	static ArrayList<Integer> array = new ArrayList<>();
	static JButton arr[] = new JButton[9];
	private static final long serialVersionUID = 1L;
//	JButton b1;
	static String sign[] = {"O","X"};
	int k = 0;
	public TicTacToeUsingAI1(String s) {
		super(s);
	}
	public void set() {
		int i,j;
		int h = 100,w = 100,x = 0,y = 0;
		setLayout(null);
//		for(i = 0;i <= 8;i++) {
//			array.add(i);
//		}
		for(i=1;i<=3;i++) {
			for(j=1;j<=3;j++) {
				arr[k] = new JButton();
				arr[k].setBounds(x, y, w, h);
				add(arr[k]);
				arr[k].setFont(new Font("Arial", Font.PLAIN, 25));
				arr[k].addActionListener(new handler(k));
				k++;
				x = x + 100;
			}
			x = 0;
			y = y + 100;
		}
//		arr[0].addActionListener(new handler(0));
//		arr[1].addActionListener(new handler(1));
//		arr[2].addActionListener(new handler(2));
//		arr[3].addActionListener(new handler(3));
//		arr[4].addActionListener(new handler(4));
//		arr[5].addActionListener(new handler(5));
//		arr[6].addActionListener(new handler(6));
//		arr[7].addActionListener(new handler(7));
//		arr[8].addActionListener(new handler(8));
		
	}
	public static void main(String[] args) {
		TicTacToeUsingAI1 f1 = new TicTacToeUsingAI1("Tic Tac Toe");
		f1.setVisible(true);
		f1.setSize(312,335);
		f1.set();
		f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	class handler implements ActionListener {
		int n;
		public handler(int n){
			this.n = n;
		}
		public void actionPerformed(ActionEvent e) {
			int n1;
			if(arr[n].getText().equals("")) {
				arr[n].setText("O");
				array.add(n);
				if(winner("O")) {
					JOptionPane.showMessageDialog(arr[n], "You Wins!");
					reset();
					return;
				}
				else if(Tie()) {
					JOptionPane.showMessageDialog(arr[n], "Match Ties!");
					reset();
					return;
				}
				
				n1 = AI();
				arr[n1].setText("X");
				array.add(n1);
				
				if(winner("X")) {
					JOptionPane.showMessageDialog(arr[n1], "Computer Wins!");
					reset();
					return;
				}else if(Tie()) {
					JOptionPane.showMessageDialog(arr[n1], "Match Ties!");
					reset();
					return;
				}
				
			}
		}
	}
	public static boolean winner(String s) {
		return (arr[0].getText().equals(s) && arr[1].getText().equals(s) && arr[2].getText().equals(s) ||
				arr[3].getText().equals(s) && arr[4].getText().equals(s) && arr[5].getText().equals(s) ||
				arr[6].getText().equals(s) && arr[7].getText().equals(s) && arr[8].getText().equals(s) ||
				arr[0].getText().equals(s) && arr[3].getText().equals(s) && arr[6].getText().equals(s) ||
				arr[1].getText().equals(s) && arr[4].getText().equals(s) && arr[7].getText().equals(s) ||
				arr[2].getText().equals(s) && arr[5].getText().equals(s) && arr[8].getText().equals(s) ||
				arr[0].getText().equals(s) && arr[4].getText().equals(s) && arr[8].getText().equals(s) ||
				arr[2].getText().equals(s) && arr[4].getText().equals(s) && arr[6].getText().equals(s));
	}
	public static int AI() {
		int count = 0,n1;
		for(String n:sign) {
			for(int i=0;i<=8;i++) {
				if(!array.contains(i)) {
					arr[i].setText(n);
					if(winner(n)) {
						arr[i].setText("");
						count = 1;
						return i;
					}
					arr[i].setText("");
				}
			}
		}
		if(count == 0) {
			n1 = Random.randint(0, 8);
			while(array.contains(n1)) {
				n1 = Random.randint(0, 8);
			}
			return n1;
		}
		return -1;
	}
	public void reset() {
		for(int i = 0;i < 9;i++) {
			arr[i].setText("");
		}
		k = 0;
		array.clear();
	}
	public boolean Tie() {
		return (!arr[0].getText().equals("") && !arr[1].getText().equals("") && !arr[2].getText().equals("")
				&& !arr[3].getText().equals("") && !arr[4].getText().equals("") && !arr[5].getText().equals("")
				&& !arr[6].getText().equals("") && !arr[7].getText().equals("") && !arr[8].getText().equals(""));
	}

}
