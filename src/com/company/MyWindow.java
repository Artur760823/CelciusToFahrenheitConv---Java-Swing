package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MyWindow extends JFrame implements ActionListener {
    JButton bPodajDate, bExit;
    JLabel lDispalyData;
    public MyWindow(){
        setSize(720, 480);
        setTitle("Moje pierwsze okno");
        setLayout(null);
        bPodajDate = new JButton("Podaj Datę");
        bPodajDate.setBounds(300,100,100,20);
        add(bPodajDate);
        bPodajDate.addActionListener(this);

        bExit = new JButton("Exit");
        bExit.setBounds(300, 300, 100, 20);
        add(bExit);
        bExit.addActionListener(this);

        lDispalyData = new JLabel("---------------------------------------------");
        lDispalyData.setBounds(260,150,300,20);
        lDispalyData.setForeground(new Color(0,64,192));
        lDispalyData.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(lDispalyData);


    }
    public static void main(String[] args) {
        MyWindow firstWindow = new MyWindow();
        firstWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firstWindow.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == bPodajDate){
            lDispalyData.setText(new Date().toString());
//            System.out.println(new Date());
        }
        else if(source == bExit){
            dispose();
        }

    }
}
