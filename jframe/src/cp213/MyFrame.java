package cp213;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
    JButton button = new JButton();
    JButton button2 = new JButton();
    JLabel label = new JLabel();
    JMenuItem load = new JMenuItem("load");
    JProgressBar bar;
    JLabel progressLabel;
    JMenuItem save = new JMenuItem("Save");

    int k = 0;

    MyFrame() {
	button.setBounds(250, 250, 100, 50);
	button.addActionListener(this);
	button.setText("HELLO !");
	button2.setBounds(350, 250, 100, 50);
	button2.addActionListener(this);
	button2.setText("This so");

	label.setBounds(250, 450, 200, 100);
	label.setVisible(false);
	label.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 100));
	this.setTitle("Hello World");
	this.setSize(800, 800);

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	this.setLayout(null);
//	frame.add(redPanel);
//	frame.add(bluePanel);
//	frame.add(label);

	JTextField txt = new JTextField();
	txt.setPreferredSize(new Dimension(500, 100));

	this.add(txt);
	this.add(button);
	this.add(button2);
	this.add(label);

	this.getContentPane().setBackground(new Color(123, 50, 250));

	bar = new JProgressBar();
	progressLabel = new JLabel("o");

	bar.setBounds(10, 650, 780, 50);
	bar.setForeground(Color.RED);
	bar.setBackground(Color.BLACK);

	progressLabel.setBounds(400, 680, 100, 20);
	progressLabel.setForeground(Color.WHITE);
	progressLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));

	this.add(bar);
	this.add(progressLabel);

	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenu editMenu = new JMenu("Edit");

	load.addActionListener(this);
	save.addActionListener(this);

	load.setMnemonic(KeyEvent.VK_L);

	JMenuItem undo = new JMenuItem("undo");
	JMenuItem redo = new JMenuItem("redo");
	fileMenu.add(load);
	fileMenu.add(save);

	editMenu.add(undo);
	editMenu.add(redo);

	menuBar.add(fileMenu);
	menuBar.add(editMenu);

	this.setJMenuBar(menuBar);
	this.setVisible(true);
	fill();

    }

    public void fill() {
	int count = 0;
	while (count <= 100) {
	    bar.setValue(count);
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    count += 1;
	    progressLabel.setText(String.valueOf(count));
	}
	progressLabel.setText("Done");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == button) {
//	    System.out.println("this now working");
	    ++k;
	    label.setText(String.valueOf(k));
//	    label.setVisible(true);
//	    JpanelLayered jp = new JpanelLayered();
	    JFileChooser file = new JFileChooser();
	    file.showOpenDialog(null);
	}

	if (e.getSource() == button2) {
//	    System.out.println("this is from button 2");
	    JOptionPane.showMessageDialog(null, "this is a message", "this", JOptionPane.PLAIN_MESSAGE);
	    JOptionPane.showMessageDialog(null, "this is a message", "this", JOptionPane.INFORMATION_MESSAGE);
	    JOptionPane.showMessageDialog(null, "this is a message", "this", JOptionPane.ERROR_MESSAGE);
	    JOptionPane.showMessageDialog(null, "this is a message", "this", JOptionPane.QUESTION_MESSAGE);
	    JOptionPane.showMessageDialog(null, "this is a message", "this", JOptionPane.WARNING_MESSAGE);

	}

	if (e.getSource() == load) {
	    JOptionPane.showMessageDialog(null, "Now Loading", "this", JOptionPane.PLAIN_MESSAGE);

	}
	if (e.getSource() == save) {
	    System.exit(0);
	}
    }

}
