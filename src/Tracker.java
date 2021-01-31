/*****************************************************************
 *
 *                 Copyright 2021 Timothy Bollman
 *                       github.com/tbollman
 *
 *****************************************************************/

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tracker{
    public static AccountManager am = new AccountManager();
    public static JLabel label = new JLabel();
    public static MyFrame frame = new MyFrame();
    public static Border border = BorderFactory.createLineBorder(Color.black,1);
    public static Color clear = new Color(0,0,0,0);
    public static Color liner = new Color(135,109,105);
    public static JButton[] menuButtons = new JButton[5];

    public static void firstTime() {
        JFrame newFrame = new JFrame("Create Account");
        newFrame.setResizable(false);
        newFrame.setBounds(150,200,300,200);
        JLabel newLabel = new JLabel("Please create a master password");
        newLabel.setBounds(50,50,200,30);
        newLabel.setHorizontalAlignment(JLabel.CENTER);
        newLabel.setVerticalAlignment(JLabel.TOP);
        JTextField newField = new JTextField();
        newField.setBounds(75,60,150,30);
        newField.setHorizontalAlignment(JTextField.CENTER);
        newField.setBackground(Color.gray);
        newField.setOpaque(true);
        JButton newButton = new JButton("Create");
        newButton.setBounds(100,140,100,20);
        //newButton.setBackground(clear);
        newButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            am.accounts.add(new Account("this",newField.getText()));
                                            newFrame.setVisible(false);
                                            am.writeAccounts();
                                            frame.setVisible(true);
                                            return;
                                        }
                                    });
        newFrame.add(newButton);
        newFrame.add(newField);
        newFrame.add(newLabel);
        newFrame.setVisible(true);
    }

    public static void menu() {
        JButton button1 = new JButton("Add Account");
        button1.setBounds(60,50,455,80);
        button1.setBackground(liner);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        JButton button2 = new JButton("Get Password");
        button2.setBounds(60,137,455,80);
        button2.setBackground(liner);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        JButton button3 = new JButton("Update Account");
        button3.setBounds(60,230,455,80);
        button3.setBackground(liner);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        JButton button4 = new JButton("Remove Account");
        button4.setBounds(60,330,455,80);
        button4.setBackground(liner);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        JButton button5 = new JButton("Exit");
        button5.setBounds(60,430,455,80);
        button5.setBackground(liner);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
    }

    public static void main(String[] args) {
        if(am.checkFirstTime()) {
            frame.setVisible(false);
            firstTime();
        }
        ImageIcon vault = new ImageIcon("logo.png");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(Color.gray);
        passwordField.setBounds(150,350,300,50);
        label.setBounds(0,0,600,600);
        label.setIcon(vault);
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label);

        JButton submitButton = new JButton("Open");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(passwordField.getText().isEmpty()) {
                //if(passwordField.getText().equals(am.accounts.get(0).getPassword())) {
                    System.out.println("Changed!");
                    ImageIcon vault = new ImageIcon("logo2.png");
                    frame.remove(submitButton);
                    frame.remove(passwordField);
                    label.setIcon(vault);
                    am.readAccounts();
                    menu();
                }
                else {
                    System.exit(0);
                }
            }
        });
        label.updateUI();
        submitButton.setBounds(260 ,435,80,30);
        submitButton.setBackground(clear);
        submitButton.updateUI();
        submitButton.setVerticalAlignment(JButton.BOTTOM);
        frame.add(passwordField);
        frame.add(submitButton);

    }
}
