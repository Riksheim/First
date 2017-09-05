import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class App {

	static JFrame frame;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public App() {
		initialize();
		App.frame.setLocationRelativeTo(null);
	
	}
	
	// Henter objekter av kontroll
	static kontroll kontroll1 = kontroll.getkontroll();
	kontroll hent = new kontroll();
	kontroll spillerdekk = new kontroll();
	kontroll dealerdekk = new kontroll();
	kontroll spilldekk = new kontroll();
	boolean sluttrunde = false;
	
	int klikket = 1;
	int dealerklikket = 1;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel card1 = new JLabel("");
		card1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		card1.setBounds(187, 340, 135, 28);
		frame.getContentPane().add(card1);
		
		JLabel card2 = new JLabel("");
		card2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		card2.setBounds(187, 379, 135, 25);
		frame.getContentPane().add(card2);
		
		JLabel lblYourCards = new JLabel("Your cards");
		lblYourCards.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblYourCards.setBounds(285, 301, 103, 28);
		frame.getContentPane().add(lblYourCards);
		
		JLabel dealerkort1 = new JLabel("");
		dealerkort1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		dealerkort1.setBounds(187, 51, 170, 25);
		frame.getContentPane().add(dealerkort1);
		
		JLabel verdihand = new JLabel("");
		verdihand.setFont(new Font("Tahoma", Font.PLAIN, 18));
		verdihand.setBounds(43, 340, 66, 25);
		frame.getContentPane().add(verdihand);
	
		JLabel lblNewLabel = new JLabel("Dealer's Hand");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(285, 16, 187, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDinHnd = new JLabel("Din H\u00E5nd :");
		lblDinHnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDinHnd.setBounds(33, 301, 87, 28);
		frame.getContentPane().add(lblDinHnd);
		

		JLabel dealerhand = new JLabel("");
		dealerhand.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dealerhand.setBounds(44, 67, 103, 28);
		frame.getContentPane().add(dealerhand);
		
		JLabel lblVilDuhitte = new JLabel("Gj\u00F8r et valg");
		lblVilDuhitte.setBackground(Color.CYAN);
		lblVilDuhitte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVilDuhitte.setBounds(522, 326, 353, 48);
		frame.getContentPane().add(lblVilDuhitte);
		
		lblVilDuhitte.setVisible(false);
		
		JLabel lbldealer1 = new JLabel("");
		lbldealer1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbldealer1.setBounds(43, 67, 77, 28);
		frame.getContentPane().add(lbldealer1);
		
		JLabel lbldealer2 = new JLabel("");
		lbldealer2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbldealer2.setBounds(187, 85, 174, 27);
		frame.getContentPane().add(lbldealer2);
		
		JLabel card3 = new JLabel("");
		card3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		card3.setBounds(187, 415, 135, 28);
		frame.getContentPane().add(card3);
		
		JLabel card4 = new JLabel("");
		card4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		card4.setBounds(187, 454, 135, 28);
		frame.getContentPane().add(card4);
		
		JLabel card5 = new JLabel("");
		card5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		card5.setBounds(366, 437, 170, 38);
		frame.getContentPane().add(card5);
		
		JLabel lbldealer3 = new JLabel("");
		lbldealer3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbldealer3.setBounds(187, 118, 170, 25);
		frame.getContentPane().add(lbldealer3);
		
		JLabel lbldealer4 = new JLabel("");
		lbldealer4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbldealer4.setBounds(187, 149, 170, 25);
		frame.getContentPane().add(lbldealer4);
		
		JLabel lbldealer5 = new JLabel("");
		lbldealer5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbldealer5.setBounds(187, 185, 170, 25);
		frame.getContentPane().add(lbldealer5);
		
		
		
		
		JButton deal = new JButton("Trykk for \u00E5 begynne \u00E5 spille");
		deal.setFont(new Font("Tahoma", Font.PLAIN, 29));
		deal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Lager et nytt spill
				
				// Viser kortene til 
				deal.setVisible(false);
				
				
			
				// Legger til kortene i bunken
				spilldekk.lagfulltdekk();
				// Stokker alle kortene
				spilldekk.stokke();
				//Dekk til spiller
			    spillerdekk.trekk(spilldekk);
				spillerdekk.trekk(spilldekk);
				
				//Dekk til dealer (samme dekket)
			    dealerdekk.trekk(spilldekk);
				dealerdekk.trekk(spilldekk);
				
			
				
				// Legger ut kort til spilleren inn i GUI
				String kortet1 = spillerdekk.skaffkort(0).toString();
				card1.setText(kortet1);
				// Legger ut kort til spilleren inn i GUI
				String kortet2 = spillerdekk.skaffkort(1).toString();
				card2.setText(kortet2);
				
				// Legger ut kort til spilleren inn i GUI
				int verdiavhanden = spillerdekk.kortverdi();
				String verdien = Integer.toString(verdiavhanden);
				verdihand.setText(verdien);
				
				
				 // Dealer sin hand til GUI
				String kortet3 = dealerdekk.skaffkort(1).toString();
				dealerkort1.setText(kortet3);
				
				
				dealerdekk.skaffkort(1);
				
				
				
				int verdiendealer =dealerdekk.getdealerkortverdi();
				String dealerverdi1 = Integer.toString(verdiendealer);
				
				dealerhand.setText(dealerverdi1);
				
			
				
				
				
				lblVilDuhitte.setVisible(true);
				if (verdiavhanden == 21) {
					JOptionPane.showMessageDialog(null, "Du vant, spillet er over");
					
				}
				
				
			
				
				
				
			
		}});
		deal.setBounds(33, 87, 700, 204);
		frame.getContentPane().add(deal);
		
		JButton btnhit = new JButton("HIT");
		btnhit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					// Trekker et nytt kort til spilleren
					spillerdekk.trekk(spilldekk);
					
					
					if (klikket == 1) {
					 String kort3 = spillerdekk.skaffkort(spillerdekk.dekkstorrelse()-1).toString();
					  			card3.setText(kort3);
					  			
					}  
					  	
					  if (klikket == 2) {
					 String kort4 = spillerdekk.skaffkort(spillerdekk.dekkstorrelse()-1).toString();
		  						card4.setText(kort4);
		  						
					  }
						
					
						if (klikket == 3) {
							 String kort5 = spillerdekk.skaffkort(spillerdekk.dekkstorrelse()-1).toString();
				  						card5.setText(kort5);
				  						
							  }
						klikket ++;	
					int verdienavkort = spillerdekk.kortverdi();
					String verdien = Integer.toString(verdienavkort);
					verdihand.setText(verdien);
					
					// 
					if (spillerdekk.kortverdi() > 21) {
						JOptionPane.showMessageDialog(null, "Du tapte, spillet er over" + "\n" + "Hånden din er: " + spillerdekk.kortverdi());
						
						// PLayermoney -= playerbet;
						sluttrunde = true; } 
						else if (verdienavkort == 21) {
							JOptionPane.showMessageDialog(null, "Du vant, spillet er over");;
							sluttrunde = true;
							
						{
							
						}
						
					}
					
				
			
			
			
		
		}});
		btnhit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnhit.setBounds(451, 387, 103, 39);
		frame.getContentPane().add(btnhit);
		
		JButton btnstand = new JButton("STAND");
		btnstand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // Sjekk dealeren sine kort
				
				dealerhand.setText("");
			
				String kortet4 = dealerdekk.skaffkort(0).toString();
				String dealerkort1 = (kortet4);
				lbldealer2.setText(dealerkort1);
				
						//
				
				int dealersum =  dealerdekk.kortverdi();
				String dealsummen = Integer.toString(dealersum);
				
				lbldealer1.setText(dealsummen);
				
			//	String andrekortet = dealerdekk.skaffkort(1).toString();
			//	.setText(andrekortet);
				
				// Hvis jeg står, sjekker om dealerverdien er større en min verdi på håden
			if ((dealerdekk.kortverdi() > spillerdekk.kortverdi() && dealerdekk.kortverdi() < 17 && sluttrunde == false)) {
				JOptionPane.showMessageDialog(null, "Dealer vinner med høyere hånd!");
				
				// playermoney -= playerbet;
				sluttrunde = true;
				
			}
				
			// Sjekker kortene til dealer hvis over over 17 runden ferdig
			
		
			while((dealerdekk.kortverdi() < 17 && sluttrunde == false )) {
				
				dealerdekk.trekk(spilldekk);
				JOptionPane.showMessageDialog(null, "Dealer trekker");
			// 	System.out.println("Dealer trekker " + dealerdekk.skaffkort(dealerdekk.dekkstorrelse()-1).toString()+ "\n" + "\n");
				if (dealerklikket == 1) {
					 String kort3deal = dealerdekk.skaffkort(dealerdekk.dekkstorrelse()-1).toString();
					  			lbldealer3.setText(kort3deal);
					  			
					  			int deal2 =  dealerdekk.kortverdi();
								String dealsum2 = Integer.toString(deal2);
								
								lbldealer1.setText(dealsum2);
											
					}  
					  	
					  if (dealerklikket == 2) {
					 String kort4deal = dealerdekk.skaffkort(dealerdekk.dekkstorrelse()-1).toString();
					 lbldealer4.setText(kort4deal);
					 
					 int deal3 =  dealerdekk.kortverdi();
						String dealsum3 = Integer.toString(deal3);
						
						lbldealer1.setText(dealsum3);
					  }
						
					
						if (dealerklikket == 3) {
							 String kort5deal = dealerdekk.skaffkort(dealerdekk.dekkstorrelse()-1).toString();
							 lbldealer5.setText(kort5deal);
				  			
							 int deal4 =  dealerdekk.kortverdi();
								String dealsum4 = Integer.toString(deal4);
								
								lbldealer1.setText(dealsum4);
							 
							  }
						dealerklikket ++;	
			
				
						
			}
			int dealerhandverdi = dealerdekk.kortverdi();
			int spillerhanden = spillerdekk.kortverdi();
			
			int deal =  dealerdekk.kortverdi();
			String dealsum = Integer.toString(deal);
			
			lbldealer1.setText(dealsum);
			
			
		
			
			
			
			if((dealerdekk.kortverdi()>21)&& sluttrunde == false){
				JOptionPane.showMessageDialog(null, "Dealer busted, Du vinner!");
				
			
				sluttrunde = true;
			}
			//Sjekk for push
			if((dealerdekk.kortverdi() == spillerdekk.kortverdi()) && sluttrunde == false){
				JOptionPane.showMessageDialog(null, "Push, begge hender er like");
				
				sluttrunde = true;
			}
			// sjekk for win
			if((spillerdekk.kortverdi() > dealerdekk.kortverdi()) && sluttrunde == false){
				JOptionPane.showMessageDialog(null, "Du vant hånden!");
				
				
				sluttrunde = true;
			}
			else if(sluttrunde == false) //dealer wins
			{
				JOptionPane.showMessageDialog(null, "Dealer wins!" + "\n" + "Hånden til dealeren er: " + dealerdekk.kortverdi());
				
			
			}
			
			
			spillerdekk.flyttalttildekk(spilldekk);
			dealerdekk.flyttalttildekk(spilldekk);
			JOptionPane.showMessageDialog(null, "Hånden ferdig, trykk reset for å spille igjen!");
			
				}
				
			
			
		});
		btnstand.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnstand.setBounds(600, 387, 103, 39);
		frame.getContentPane().add(btnstand);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				spillerdekk.flyttalttildekk(spilldekk);
				dealerdekk.flyttalttildekk(spilldekk);
				deal.setVisible(true);
				
				lbldealer1.setText(null);
				verdihand.setText(null);
				dealerkort1.setText(null);
				card1.setText(null);
				card2.setText(null);	
			}
		});
		
		JLabel lblDealersHnd = new JLabel("Dealer's H\u00E5nd:");
		lblDealersHnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDealersHnd.setBounds(33, 27, 114, 28);
		frame.getContentPane().add(lblDealersHnd);
		btnNewButton.setBounds(669, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		
		
		
		
		


}
}
