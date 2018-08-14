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
    JButton sign;
    JButton percent;
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
    private boolean operating = false;
    private boolean hasDecimal = false;
    private boolean result = false;
    private char operator;
    private double num1;
    private double num2;
    
    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        GridBagConstraints c = new GridBagConstraints();
        Font f = new Font("Arial", Font.PLAIN, 30);
        
        display = new JLabel("0");
        display.setHorizontalAlignment(JLabel.RIGHT);
        display.setOpaque(true);
        display.setFont(f);
        display.setBackground(Color.white);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(display, c);
        
        seven = new JButton("7");
        seven.setFont(f);
        seven.addActionListener(new NumberListener());
        seven.setActionCommand("7");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        contentPane.add(seven, c);     
        
        eight = new JButton("8");
        eight.setFont(f);
        eight.addActionListener(new NumberListener());
        eight.setActionCommand("8");
        c.gridx = 1;
        c.gridy = 2;
        contentPane.add(eight, c);      
        
        nine = new JButton("9");
        nine.setFont(f);
        nine.addActionListener(new NumberListener());
        nine.setActionCommand("9");
        c.gridx = 2;
        c.gridy = 2;
        contentPane.add(nine, c); 
        
        four = new JButton("4");
        four.setFont(f);
        four.addActionListener(new NumberListener());
        four.setActionCommand("4");
        c.gridx = 0;
        c.gridy = 3;
        contentPane.add(four, c);     
        
        five = new JButton("5");
        five.setFont(f);
        five.addActionListener(new NumberListener());
        five.setActionCommand("5");
        c.gridx = 1;
        c.gridy = 3;
        contentPane.add(five, c);     
        
        six = new JButton("6");
        six.setFont(f);
        six.addActionListener(new NumberListener());
        six.setActionCommand("6");
        c.gridx = 2;
        c.gridy = 3;
        contentPane.add(six, c);   
        
        one = new JButton("1"); 
        one.setFont(f);
        one.addActionListener(new NumberListener());
        one.setActionCommand("1");
        c.gridx = 0;
        c.gridy = 4;
        contentPane.add(one, c);      
        
        two = new JButton("2");
        two.setFont(f);
        two.addActionListener(new NumberListener());
        two.setActionCommand("2");
        c.gridx = 1;
        c.gridy = 4;
        contentPane.add(two, c);        
        
        three = new JButton("3");
        three.setFont(f);
        three.addActionListener(new NumberListener());
        three.setActionCommand("3");
        c.gridx = 2;
        c.gridy = 4;
        contentPane.add(three, c);
        
        zero = new JButton("0");
        zero.setFont(f);
        zero.addActionListener(new NumberListener());
        zero.setActionCommand("0");
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        contentPane.add(zero, c);
        
        decimal = new JButton(".");
        decimal.setFont(f);
        decimal.addActionListener(new NumberListener());
        decimal.setActionCommand(".");
        c.gridx = 2;
        c.gridy = 5;
        c.gridwidth = 1;
        contentPane.add(decimal, c);
        
        divide = new JButton("÷");
        divide.setFont(f);
        divide.addActionListener(new OperationListener());
        divide.setActionCommand("divide");
        c.gridx = 3;
        c.gridy = 1;
        contentPane.add(divide, c);
        
        multiply = new JButton("x");
        multiply.setFont(f);
        multiply.addActionListener(new OperationListener());
        multiply.setActionCommand("multiply");
        c.gridx = 3;
        c.gridy = 2;
        contentPane.add(multiply, c);
        
        subtract = new JButton("-");
        subtract.setFont(f);
        subtract.addActionListener(new OperationListener());
        subtract.setActionCommand("subtract");
        c.gridx = 3;
        c.gridy = 3;
        contentPane.add(subtract, c);
        
        add = new JButton("+");
        add.setFont(f);
        add.addActionListener(new OperationListener());
        add.setActionCommand("add");
        c.gridx = 3;
        c.gridy = 4;
        contentPane.add(add, c);
        
        equals = new JButton("=");
        equals.setFont(f);
        equals.addActionListener(new FunctionListener());
        equals.setActionCommand("equals");
        c.gridx = 3;
        c.gridy = 5;
        contentPane.add(equals, c);
        
        cancel = new JButton("c");
        cancel.setFont(f);
        cancel.addActionListener(new FunctionListener());
        cancel.setActionCommand("cancel");
        c.gridx = 0;
        c.gridy = 1;
        contentPane.add(cancel, c);
        
        sign = new JButton("+/-");
        sign.setFont(f);
        sign.addActionListener(new FunctionListener());
        sign.setActionCommand("sign");
        c.gridx = 1;
        c.gridy = 1;
        contentPane.add(sign, c);
        
        percent = new JButton("%");
        percent.setFont(f);
        percent.addActionListener(new FunctionListener());
        percent.setActionCommand("percent");
        c.gridx = 2;
        c.gridy = 1;
        contentPane.add(percent, c);
        
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
    class NumberListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            
            if (display.getText().equals("0") || operating == true || result == true) {
                if (button.equals(".")) {
                    display.setText("0.");
                    hasDecimal = true;
                } else {
                    display.setText(button);
                }
                operating = false;
                result = false;
            } else {
                if (button.equals(".")) {
                    if (!hasDecimal) {
                        display.setText(display.getText() + ".");
                        hasDecimal = true;
                    }
                } else { 
                    display.setText(display.getText() + button);
                }
            }
        }
    }
    
    class FunctionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double temp;
            switch (e.getActionCommand()) {
                case "cancel":
                    display.setText("0");
                    break;
                case "sign":
                    temp = Double.parseDouble(display.getText());
                    temp = -temp;
                    display.setText(temp + "");
                    break;
                case "percent":
                    temp = Double.parseDouble(display.getText());
                    temp /= 100;
                    display.setText(temp + "");
                    break;
                case "equals": 
                    num2 = Double.parseDouble(display.getText());
                    switch (operator) {
                        case '+':
                            num1 += num2;
                            break;
                        case '-':
                            num1 -= num2;
                            break;
                        case '*':
                            num1 *= num2;
                            break;
                        case '/':
                            num1 /= num2;
                            break;
                        default:
                            break;
                    }
                    result = true;
                    if (num1%1 == 0) {
                        display.setText((int)(num1) + "");
                    } else {
                        display.setText(num1 + "");
                    }
                    break;
            }
        }
    }
    
    class OperationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            num1 = Double.parseDouble(display.getText());
            operating  = true;
            switch (e.getActionCommand()) {
                case "add":
                    operator = '+';
                    break;
                case "subtract":
                    operator = '-';
                    break;
                case "multiply":
                    operator = '*';
                    break;
                case "divide":
                    operator = '/';
                    break;
            }
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
