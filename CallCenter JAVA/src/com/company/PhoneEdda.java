package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PhoneEdda extends JFrame {
    private JPanel mainPanel, idPanel, sudPanel;
    private JScrollBar scrollBar;
    private JTextArea phoneScreen;
    private JButton callButton, deleteButton, closedButton, num1Button, num2Button, num3Button, num4Button,
            num5Button, num6Button, num7Button, num8Button, num9Button, num0Button, asteriskButton, hashtagButton;

    public PhoneEdda() {

        initComponents();
    }

    private void initComponents() {
        mainPanel = new JPanel(new BorderLayout());
        idPanel = new JPanel(new BorderLayout());
        sudPanel = new JPanel(new GridLayout(5,3));

        phoneScreen = new JTextArea();
        scrollBar = new JScrollBar();

        callButton = new JButton("CALL");
        deleteButton = new JButton("C");
        closedButton = new JButton("CLOSED");
        num1Button = new JButton("1");
        num2Button = new JButton("2");
        num3Button = new JButton("3");
        num4Button = new JButton("4");
        num5Button = new JButton("5");
        num6Button = new JButton("6");
        num7Button = new JButton("7");
        num8Button = new JButton("8");
        num9Button = new JButton("9");
        num0Button = new JButton("0");
        asteriskButton = new JButton("*");
        hashtagButton = new JButton("#");


        idPanel.add(phoneScreen, BorderLayout.CENTER);
        //phoneScreen.setAutoscrolls(true);
        scrollBar.setSize(10, 10);
        idPanel.add(scrollBar, BorderLayout.EAST);


        //idPanel.add(scrollBar, BorderLayout.EAST);


        mainPanel.add(idPanel);


        sudPanel.add(callButton);
        sudPanel.add(deleteButton);
        sudPanel.add(closedButton);
        sudPanel.add(num1Button);
        sudPanel.add(num2Button);
        sudPanel.add(num3Button);
        sudPanel.add(num4Button);
        sudPanel.add(num5Button);
        sudPanel.add(num6Button);
        sudPanel.add(num7Button);
        sudPanel.add(num8Button);
        sudPanel.add(num9Button);
        sudPanel.add(num0Button);
        sudPanel.add(asteriskButton);
        sudPanel.add(hashtagButton);

        mainPanel.add(sudPanel, BorderLayout.SOUTH);

            this.add(mainPanel);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            pack();

            num1Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("1");
                }
            });
            num2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("2");
                }
            });
            num3Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("3");
                }
            });num4Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("4");
                }
            });num5Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("5");
                }
            });num6Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("6");
                }
            });num7Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("7");
                }
            });num8Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("8");
                }
            });num9Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("9");
                }
            });num0Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("0");
                }
            });hashtagButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("#");
                }
            });asteriskButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.append("*");
                }
            });
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.replaceRange("", phoneScreen.getText().length()-1, phoneScreen.getText().length());
                }
            });

            callButton.addActionListener(new ActionListener()  {
                @Override
                public void actionPerformed(ActionEvent e)  {
                    scrollBar.repaint();
                    scrollBar.revalidate();
                    BufferedReader br = null;
                    FileReader fl = null;

                    if ("1234".equals(phoneScreen.getText())) {
                        phoneScreen.replaceRange("", 0, phoneScreen.getText().length());
                        phoneScreen.append("Calling...\n");

                        try{

                            phoneScreen.append(ReadFile.lettura());


                        }
                        catch(IOException ie){
                            System.out.println("ERRORE LETTURA");
                        }
                    }
                    else{
                        phoneScreen.replaceRange("", 0, phoneScreen.getText().length());
                        phoneScreen.append("Number no-existent");
                    }

                }
            });

            closedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    phoneScreen.replaceRange("", 0, phoneScreen.getText().length());
                }
            });
        }
        /**metto il get del Jpanel "mainPanel" per cambiare le dimensioni e la posizione dell'interfaccia
        * (il cambiamento verrà fatto nel mainEdda con il metodo setBounds() */

        public JPanel getMainPanelEdda() {
        return mainPanel;
        }
    }


