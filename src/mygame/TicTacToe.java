package mygame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToe {
	boolean player1_turn;
	boolean player2_turn;
	
	JButton[] buttons= new JButton[9];
	
	TicTacToe()
	{
		JFrame f= new JFrame("Tic Tac Toe");
		f.setSize(600, 600);
		BorderLayout b= new BorderLayout();
		f.setLayout(b);
		
		JPanel p= new JPanel();
		Dimension d= new Dimension(400, 400);
		p.setPreferredSize(d);
		p.setBackground(Color.black);
		GridLayout g= new GridLayout(3,3,5,5);
		p.setLayout(g);
		
		
		String X= "X";
		String O= "O";
		
		turn();
		
		int i;
		for( i=0; i< buttons.length; i++)
		{
			buttons[i]= new JButton("");
			Font font= new Font("Times New Roman", Font.BOLD, 30);
			buttons[i].setFont(font);
			p.add(buttons[i]);
			final int setButton= i;
			ActionListener al= new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
				 JButton b = (JButton) e.getSource();
                    if (b.getText().equals("") && player1_turn) 
                    {
                        buttons[setButton].setText(X); 
                        player1_turn = false;
                        player2_turn = true;
                    }
                    else if(b.getText().equals("") && player2_turn)
                    {
                    	 buttons[setButton].setText(O); 
                    	 player1_turn = true;
                         player2_turn = false;
                    }
				}
			};
			buttons[i].addActionListener(al);
		}
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.setVisible(true);
		
	}
	
	public void check()
	{
		if (buttons[0].getText().equals("X") &&
		    buttons[1].getText().equals("X") &&
		    buttons[2].getText().equals("X"))
		{
		    System.out.println("X wins");
		}
		else
		{
			System.out.println("O wins");
		}
	}
	
	void turn()
	{
		Random rand= new Random();
		int turn= rand.nextInt(2);
		player1_turn= (turn==0);
		player2_turn= !player1_turn;
	}
	
	
	public static void main(String[] ar)
	{
		TicTacToe t= new TicTacToe();
		t.check();
	}

}
