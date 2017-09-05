import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlackjackvV1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	 kontroll kontroll1 = kontroll.getkontroll();
	

	/**
	 * Create the application.
	 */
	public BlackjackvV1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 621, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBlackjackVersion = new JLabel("BlackJack Version .01");
		lblBlackjackVersion.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblBlackjackVersion.setBounds(155, 55, 305, 59);
		frame.getContentPane().add(lblBlackjackVersion);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kontroll1.start();
				
				frame.setVisible(false);
				
				
			}
		});
		btnStart.setBackground(Color.WHITE);
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnStart.setToolTipText("Start Blackjack");
		btnStart.setBounds(201, 185, 163, 47);
		frame.getContentPane().add(btnStart);
	}

	public void menyen() {
		EventQueue.invokeLater(new Runnable () {
			public void run () {
				try {
					BlackjackvV1 window = new BlackjackvV1 ();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
}
