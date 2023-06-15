package mygame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener{
	boolean player1_turn;
	boolean player2_turn;
	String X= "X";
	String O= "O";
	
	JButton[] buttons= new JButton[9];
	
	JFrame frame;
	Font font;
	JPanel p1;
	JPanel p2;
	JButton b;
	JLabel l;
	
	
	TicTacToe()
	{
		frame= new JFrame("TIC TAC TOE");
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout layout= new GridLayout(3,3, 10, 10);
		p1= new JPanel();
		p1.setBounds(80, 80, 400, 400);
		p1.setBackground(Color.black);
		p1.setLayout(layout);
		
		p2= new JPanel();
		p2.setBounds(80, 10, 400, 60);
		p2.setBackground(Color.black);
		
		
		Container c= frame.getContentPane();
		c.setLayout(null);
		c.add(p1);
		c.add(p2);
		
		font= new Font("Consolas", Font.BOLD, 40);
		for(int i=0; i< buttons.length; i++)
		{
			buttons[i]= new JButton();
			buttons[i].setFont(font);
			buttons[i].setText("");
			p1.add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		
		l= new JLabel();
		l.setForeground(new Color(100, 240, 230));
		l.setBounds(0, 0, 100, 50);
		l.setFont(font);
		
		font= new Font("Consolas", Font.BOLD, 20);
		b= new JButton("Reset");
		b.setBounds(230, 490, 100, 60);
		b.setFocusable(false);
		b.setFont(font);
		b.addActionListener(this);
		c.add(b);
		p2.add(l);
		
		frame.add(p2);
		frame.add(p1);
		
		font = new Font("Consolas", Font.BOLD, 40);
		
		firstturn();
	}
	
	void firstturn()
	{
		Random rand= new Random();
		int turn= rand.nextInt(2);
		if(turn==0)
		{
			player1_turn= true;
			player2_turn= false;
			l.setText("Player 1 turn");
		}
		else
		{
			player1_turn= false;
			player2_turn= true;
			l.setText("Player 2 turn");
		}
	}
	
	
	
	int i;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(i=0; i< buttons.length; i++)
		{
			if(e.getSource() == b)
			{
				buttons[i].setEnabled(true);
				buttons[i].setText("");
				
			}
			
			if (e.getSource()== buttons[i] && player1_turn) 
	        {
	            buttons[i].setText(X); 
	            player1_turn = false;
	            player2_turn = true;
	            l.setFont(font);
	            l.setText("Player 2 turn");
	        }
			 else if(e.getSource()== buttons[i] && player2_turn)
	        {
	        	 buttons[i].setText(O); 
	        	 player1_turn = true;
	             player2_turn = false;
	             l.setFont(font);
	             l.setText("Player 1 turn");
	        }
		}
		checkWinner();
	}
	
	public void checkWinner() 
	{
		// x wins
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) 
		{
			xWins(0,1,2);
		}
		if((buttons[3].getText()=="X") && (buttons[4].getText()== "X")&& (buttons[5].getText()== "X"))
		{
			xWins(3,4,5);
		}
		if((buttons[6].getText()== "X") && (buttons[7].getText()== "X") && (buttons[8].getText()=="X"))
		{
			xWins(6,7,8);
		}
		
		if((buttons[0].getText()== "X") && (buttons[3].getText()== "X") && (buttons[6].getText()=="X" ))
		{
			xWins(0,1,6);
		}
		if((buttons[1].getText()== "X") && (buttons[4].getText()== "X") && (buttons[7].getText()== "X"))
		{
			xWins(1,4,7);
		}
		if((buttons[2].getText()== "X") && (buttons[5].getText()== "X") && (buttons[8].getText()== "X"))
		{
			xWins(2,5,8);
		}
		if((buttons[0].getText()== "X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X"))
		{
			xWins(0,4,8);
		}
		if((buttons[2].getText()== "X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
		{
			xWins(2,4,6);
		}
		
		// o wins
		if((buttons[0].getText()== "O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O"))
		{
			oWins(0,1,2);
		}
		if((buttons[3].getText()== "O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O"))
		{
			oWins(3,4,5);
		}
		if((buttons[6].getText()== "O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O"))
		{
			oWins(6,7,8);
		}
		if((buttons[0].getText()== "O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O"))
		{
			oWins(0,3,6);
		}
		if((buttons[1].getText()== "O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
		{
			oWins(1,4,7);
		}
		if((buttons[2].getText()== "O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O"))
		{
			oWins(2,5,8);
		}
		if((buttons[0].getText()== "O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O"))
		{
			oWins(0,4,8);
		}
		if((buttons[2].getText()== "O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O"))
		{
			oWins(2,4,6);
		}
		
		
		boolean fullBoard= true;
		for(JButton button: buttons)
		{
			if(button.getText().isEmpty())
			{
				fullBoard= false;
				break;
			}
		}
		if(fullBoard)
		{
			JOptionPane.showMessageDialog(p1,"Its a tie");
			disableButtons();
		}
    }

	public void xWins(int a,int b,int c) 
	{
		for(int i=0;i<9;i++) 
		{
			buttons[i].setEnabled(false);
		}
		JOptionPane.showMessageDialog(p1, "Player X wins");
	}
	void disableButtons()
	{
		for(JButton button: buttons)
		{
			button.setEnabled(false);
		}
	}
	
	public void oWins(int a, int b, int c)
	{
		for(int i=0; i<9; i++)
		{
			buttons[i].setEnabled(false);
		}
		JOptionPane.showMessageDialog(p1, "Player O wins");
	}
	public static void main(String[] args)
	{
		new TicTacToe();
	}
}
