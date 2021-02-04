package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import LogicGames.Random;

public class JumbleWord extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel l1;
	JTextField t1;
	JButton b1,b2;
	JLabel l2;
	final String jumble[] = {"NIDIA","FLNANID","NZEWEAANLD","EMAIRAC","AJANP","UASAILATR","ANADCA","SARIU","LAPDNO","SKUTHOOARE"};
	final String actual[] = {"INDIA","FINLAND","NEWZEALAND","AMERICA","JAPAN","SOUTHKOREA","CANADA","RUSIA","AUSTRALIA","POLAND"};
	String act;
	int n;
	public JumbleWord(String s) {
		super(s);
	}
	public void set() {
		n = Random.randint(0, 4);
		l1 = new JLabel(jumble[n]);
		t1 = new JTextField();
		b1 = new JButton("Submit");
		b2 = new JButton("Reset");
		l2 = new JLabel();
		setLayout(null);
		add(l1);
		add(t1);
		add(b1);
		add(b2);
		add(l2);
		l1.setBounds(135, 37, 175, 25);
		t1.setBounds(100, 90, 175, 25);
		b1.setBounds(62, 160, 100, 25);
		b2.setBounds(205, 160, 100, 25);
		l2.setBounds(150, 230, 175, 21);
		l1.setFont(new Font("Arial",Font.BOLD, 18));
		l2.setFont(new Font("Arial",Font.BOLD, 18));
		t1.setFont(new Font("Arial",Font.PLAIN, 18));
		b1.setFont(new Font("Arial",Font.BOLD, 15));
		b2.setFont(new Font("Arial",Font.BOLD, 15));
		b1.addActionListener(new select1());
		b2.addActionListener(new select2());
	}
	class select1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int c=0;
			String name = t1.getText().toUpperCase();
			for(String i:actual) {
				if(name.equals(i)) {
					l2.setText("Correct!");
					t1.setText("");
					n = Random.randint(0, 9);
					l1.setText(jumble[n]);
					c=1;
				}
			}
			if(c==0) {
				l2.setText("Incorrect!");
				t1.setText("");
				n = Random.randint(0, 4);
				l1.setText(jumble[n]);
			}
		}
	}
	class select2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			t1.setText("");
			n = Random.randint(0, 9);
			l1.setText(jumble[n]);
		}
	}
	public static void main(String[] args) {
		JumbleWord frame = new JumbleWord("Jumble Word Game");
		frame.setSize(380, 320);
		frame.set();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
