package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;

import ClassesAndObjects.Random;
import ClassesAndObjects.Shuffle;

public class MatchMaker extends JFrame{

	/**
	 * 
	 */
	String arr[] = {"A", "B", "C", "D", "E","1", "@", "3", "4","5", "$",
            "#","A", "B", "C", "D", "E","1", "@", "3", "4","5", "$",
            "#"}; 
	JButton bArr[] = new JButton[24];
	JButton b1,b2;
	ArrayList <Integer> array = new ArrayList<Integer>();
	int k1=0,c=0,a=0;
	public void set() {
		int i,j,k=0;
		int x = 0, y = 0, w = 100, h = 100,n;
		setLayout(null);
		for(i=1;i<=6;i++) {
			for(j=1;j<=4;j++) {
				bArr[k] = new JButton();
				bArr[k].setSize(w,h);
				bArr[k].setLocation(x,y);
				add(bArr[k]);
				bArr[k].setFont(new Font("Arial", Font.PLAIN, 30));
				bArr[k].addActionListener(new handler(k));
				k++;
				x = x + 100;
			}
			x = 0;
			y = y + 100;
		}
		arr = shuffle(arr);
		for(String i1:arr) {
			System.out.println(i1);
		}
	}
	public String [] shuffle(String arr1[]) {
		String arr3[] = new String[arr1.length];
		int n;
		for(int i=0;i<arr1.length;i++) {
			n = Random.randint(0, arr1.length-1);
			while(array.contains(n)) {
				n = Random.randint(0, arr1.length-1);
			}
			arr3[n] = arr1[i];
			array.add(n);
		}
		array.clear();
		return arr3;
	}
	public MatchMaker(String s){
		super(s);
	}
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		MatchMaker m1 = new MatchMaker("Match Maker Game");
		m1.setVisible(true);
		m1.setSize(415,639);
		m1.set();
		m1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	class handler implements ActionListener{
		
		private int x;
		public handler(int a) {
			x = a;
		}
		public void actionPerformed(ActionEvent e) {
			b1 = (JButton)e.getSource();
			String str = arr[x];
			if(b1.getText().equals("")) {
				b1.setText(str);
				if(c==0) {
					b2 = b1;
					c=1;
				}else {
					if(b1.getText().equals(b2.getText())) {
						b1=null;
						b2=null;
						a++;
					}
					else {
						b1.setText("");
						b2.setText("");
						
					}
					c=0;
					if(a==12) {
						a=0;
						reset();
					}
				}
			}		
		}
		public void reset() {
			int i,j,k=0;
			for(i=1;i<=6;i++) {
				for(j=1;j<=4;j++) {
					bArr[k].setText("");
					k++;
				}
			}
			arr = shuffle(arr);
		}
		
		
	}

}
