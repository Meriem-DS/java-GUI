package Acceuil;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Options {
	private static JButton button1;
	private static JButton button2;
	private static JButton button3;
	private static JButton button4,button5;
	private static JLabel title;
	private static JFrame frame;
	
    
	public void NewScreen() {
		 
		
		JPanel panel=new JPanel();
	    frame=new JFrame("ACCEUIL");
		frame.setSize(620,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ICON
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\YAY.PNG"));
		frame.add(panel);
		panel.setLayout(null);
		
		title=new JLabel("Auberge BONHEUR");
		title.setForeground(new Color(255, 255, 255));
		title.setBounds(200,2,250,100);
		title.setFont(new Font("Lucida Handwriting", Font.BOLD, 20));
		panel.add(title);
		
		button1=new JButton("Consulter la disponibilité des chambres");
		button1.setBackground(new Color(255, 248, 220));
		button1.setBounds(10,90,260,50);
		panel.add(button1);
		
		button2=new JButton("Modifier une réservation");
		button2.setBackground(new Color(255, 248, 220));
		button2.setBounds(300,90,260,50);
		panel.add(button2);
		

		button3=new JButton("Annuler Réservation");
		button3.setBackground(new Color(255, 248, 220));
		button3.setBounds(10,180,260,50);
		panel.add(button3);
	
		button4=new JButton("Demande d'une Facture");
		button4.setBackground(new Color(255, 248, 220));
		button4.setBounds(300,180,260,50);
		panel.add(button4);
		
		button5=new JButton("Déconnexion");
		button5.setBackground(new Color(255, 255, 204));
		button5.setBounds(200,300,165,25);
		panel.add(button5);
		
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				//double click the button after that there is available
			  DisponibilitéChambre critere= new DisponibilitéChambre();
			  critere.NewScreen();
			  frame.dispose();
			}
		});

		button2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
			  ModifierReservation modifier= new ModifierReservation();
			  modifier.NewScreen();
			  frame.dispose();
			}
		});
		
		button3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent arg2) {	
				AnnulerReservation annuler= new AnnulerReservation();
				  annuler.NewScreen();
				  frame.dispose();
			}
			
		});
		
		button4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent arg4) {	
				Facturer facture= new Facturer();
				  facture.NewScreen();
				  frame.dispose();
			}
		
		});
		
		button5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent arg5) {	
				 Login.main(null);
				  frame.dispose();
			}
		
		});
		
		
		//IMAGE
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\happy.jpg"));
		lblNewLabel.setBounds(0, 0,600,400);
		panel.add(lblNewLabel);
			
		//VISUALISER
		frame.setVisible(true);	

	}
	
	
}

