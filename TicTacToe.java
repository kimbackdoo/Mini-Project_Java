package ex;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe extends JFrame implements ActionListener{
	private JPanel panel = new JPanel();
	private JButton[][] buttons = new JButton[3][3];
	private String turn = "X";
	private String[][] labels = { {"", "", ""},
									{"", "", ""},
									{"", "", ""}};
	private int cnt = 0;
	
	public TicTacToe() {
		setSize(400, 400);
		setTitle("Tic Tac Toe");
		panel.setLayout(new GridLayout(0, 3, 3, 3));
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				buttons[i][j] = new JButton(labels[i][j]);
				buttons[i][j].setFont(new Font(null, Font.ITALIC, 100));
				buttons[i][j].addActionListener(this);
				panel.add(buttons[i][j]);
			}
		}
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(e.getSource() == buttons[i][j] && buttons[i][j].getText().equals("")) {
					cnt++;
					if(turn == "X") {
						buttons[i][j].setText("X");
						turn = "O";
					}
					else {
						buttons[i][j].setText("O");
						turn = "X";
					}
				}
			}
		}
		check();
	}
	
	private void check() {
		boolean chk = false;
		
		for(int i=0; i<3; i++) {
			if((buttons[i][0].getText().equals(buttons[i][1].getText())) &&
					(buttons[i][1].getText().equals(buttons[i][2].getText())) &&
					(buttons[i][0].getText().equals("X") || buttons[i][0].getText().equals("O"))) chk = true;
			else if((buttons[0][i].getText().equals(buttons[1][i].getText())) &&
					(buttons[1][i].getText().equals(buttons[2][i].getText())) &&
					(buttons[0][i].getText().equals("X") || buttons[0][i].getText().equals("O"))) chk = true;
		}
		
		if((buttons[0][0].getText().equals(buttons[1][1].getText())) &&
			(buttons[1][1].getText().equals(buttons[2][2].getText())) &&
			(buttons[0][0].getText().equals("X") || buttons[0][0].getText().equals("O"))) chk = true;
		else if((buttons[0][2].getText().equals(buttons[1][1].getText())) &&
				(buttons[1][1].getText().equals(buttons[2][0].getText())) &&
				(buttons[0][2].getText().equals("X") || buttons[0][2].getText().equals("O"))) chk = true;
		
		if(chk) {
			if(turn.equals("X"))
				JOptionPane.showMessageDialog(null, "O가 이겼습니다.");
			else
				JOptionPane.showMessageDialog(null, "X가 이겼습니다.");
			cnt = 0;
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++)
					buttons[i][j].setText("");
		}
		else if(cnt == 9) {
			JOptionPane.showMessageDialog(null, "비겼습니다.");
			cnt = 0;
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++)
					buttons[i][j].setText("");
		}
	}
	
	public static void main(String[] args) {
		new TicTacToe();
    }
}