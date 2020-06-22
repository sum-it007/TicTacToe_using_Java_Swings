package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game obj = new Game();
    }
}

class Game extends JFrame implements ActionListener{

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,btn,score;
    JLabel winner;
    String firstPlayer=null,secondPlayer=null;
    int l=0,k=0,count=0;
    int player1score=0,player2score=0;
    Color Blue1 = new Color(5,123,129);
    Color Blue2 = new Color(150,203,187);

    public Game()
    {

        setTitle("Tic Tac Toe (X/0)");
        setSize(325,460);
        setLocation(520,150);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        b1 = new JButton("");
        b2 = new JButton("");
        b3 = new JButton("");
        b4 = new JButton("");
        b5 = new JButton("");
        b6 = new JButton("");
        b7 = new JButton("");
        b8 = new JButton("");
        b9 = new JButton("");
        btn = new JButton("Start New Game");
        score = new JButton("Score");
        winner = new JLabel();

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(btn);
        add(score);
        add(winner);

        b1.setBounds(10,10,90,90);
        b2.setBounds(110,10,90,90);
        b3.setBounds(210,10,90,90);
        b4.setBounds(10,110,90,90);
        b5.setBounds(110,110,90,90);
        b6.setBounds(210,110,90,90);
        b7.setBounds(10,210,90,90);
        b8.setBounds(110,210,90,90);
        b9.setBounds(210,210,90,90);
        btn.setBounds(75,310,160,30);
        score.setBounds(10,380,70,30);
        winner.setBounds(75,350,160,30);

        firstPlayer = JOptionPane.showInputDialog("Enter name of First Player :");
        if(firstPlayer==null)
            firstPlayer="Player 1";
        secondPlayer = JOptionPane.showInputDialog("Enter name of Second Player :");
        if(secondPlayer==null)
            secondPlayer="Player 2";
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        btn.addActionListener(this);
        score.addActionListener(this);
    }


    void setDisabled()
    {
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }

    public int check()
    {
        count++;
        if(b1.getText()=="X"&&b2.getText()=="X"&&b3.getText()=="X")
            return 1;
        else if(b4.getText()=="X"&&b5.getText()=="X"&&b6.getText()=="X")
            return 1;
        else if(b7.getText()=="X"&&b8.getText()=="X"&&b9.getText()=="X")
            return 1;
        else if(b1.getText()=="X"&&b5.getText()=="X"&&b9.getText()=="X")
            return 1;
        else if(b3.getText()=="X"&&b5.getText()=="X"&&b7.getText()=="X")
            return 1;
        else if(b1.getText()=="X"&&b4.getText()=="X"&&b7.getText()=="X")
            return 1;
        else if(b2.getText()=="X"&&b5.getText()=="X"&&b8.getText()=="X")
            return 1;
        else if(b3.getText()=="X"&&b6.getText()=="X"&&b9.getText()=="X")
            return 1;

        else if(b1.getText()=="0"&&b2.getText()=="0"&&b3.getText()=="0")
            return 2;
        else if(b4.getText()=="0"&&b5.getText()=="0"&&b6.getText()=="0")
            return 2;
        else if(b7.getText()=="0"&&b8.getText()=="0"&&b9.getText()=="0")
            return 2;
        else if(b1.getText()=="0"&&b5.getText()=="0"&&b9.getText()=="0")
            return 2;
        else if(b3.getText()=="0"&&b5.getText()=="0"&&b7.getText()=="0")
            return 2;
        else if(b1.getText()=="0"&&b4.getText()=="0"&&b7.getText()=="0")
            return 2;
        else if(b2.getText()=="0"&&b5.getText()=="0"&&b8.getText()=="0")
            return 2;
        else if(b3.getText()=="0"&&b6.getText()=="0"&&b9.getText()=="0")
            return 2;
        else {
            if(count==9)
                winner.setText("Game Draw");
            return 3;
        }
    }

    void subCheck()
    {
        l = check();
        if (l == 1) {
            winner.setText(firstPlayer+" Won");
            player1score++;
            setDisabled();
        } else if (l == 2)
        {
            winner.setText(secondPlayer+" Won");
            player2score++;
            setDisabled();
        }
        else ;
    }
    void setbtn(JButton Selected_btn)
    {
        if(k==0) {
            Selected_btn.setText("X");
            Selected_btn.setBackground(Blue1);
            k = 1;
            Selected_btn.setEnabled(false);
            subCheck();
        }else {
            Selected_btn.setText("0");
            Selected_btn.setBackground(Blue2);
            k=0;
            Selected_btn.setEnabled(false);
            subCheck();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn)
        {
            k=0;l=0;count=0;
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);

            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");

            b1.setBackground(null);
            b2.setBackground(null);
            b3.setBackground(null);
            b4.setBackground(null);
            b5.setBackground(null);
            b6.setBackground(null);
            b7.setBackground(null);
            b8.setBackground(null);
            b9.setBackground(null);
            winner.setText("");
        }
        if(e.getSource()==b1)
            setbtn(b1);
        else if(e.getSource()==b2)
            setbtn(b2);
        else if(e.getSource()==b3)
            setbtn(b3);
        else if(e.getSource()==b4)
            setbtn(b4);
        else if(e.getSource()==b5)
            setbtn(b5);
        else if(e.getSource()==b6)
            setbtn(b6);
        else if(e.getSource()==b7)
            setbtn(b7);
        else if(e.getSource()==b8)
            setbtn(b8);
        else if(e.getSource()==b9)
            setbtn(b9);
        else if(e.getSource()==score)
        {
            JFrame scoreWindow = new JFrame("Score");
            JOptionPane.showMessageDialog(scoreWindow,firstPlayer+" : "+player1score+"\n"+secondPlayer+" : "+player2score,"Score Board", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
