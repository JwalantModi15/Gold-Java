package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ClassesAndObjects.Shuffle;

public class Minesweeper extends JFrame{

	/**
	 * 
	 */
	JButton arr[] = new JButton[25];
	int k;
	String array[] = {"1","23","3","4","5","Bomb","21","7","8","9","0",
					  "10","A","B","C","D","E","@","Bomb","$","&",
					  "12","15","J","Bomb"};
	
	private static final long serialVersionUID = 1L;
	
	public Minesweeper(String s) {
		super(s);
	}
	public void set() {
		array = Shuffle.shuffle(array);
		setLayout(new GridLayout(5,5));
		k = 0;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				arr[k] = new JButton();
				add(arr[k]);
				arr[k].addActionListener(new handler(k));
				arr[k].setFont(new Font("Arial", Font.PLAIN, 25));
				k++;
			}
		}
	}

	public static void main(String[] args) {
		Minesweeper obj = new Minesweeper("Minesweeper Game");
		obj.setVisible(true);
		obj.setSize(515,485);
		obj.setResizable(false);
		obj.set();
		obj.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	class handler implements ActionListener{
		private int n;
		public handler(int k) {
			n = k;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(array[n].equals("Bomb")) {
				arr[n].setBackground(Color.red);
				arr[n].setForeground(Color.white);
				arr[n].setText(array[n]);
				JOptionPane.showMessageDialog(arr[n], "You Lose!");
				reset();
			}
			else{
				arr[n].setText(array[n]);
			}
		}
	}
	public void reset() {
		int k1 = 0;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(!arr[k1].getText().equals("")) {
					arr[k1].setText("");
				}
				if(arr[k1].getBackground() == Color.red && arr[k1].getForeground() == Color.white) {
					arr[k1].setBackground(null);
					arr[k1].setForeground(Color.black);
				}
				if(k1<25) {
					k1++;
				}
			}
		}
		k = 0;
		array = Shuffle.shuffle(array);
	}
}
