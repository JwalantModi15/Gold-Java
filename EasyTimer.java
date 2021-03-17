package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EasyTimer extends JFrame {

	/**
	 * 
	 */
	JLabel l1, l2;
	JTextField t1;
	JButton b1;
	int t,c=0;
	private static final long serialVersionUID = 1L;

	public EasyTimer(String s) {
		super(s);
	}
	public void set() {
		l1 = new JLabel("Enter Seconds: ");
		l1.setFont(new Font("Arial", Font.BOLD, 19));
		t1 = new JTextField();
		t1.setFont(new Font("Arial", Font.BOLD, 15));
		l2 = new JLabel();
		l2.setFont(new Font("Arial", Font.BOLD, 35));
		b1 = new JButton("Start");
		setLayout(null);
		add(l1);
		add(t1);
		add(b1);
		add(l2);
		l1.setBounds(25, 50, 210, 50);
		t1.setBounds(170, 64, 155, 25);
		b1.setBounds(128, 145, 100, 25);
		l2.setBounds(155, 210, 155, 50);
		b1.addActionListener(new handler());
	}
	class handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			t = Integer.parseInt(t1.getText());
			Timer timer = new Timer();
			if(c==0) {
				timer.schedule(new TimerTask() {
					public void run() {
					if(t>0) {
						l2.setText(String.valueOf(t));
						t = t - 1;
						c=1;
					}
					else {
						l2.setText("Stop");
						c=0;
						}
					}
				}, 0, 1000);
			}
		}
	}
	public static void main(String[] args) {
		EasyTimer t = new EasyTimer("Timer");
		t.setVisible(true);
		t.setSize(370, 320);
		t.set();
		t.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
