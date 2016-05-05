package Alarm;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Alarm extends JFrame { // Alarm form...
	
	private Mainform parent = null; //parnet frame
	private JPanel contentPane;
	private JButton button;
	private JLabel lblWakeUp;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Alarm(final Mainform parent) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				parent.musicStop(); // if closing -> music stop
			}
		});
		setTitle("Alarm!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.musicStop(); // cancel btn -> close 
				dispose();
			}
		});
		button.setBounds(150, 177, 125, 29);
		contentPane.add(button);
		
		lblWakeUp = new JLabel("Wake Up");
		lblWakeUp.setBounds(174, 100, 82, 21);
		contentPane.add(lblWakeUp);
		
		setVisible(true);
	}

}
