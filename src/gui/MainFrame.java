package gui;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class MainFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	public MainFrame(final String title) {
		super(title);
		
		
		setLayout(new BorderLayout());
		
		// padding
		JPanel contentPanel = new JPanel();
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		contentPanel.setBorder(padding);
		setContentPane(contentPanel);
		
		JTextField input = new JTextField(5);
        input.setBounds(100,20,100,20);
        add(input);
		
        
        setLayout(new BorderLayout());
        
        JButton button = new JButton("Click Me");
        add(button, BorderLayout.SOUTH);
		
        
        
        
        
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setResizable(false);
		
		setVisible(true);
	}





}
