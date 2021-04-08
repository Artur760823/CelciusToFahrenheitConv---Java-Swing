package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JMENU_TEST extends JFrame implements ActionListener {
    JLabel label;
    JButton btnSearch;
    JPopupMenu popup;
    JMenuBar menuBar;
    JMenu menuFile, menuTools, menuHelp, menuOptions;
    JMenuItem mOpen, mSave, mExit, mTool1, mTool2, mTool3, mOption1, mpCopy, mpPaste, mpAdd, mAbout;
    JCheckBoxMenuItem chOption2;
    JTextField txtSearch;
    JTextArea notebook;
    String copyText;


    public JMENU_TEST(){
        setTitle("Presentation JMenuBar");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuTools = new JMenu("Tools");
        menuHelp = new JMenu("Help");

        setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuBar.add(menuTools);


        mOpen = new JMenuItem("Open", 'O');
        mOpen.addActionListener(this);
        mSave = new JMenuItem("Save");
        mSave.addActionListener(this);
        mExit = new JMenuItem("Exit");

        mExit.addActionListener(this);
        mExit.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        menuFile.add(mOpen);
        menuFile.add(mSave);
        menuFile.addSeparator();
        menuFile.add(mExit);

        mTool1 = new JMenuItem("Tool_1");
        mTool2 = new JMenuItem("Tool_2");
        mTool2.addActionListener(this);
        mTool3 = new JMenuItem("Tool_3");

        menuTools.add(mTool1);
        mTool1.setEnabled(false);
        menuTools.addSeparator();
        menuTools.add(mTool2);
        menuTools.addSeparator();
        menuTools.add(mTool3);
        menuTools.addSeparator();
            menuOptions = new JMenu("Options");
            mOption1 = new JMenuItem("Option1");
            chOption2 = new JCheckBoxMenuItem("Option2");
            chOption2.addActionListener(this);
            menuOptions.add(mOption1);
            menuOptions.add(chOption2);

        menuTools.add(menuOptions);
        menuBar.add(menuHelp);
        menuBar.add(Box.createHorizontalGlue());
        mAbout = new JMenuItem("About");
        mAbout.addActionListener(this);
        menuHelp.add(mAbout);

        notebook = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(notebook);
        scrollPane.setBounds(50,50,500,600);
        add(scrollPane);

        txtSearch = new JTextField();
        txtSearch.setBounds(50,680,250,25);
        add(txtSearch);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(310, 680, 100, 25);
        add(btnSearch);
        btnSearch.addActionListener(this);

        popup = new JPopupMenu();
        mpCopy = new JMenuItem("Copy");
        mpCopy.addActionListener(this);
        mpPaste = new JMenuItem("Paste");
        mpPaste.addActionListener(this);
        mpAdd = new JMenuItem("Add");
        mpAdd.addActionListener(this);

        popup.add(mpCopy);
        popup.add(mpPaste);
        popup.add(mpAdd);

        notebook.setComponentPopupMenu(popup);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == mOpen){
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                File plik = fileChooser.getSelectedFile();
//                JOptionPane.showMessageDialog(null, "Wybrany Plik to "
//                + plik.getAbsolutePath());
                try {
                    Scanner scanner = new Scanner(plik);
                    while (scanner.hasNext()){
                        notebook.append(scanner.nextLine() + "\n");
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }

        }else if (source == mSave){
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                File plik = fileChooser.getSelectedFile();
                try {
                    PrintWriter printWriter = new PrintWriter(plik);
                    Scanner scanner = new Scanner(notebook.getText());

                    while (scanner.hasNext()){
                        printWriter.println(scanner.nextLine());
                    }

                    printWriter.close();

                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
//                JOptionPane.showMessageDialog(null, "Zapisywany Plik to "
//                        + plik);
            }

        }else if(source == mExit){
            int answer = JOptionPane.showConfirmDialog(null, "Czy na pewno wyjść?",
                    "Pytanie", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION){
                dispose();
            }else if(answer == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Wiedziałem");
            }else if(answer == JOptionPane.CLOSED_OPTION){
                JOptionPane.showMessageDialog(null, "Tak nie robimy",
                        "Tytuł", JOptionPane.WARNING_MESSAGE);
            }

        }
        else if(source == btnSearch){
            String text = notebook.getText();
            String searchText = txtSearch.getText();
            String txtFound = "";
            int i = 0;
            int index;
            int startIndex = 0;
            while((index = text.indexOf(searchText, startIndex)) != -1){
                startIndex = index + searchText.length();
                i++;
                txtFound = txtFound + " " + index;
            }
            JOptionPane.showMessageDialog(null, searchText + " wystąpiło"
            + i + " razy: " + txtFound);
        }
        else if (source == mpCopy){
            copyText = notebook.getSelectedText();
        }
        else if (source == mpPaste){
            notebook.insert(copyText, notebook.getCaretPosition());
        }
        else if(source == mpAdd){
            notebook.append("\n" + copyText);
        }
        if(source == chOption2){
            if(chOption2.isSelected()){
                mTool1.setEnabled(true);
            }else if(!chOption2.isSelected()){
                mTool1.setEnabled(false);
            }
        }
        if (source == mAbout){
            JOptionPane.showMessageDialog(this, "Program demonstruje wykorztstanie JMenuBar\n" +
                    "u JMenu w prostym programie\n wersja 1.0", "Tytuł", JOptionPane.WARNING_MESSAGE);
        }
        if (source == mTool2){
            String sMeters = JOptionPane.showInputDialog("Podaj długość w metrach: ");
            double dMeters = Double.parseDouble(sMeters);
            double dFeet = dMeters / 0.3048;
            String sFeet = String.format("%.2f", dFeet);
            JOptionPane.showMessageDialog(null, dMeters + " meters = " + sFeet + " feet");
        }
    }
    public static void main(String[] args) {
        JMENU_TEST appMenu = new JMENU_TEST();
        appMenu.setVisible(true);

    }


}
