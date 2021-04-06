package com.company;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMENU_TEST extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu menuFile, menuTools, menuHelp, menuOptions;
    JMenuItem mOpen, mSave, mExit, mTool1, mTool2, mTool3, mOption1, mOption2, mAbout;

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
        menuBar.add(menuHelp);

        mOpen = new JMenuItem("Open");
        mSave = new JMenuItem("Save");
        mExit = new JMenuItem("Exit");

        menuFile.add(mOpen);
        menuFile.add(mSave);
        menuFile.addSeparator();
        menuFile.add(mExit);

        mTool1 = new JMenuItem("Tool_1");
        mTool2 = new JMenuItem("Tool_2");
        mTool3 = new JMenuItem("Tool_3");

        menuTools.add(mTool1);
        menuTools.addSeparator();
        menuTools.add(mTool2);
        menuTools.addSeparator();
        menuTools.add(mTool3);
        menuTools.addSeparator();
            menuOptions = new JMenu("Options");
            mOption1 = new JMenuItem("Option1");
            mOption2 = new JMenuItem("Option2");
            menuOptions.add(mOption1);
            menuOptions.add(mOption2);
        menuTools.add(menuOptions);

        mAbout = new JMenuItem("About");
        menuHelp.add(mAbout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        JMENU_TEST appMenu = new JMENU_TEST();
        appMenu.setVisible(true);

    }


}
