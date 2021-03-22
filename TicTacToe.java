package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame {

	/**
	 * 
	 */
	JButton b[] = new JButton[9];
	int c = 1;
	private static final long serialVersionUID = 1L;
	
	public void set() {
		int i,j,k=0;
		int x = 0,y = 0,h = 100,w = 100;
		setLayout(null);
		for(i=1;i<=3;i++) {
			for(j=1;j<=3;j++) {
				b[k] = new JButton();
				b[k].setSize(w, h);
				b[k].setLocation(x, y);
				add(b[k]);
				b[k].setFont(new Font("Arial", Font.PLAIN, 25));
				b[k].addActionListener(new handler());
				k++;
				x = x + 100;
			}
			x = 0;
			y = y + 100;
		}
	}
	
	public static void main(String[] args) {
		TicTacToe t1 = new TicTacToe();
		t1.setVisible(true);
		t1.setSize(312,335);
		t1.set();
		t1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	class handler implements ActionListener{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			JButton b1 = (JButton)e.getSource();
			if(b1.getLabel().equals("")) {
				c++;
				if(c%2==0) {
					b1.setLabel("O");
				}
				else {
					b1.setLabel("X");
				}
				
				if(b[0].getLabel().equals("O") && b[1].getLabel().equals("O") && b[2].getLabel().equals("O")) {
					JOptionPane.showMessageDialog(b1, "Player O Wins!");
					afterWinning();
				}
				else if(b[3].getLabel().equals("O") && b[4].getLabel().equals("O") && b[5].getLabel().equals("O")) {
					JOptionPane.showMessageDialog(b1, "Player O Wins!");
					afterWinning();
				
				}
				else if(b[6].getLabel().equals("O") && b[7].getLabel().equals("O") && b[8].getLabel().equals("O")) {
					JOptionPane.showMessageDialog(b1, "Player O Wins!");
					afterWinning();
				}
				
				else if(b[0].getLabel().equals("O") && b[3].getLabel().equals("O") && b[6].getLabel().equals("O")) {
					JOptionPane.showMessageDialog(b1, "Player O Wins!");
					afterWinning();
					
				}
				else if(b[1].getLabel().equals("O") && b[4].getLabel().equals("O") && b[7].getLabel().equals("O")) {
					JOptionPane.showMessageDialog(b1, "Player O Wins!");
					afterWinning();
				}
				else if(b[2].getLabel().equals("O") && b[5].getLabel().equals("O") && b[8].getLabel().equals("O")) {
					JOptionPane.showMessageDialog(b1, "Player O Wins!");
					afterWinning();
				}
				
				else if(b[0].getLabel().equals("O") && b[4].getLabel().equals("O") && b[8].getLabel().equals("O")) {
					JOptionPane.showMessageDialog(b1, "Player O Wins!");
					afterWinning();
				}
				else if(b[2].getLabel().equals("O") && b[4].getLabel().equals("O") && b[6].getLabel().equals("O")) {
					JOptionPane.showMessageDialog(b1, "Player O Wins!");
					afterWinning();
				}
				
				// For Player X
				
				else if(b[0].getLabel().equals("X") && b[1].getLabel().equals("X") && b[2].getLabel().equals("X")) {
					JOptionPane.showMessageDialog(b1, "Player X Wins!");
					afterWinning();
				}
				else if(b[3].getLabel().equals("X") && b[4].getLabel().equals("X") && b[5].getLabel().equals("X")) {
					JOptionPane.showMessageDialog(b1, "Player X Wins!");
					afterWinning();
				}
				else if(b[6].getLabel().equals("X") && b[7].getLabel().equals("X") && b[8].getLabel().equals("X")) {
					JOptionPane.showMessageDialog(b1, "Player X Wins!");
					afterWinning();
				}
				
				else if(b[0].getLabel().equals("X") && b[3].getLabel().equals("X") && b[6].getLabel().equals("X")) {
					JOptionPane.showMessageDialog(b1, "Player X Wins!");
					afterWinning();
				}
				else if(b[1].getLabel().equals("X") && b[4].getLabel().equals("X") && b[7].getLabel().equals("X")) {
					JOptionPane.showMessageDialog(b1, "Player X Wins!");
					afterWinning();
				}
				else if(b[2].getLabel().equals("X") && b[5].getLabel().equals("X") && b[8].getLabel().equals("X")) {
					JOptionPane.showMessageDialog(b1, "Player X Wins!");
					afterWinning();
				}
				
				else if(b[0].getLabel().equals("X") && b[4].getLabel().equals("X") && b[8].getLabel().equals("X")) {
					JOptionPane.showMessageDialog(b1, "Player X Wins!");
					afterWinning();
				}
				else if(b[2].getLabel().equals("X") && b[4].getLabel().equals("X") && b[6].getLabel().equals("X")) {
					JOptionPane.showMessageDialog(b1, "Player X Wins!");
					afterWinning();
				}
				else if (!b[0].getLabel().equals("") && !b[1].getLabel().equals("") && !b[2].getLabel().equals("")
						&& !b[3].getLabel().equals("") && !b[4].getLabel().equals("") && !b[5].getLabel().equals("")
						&& !b[6].getLabel().equals("") && !b[7].getLabel().equals("") && !b[8].getLabel().equals("")) {
					JOptionPane.showMessageDialog(b1, "Match Tie!");
					afterWinning();
				}
				
			}
		}
		@SuppressWarnings("deprecation")
		public void afterWinning() {
			b[0].setLabel("");
			b[1].setLabel("");
			b[2].setLabel("");
			b[3].setLabel("");
			b[4].setLabel("");
			b[5].setLabel("");
			b[6].setLabel("");
			b[7].setLabel("");
			b[8].setLabel("");
		}
		
	}
}

