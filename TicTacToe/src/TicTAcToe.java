import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTAcToe implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel tittle_pannel = new JPanel();
	JPanel button_pannel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;

	TicTAcToe() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		textfield.setBackground(new Color(199,199,199));
		textfield.setForeground(Color.WHITE);
		textfield.setFont(new Font("Courier", Font.BOLD, 50));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic Tac Toe Game");
		textfield.setOpaque(true);

		tittle_pannel.setLayout(new BorderLayout());
		tittle_pannel.setBounds(0, 0, 500, 50);

		button_pannel.setLayout(new GridLayout(3, 3));
		button_pannel.setBackground(new Color(150, 150, 150));

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			button_pannel.add(buttons[i]);
			buttons[i].setFont(new Font("Courier", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);

		}

		tittle_pannel.add(textfield);
		frame.add(tittle_pannel, BorderLayout.NORTH);
		frame.add(button_pannel);

		firstTurn();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (player1_turn) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(Color.BLUE);
						buttons[i].setText("X");
						player1_turn = false;
						textfield.setText("O Turn");
						check();
					}
				} else {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(Color.RED);
						buttons[i].setText("O");
						player1_turn = true;
						textfield.setText("X Turn");
						check();
					}
				}
			}
		}

	}

	public void firstTurn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (random.nextInt(2) == 0) {
			player1_turn = true;
			textfield.setText("X Turn");
		} else {
			player1_turn = false;
			textfield.setText("O Turn");

		}

	}

	public void check() {
		
		if (
				(buttons[0].getText() == "X") && 
				(buttons[1].getText() == "X") && 
				(buttons[2].getText() == "X")) {
			xWins(0, 1, 2);

		}
		if (
				(buttons[3].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[5].getText() == "X")) {
			xWins(3, 4, 5);
		}
		if (
				(buttons[6].getText() == "X") && 
				(buttons[7].getText() == "X") && 
				(buttons[8].getText() == "X")) {
			xWins(6, 7, 8);
		}
		if (
				(buttons[0].getText() == "X") && 
				(buttons[3].getText() == "X") && 
				(buttons[6].getText() == "X")) {
			xWins(0, 3, 6);
		}
		if (
				(buttons[1].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[7].getText() == "X")) {
			xWins(1, 4, 7);
		}
		if (
				(buttons[2].getText() == "X") && 
				(buttons[5].getText() == "X") && 
				(buttons[8].getText() == "X")) {
			xWins(2, 5, 8);
		}
		if (
				(buttons[0].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[8].getText() == "X")) {
			xWins(0, 4, 8);
		}
		if (
				(buttons[2].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[6].getText() == "X")) {
			xWins(2, 4, 6);
		}
		
		
		
		if (
				(buttons[0].getText() == "O") && 
				(buttons[1].getText() == "O") && 
				(buttons[2].getText() == "O")) {
			oWins(0, 1, 2);

		}
		if (
				(buttons[3].getText() == "O") && 
				(buttons[4].getText() == "O") && 
				(buttons[5].getText() == "O")) {
			oWins(3, 4, 5);
		}
		if (
				(buttons[6].getText() == "O") && 
				(buttons[7].getText() == "O") && 
				(buttons[8].getText() == "O")) {
			oWins(6, 7, 8);
		}
		if (
				(buttons[0].getText() == "O") && 
				(buttons[3].getText() == "O") && 
				(buttons[6].getText() == "O")) {
			oWins(0, 3, 6);
		}
		if (
				(buttons[1].getText() == "O") && 
				(buttons[4].getText() == "O") && 
				(buttons[7].getText() == "O")) {
			oWins(1, 4, 7);
		}
		if (
				(buttons[2].getText() == "O") && 
				(buttons[5].getText() == "O") && 
				(buttons[8].getText() == "O")) {
			oWins(2, 5, 8);
		}
		if (
				(buttons[0].getText() == "O") && 
				(buttons[4].getText() == "O") && 
				(buttons[8].getText() == "O")) {
			oWins(0, 4, 8);
		}
		if (
				(buttons[2].getText() == "O") && 
				(buttons[4].getText() == "O") && 
				(buttons[6].getText() == "O")) {
			oWins(2, 4, 6);
		}

	}

	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X Wins");

	}

	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O Wins");

	}
	

}
