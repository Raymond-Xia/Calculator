/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
        
/**
 *
 * @author Raymond
 */
public class Calculator {
    JFrame frame;
    JPanel contentPane;
    JButton equals;
    JButton decimal;
    JButton cancel;
    JButton divide;
    JButton multiply;
    JButton subtract;
    JButton add;
    JButton one;
    JButton two;
    JButton three;
    JButton four;
    JButton five;
    JButton six;
    JButton seven;
    JButton eight;
    JButton nine;
    JButton zero;
    JLabel display;
    
    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        GridBagConstraints c = new GridBagConstraints();
        
        display = new JLabel("0");
        display.setHorizontalAlignment(JLabel.RIGHT);
        display.setOpaque(true);
        display.setBackground(Color.white);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(display, c);
        
        seven = new JButton("7");
        seven.addActionListener(new NumberListener());
        seven.setActionCommand("7");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        contentPane.add(seven, c);     
        
        eight = new JButton("8");
        eight.addActionListener(new NumberListener());
        eight.setActionCommand("8");
        c.gridx = 1;
        c.gridy = 2;
        contentPane.add(eight, c);      
        
        nine = new JButton("9");
        nine.addActionListener(new NumberListener());
        nine.setActionCommand("9");
        c.gridx = 2;
        c.gridy = 2;
        contentPane.add(nine, c); 
        
        four = new JButton("4");
        four.addActionListener(new NumberListener());
        four.setActionCommand("4");
        c.gridx = 0;
        c.gridy = 3;
        contentPane.add(four, c);     
        
        five = new JButton("5");
        five.addActionListener(new NumberListener());
        five.setActionCommand("5");
        c.gridx = 1;
        c.gridy = 3;
        contentPane.add(five, c);     
        
        six = new JButton("6");
        six.addActionListener(new NumberListener());
        six.setActionCommand("6");
        c.gridx = 2;
        c.gridy = 3;
        contentPane.add(six, c);   
        
        one = new JButton("1"); 
        one.addActionListener(new NumberListener());
        one.setActionCommand("1");
        c.gridx = 0;
        c.gridy = 4;
        contentPane.add(one, c);      
        
        two = new JButton("2");
        two.addActionListener(new NumberListener());
        two.setActionCommand("2");
        c.gridx = 1;
        c.gridy = 4;
        contentPane.add(two, c);        
        
        three = new JButton("3");
        three.addActionListener(new NumberListener());
        three.setActionCommand("3");
        c.gridx = 2;
        c.gridy = 4;
        contentPane.add(three, c);
        
        zero = new JButton("0");
        zero.addActionListener(new NumberListener());
        zero.setActionCommand("0");
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        contentPane.add(zero, c);
        
        decimal = new JButton(".");
        decimal.addActionListener(new NumberListener());
        decimal.setActionCommand(".");
        c.gridx = 2;
        c.gridy = 5;
        c.gridwidth = 1;
        contentPane.add(decimal, c);
        
        divide = new JButton("÷");
        c.gridx = 3;
        c.gridy = 1;
        contentPane.add(divide, c);
        
        multiply = new JButton("x");
        c.gridx = 3;
        c.gridy = 2;
        contentPane.add(multiply, c);
        
        subtract = new JButton("-");
        c.gridx = 3;
        c.gridy = 3;
        contentPane.add(subtract, c);
        
        add = new JButton("+");
        c.gridx = 3;
        c.gridy = 4;
        contentPane.add(add, c);
        
        equals = new JButton("=");
        c.gridx = 3;
        c.gridy = 5;
        contentPane.add(equals, c);
        
        cancel = new JButton("c");
        cancel.addActionListener(new FunctionListener());
        c.gridx = 0;
        c.gridy = 1;
        contentPane.add(cancel, c);
        
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
    class NumberListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().equals("0")) {
                display.setText(e.getActionCommand());
            } else {
                display.setText(display.getText() + "" +  e.getActionCommand());
            }
        }
    }
    
    class FunctionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display.setText("0");
        }
    }
    
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Calculator calc = new Calculator();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                runGUI();
            }
        });
    }
    
}
