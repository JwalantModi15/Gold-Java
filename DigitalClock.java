package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Date;
public class DigitalClock extends JFrame{

	/**
	 * 
	 */
	JLabel l1;
	private static final long serialVersionUID = 1L;
	
	public DigitalClock(String s) {
		super(s);
	}
	@SuppressWarnings("deprecation")
	public void set() throws InterruptedException {
		l1 = new JLabel();
		add(l1);
		setLayout(null);
		l1.setBounds(88, 100, 250, 50);
		l1.setFont(new Font("Arial", Font.BOLD, 35));
		l1.setForeground(Color.black);
		l1.setBackground(Color.white);
		Date d1 = new Date();
		l1.setText(d1.getHours()+" : "+d1.getMinutes()+" : "+d1.getSeconds());
		int i=0,n=1;
		while(i<n+1) {
			Thread.sleep(1000);
			l1.setText("");
			set();
			i++;n++;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		DigitalClock clock = new DigitalClock("Digital Clock");
		clock.setVisible(true);
		clock.setSize(370, 300);
		clock.set();
		clock.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	class handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}

}
