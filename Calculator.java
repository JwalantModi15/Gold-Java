package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator extends JFrame{

	/**
	 * 
	 */
//	String s1 = "";
	JTextField t1;
	JButton arr[] = new JButton[20];
	String arr1[] = {"<","C","1/x","sqrt","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("deprecation")
	public void set() {
		setLayout(null);
		t1 = new JTextField();
		t1.setSize(400, 80);
		t1.setLocation(0, 1);
		add(t1);
		t1.setFont(new Font("Arial", Font.PLAIN, 32));
		t1.setHorizontalAlignment(t1.RIGHT);
		int i,j,k=0;
		int x=0,y=80,h=80,w=100;
		for(i=1;i<=5;i++) {
			for(j=1;j<=4;j++) {
				arr[k] = new JButton();
				arr[k].setSize(w, h);
				arr[k].setLocation(x, y);
				add(arr[k]);
				arr[k].setLabel(arr1[k]);
				arr[k].setFont(new Font("Arial", Font.PLAIN, 25));
				arr[k].addActionListener(new handler());
				k++;
				x = x + 100;
			}
			x = 0;
			y = y + 80;
		}
	}
	class handler implements ActionListener{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			try {
				if(e.getSource() == arr[0]) {
					String str = t1.getText();
					t1.setText(str.substring(0,str.length()-1));
				}
				else if(e.getSource() == arr[1]) {
					t1.setText("");
				}
				else if(e.getSource() == arr[2]) {
					double x = Double.parseDouble(t1.getText());
					t1.setText(""+(1/x));
				}
				else if(e.getSource() == arr[3]) {
					double sq = Double.parseDouble(t1.getText());
					t1.setText(""+Math.sqrt(sq));
				}
				else if(e.getSource() == arr[18]) {
					String n1 = t1.getText();
					ScriptEngineManager sem = new ScriptEngineManager();
					ScriptEngine se = sem.getEngineByName("Nashorn");
					try {
						t1.setText(""+se.eval(n1));
					} catch (ScriptException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JButton b1 = (JButton)e.getSource();
					String s1 = t1.getText() + b1.getLabel();
					t1.setText(s1);
				}
			}catch(Exception e1) {
				
			}
		}
	}
	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		c1.setVisible(true);
		c1.setSize(412, 517);
		c1.set();
		c1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
