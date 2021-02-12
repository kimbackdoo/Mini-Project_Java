package ex;

import java.util.*;
import java.awt.*;
import javax.swing.*;

class DigitalClock extends JFrame {
	private JLabel label;
	
	public DigitalClock() {
		setSize(500, 150);
		setTitle("Digital Clock");
		setLayout(new FlowLayout());
		
		label = new JLabel();
		label.setFont(new Font("고딕", Font.BOLD, 50));
		Thread t = new Thread(new clockThread(label));
		t.start();
		
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class clockThread implements Runnable {
	private JLabel label;
	
	public clockThread(JLabel label) {
		this.label = label;
	}
	
	@Override
	public void run() {
		while(true) {
			Calendar now = Calendar.getInstance();
			int hrs = now.get(Calendar.HOUR_OF_DAY);
			int min = now.get(Calendar.MINUTE);
			int sec = now.get(Calendar.SECOND);
			String time = hrs + ":" + min + ":" + sec;
			label.setText(time);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class DigitalClock_Test {
	public static void main (String[] args) {
		new DigitalClock();
	}
}