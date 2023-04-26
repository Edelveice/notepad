package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NootepadWindow extends JFrame implements ActionListener
{
    Nootepad nootepad;

    JTextArea textArea;
    JMenuBar menuBar;

    JMenu mFile;
    JMenu mExit;
    JMenu mColor;
    JMenu mFont;
    JMenu mSize;
    JMenuItem miNew;
    JMenuItem miOpen;
    JMenuItem miSave;

    public NootepadWindow(String title, int width,int height)
    {
        nootepad = new Nootepad();

        setTitle(title);
        setSize(width,height);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        textArea = new JTextArea();
        mFile = new JMenu("File");
        mColor = new JMenu("Color");
        mFont = new JMenu("Font");
        mSize = new JMenu("Size");
        miNew = new JMenuItem("New");
        miOpen = new JMenuItem("Open");
        miSave = new JMenuItem("Save");
        mExit = new JMenu("Exit");

        miNew.addActionListener(this);
        miOpen.addActionListener(this);
        miSave.addActionListener(this);

        mFile.add(miNew);
        mFile.add(miSave);
        mFile.add(miOpen);

        menuBar.add(mFile);
        menuBar.add(mExit);
        menuBar.add(mColor);
        menuBar.add(mFont);
        menuBar.add(mSize);

        setJMenuBar(menuBar);
        add(textArea, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(miNew))
            nootepad.newFile();

        if(e.getSource().equals(miOpen))
            textArea.setText(nootepad.openFile().toString());

        if(e.getSource().equals(miSave))
            nootepad.saveFile(textArea.getText().getBytes());
    }
}
