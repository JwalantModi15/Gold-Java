package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MiniCalculator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel l1,l2,l3,l4;
	public JTextField t1,t2,t3;
	public JButton b1;

	public MiniCalculator(String s) {
		super(s);
	}
	public void set() {
		l1 = new JLabel("Enter First Number: ");
		l2 = new JLabel("Enter Symbol: ");
		l3 = new JLabel("Enter Second Number: ");
		b1 = new JButton("Answer");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		l4 = new JLabel();
		setLayout(null);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(b1);
		add(t1);
		add(t2);
		add(t3);
		l1.setBounds(30, 50, 150, 21);
		t1.setBounds(180, 50, 150, 23);
		
		l2.setBounds(30, 100, 150, 21);
		t2.setBounds(180, 100, 150, 23);
		
		l3.setBounds(30, 150, 150, 21);
		t3.setBounds(180, 150, 150, 23);
		
		b1.setBounds(135, 205, 100, 21);
		
		l4.setBounds(130, 235,205, 21);
		l1.setFont(new Font("Arial",Font.BOLD, 15));
		l2.setFont(new Font("Arial",Font.BOLD, 15));
		l3.setFont(new Font("Arial",Font.BOLD, 15));
		l4.setFont(new Font("Arial",Font.BOLD, 15));
		t1.setFont(new Font("Arial",Font.PLAIN, 15));
		t2.setFont(new Font("Arial",Font.PLAIN, 15));
		t3.setFont(new Font("Arial",Font.PLAIN, 15));
		b1.setFont(new Font("Arial",Font.BOLD, 15));
		
		b1.addActionListener(new handler());
	}
	public static void main(String[] args) {
		MiniCalculator frame = new MiniCalculator("Calculator");
		frame.setVisible(true);
		frame.setSize(370, 320);
		frame.set();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	class handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			double n1 = Double.parseDouble(t1.getText());
			double n = 0;
			int c = 0;
			String s = t2.getText();
			double n3 = Double.parseDouble(t3.getText());
			switch(s) {
			case "+":
				n = n1+n3;
				break;
			case "-":
				n = n1-n3;
				break;
			case "*":
				n = n1*n3;
				break;
			case "/":
				n = n1/n3;
				break;
			case "%":
				n = (n1/n3)*100.0;
				break;
			default:
				c = 1;
				break;
			}
			if(c==0) {
				l4.setText("Result is: "+n);
			}
			else {
				l4.setText("Invalid Input");
			}
		}
	}

}

