package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CelciusToFahrenheit extends JFrame implements ActionListener {
    private JLabel lCelcius;
    private JLabel lFahrenheit;
    private JButton bConvert, bExit;
    private ButtonGroup radioPanel;
    private JRadioButton rbCtoF, rbFtoC;
    private JCheckBox chUpper;
    private JTextField tCelcius, tFahrenheit;
    double tempCelcius;
    double tempFahrenheit;

    public CelciusToFahrenheit() {

        setSize(720, 480);
        setTitle("Celcius to Fahrenheit Calculator");
        setLayout(null);

        lCelcius = new JLabel("Celcius Degees");
        lCelcius.setBounds(50, 20, 150, 20);
        add(lCelcius);

        lFahrenheit = new JLabel("Fahrenheit Degees");
        lFahrenheit.setBounds(50, 100, 150, 20);
        add(lFahrenheit);

        tCelcius = new JTextField("");
        tCelcius.setBounds(200, 20, 150, 20);
        add(tCelcius);
        tCelcius.setToolTipText("Enter temperature in Celcius degrees");
        tCelcius.addActionListener(this);

        tFahrenheit = new JTextField("");
        tFahrenheit.setBounds(200, 100, 150, 20);
        add(tFahrenheit);

        bConvert = new JButton("Convert");
        bConvert.setBounds(50, 150, 110, 20);
        add(bConvert);
        bConvert.addActionListener(this);

        bExit = new JButton("Exit");
        bExit.setBounds(50, 200, 110, 20);
        add(bExit);
        bExit.addActionListener(this);

        chUpper = new JCheckBox("Large Font");
        chUpper.setBounds(350, 200, 110, 20);
        add(chUpper);
//        chUpper.addActionListener(this);

        radioPanel = new ButtonGroup();
        rbCtoF = new JRadioButton("Celcius to Fahrenheit", true);
        rbCtoF.setBounds(50, 250, 250, 20);
        radioPanel.add(rbCtoF);
        add(rbCtoF);
        rbCtoF.addActionListener(this);


        rbFtoC = new JRadioButton("Fahrenheit to Celcius", false);
        rbFtoC.setBounds(350, 250, 250, 20);
        radioPanel.add(rbFtoC);
        add(rbFtoC);
        rbFtoC.addActionListener(this);


    }

    public static void main(String[] args) {
        CelciusToFahrenheit appCalc = new CelciusToFahrenheit();
        appCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appCalc.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == bExit) {
            dispose();
        } else if (source == bConvert || source == tCelcius) {
            if (chUpper.isSelected()) {
                tFahrenheit.setFont(new Font("Verdana", Font.BOLD, 18));
            } else {
                tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 14));
            }
            if(rbCtoF.isSelected()) {
                tempCelcius = Double.parseDouble(tCelcius.getText());
                tempFahrenheit = 32.0 + (9.0 / 5) * tempCelcius;
                tFahrenheit.setText(String.valueOf(tempFahrenheit));
            }else if(rbFtoC.isSelected()){
                tempFahrenheit = Double.parseDouble(tFahrenheit.getText());
                tempCelcius = (tempFahrenheit - 32) * (5.0 / 9.0);
                tCelcius.setText(String.valueOf(tempCelcius));
            }
        }
        if(source == tCelcius){
            tempCelcius = Double.parseDouble(tCelcius.getText());
            tempFahrenheit = 32.0 + (9.0 / 5) * tempCelcius;
            tFahrenheit.setText(String.valueOf(tempFahrenheit));

        }else if(source == tFahrenheit){
            tempFahrenheit = Double.parseDouble(tFahrenheit.getText());
            tempCelcius = (tempFahrenheit - 32) * (5.0 / 9.0);
            tCelcius.setText(String.valueOf(tempCelcius));
        }
    }
}
