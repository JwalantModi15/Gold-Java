package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class GUITimer extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2;
	JTextField t1;
	JButton b1,b2;
	int n;
	Timer t;
	String s = "stop";
	private void set() {
		l1 = new JLabel("Enter in Sec: ");
		l2 = new JLabel();
		t1 = new JTextField();
		b1 = new JButton("Start");
		b2 = new JButton("Reset");
		add(l1);
		add(l2);
		add(t1);
		add(b1);
		add(b2);
		setLayout(null);
		l1.setBounds(30, 50, 150, 23);
		l1.setFont(new Font("Arial",Font.BOLD, 18));
		t1.setBounds(150, 50, 180, 23);
		t1.setFont(new Font("Arial",Font.PLAIN, 18));
		b1.setBounds(73, 120, 80, 23);
		b1.setFont(new Font("Arial",Font.BOLD, 15));
		b2.setBounds(201, 120, 80, 23);
		b2.setFont(new Font("Arial",Font.BOLD, 15));
		l2.setBounds(158, 180, 205, 32);
		l2.setFont(new Font("Arial",Font.BOLD, 28));
		b1.addActionListener(new handler1());
		b2.addActionListener(new handler3());
	}
	public static void main(String[] args) {
		GUITimer frame = new GUITimer();
		frame.setVisible(true);
		frame.setSize(370, 280);
		frame.set();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	class handler1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			t = new Timer();
			n = Integer.parseInt(t1.getText());
			if(s.equals("stop")) {
				t.schedule(new TimerTask() {
					public void run() {
						if(n>-1) {
							l2.setText(Integer.toString(n));
							n--;
							s = "";
							b1.setEnabled(false);
						}
						else {
							l2.setText("Stop");
							t1.setText("");
							t.cancel();
							s = "stop";
							b1.setEnabled(true);
						}
						
					}
				},0, 1000);
			}
		}
		
	}
	class handler3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			b1.setEnabled(true);
			l2.setText("");
			t1.setText("");
			t.cancel();
			s = "stop";
		}
	}

}

