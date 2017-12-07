package swingGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.Border;

public class MainFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	public MainFrame(final String title) {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		
		JFormattedTextField tfDatum = new JFormattedTextField(new Date());
		add(tfDatum);
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setResizable(false);
		
		setVisible(true);
	}





}
