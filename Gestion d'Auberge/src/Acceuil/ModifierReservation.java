package Acceuil;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.placeholder.PlaceHolder;

public class ModifierReservation {

	private static JLabel prixT,nombreNuit,tel,client,id1,id;
	private static JLabel prix;
    private static JLabel dateS;
	private static JLabel dateE;
	private static JTextField t0,t1,t2,t3,t5,t6,t7,t8,t9;
	private static JButton button,button2;
	static PlaceHolder p1,p2;
    
	public  void NewScreen() {
		JPanel panel=new JPanel();
	    JFrame frame=new JFrame("Modifier une Reservation");
		frame.setSize(350,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ICON
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\YAY.PNG"));
		frame.add(panel);
		panel.setLayout(null);
		
		
		//old id
		id1=new JLabel("OLD ID");
		id1.setBounds(10,20,80,25);
		id1.setForeground(new Color(255, 255, 255));
		id1.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		panel.add(id1);
		//Bar de Texte
		t0= new JTextField(20);
		t0.setBounds(120,20,165,25);
		panel.add(t0);
				
		
		//NEW ID
		id=new JLabel("New ID");
		id.setBounds(10,50,100,25);
		id.setForeground(new Color(255, 255, 255));
		id.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		panel.add(id);
		//Bar de Texte
		t1= new JTextField(20);
		t1.setBounds(120,50,165,25);
		panel.add(t1);
		
		
		
		
		//CLIENT
		client=new JLabel("Client");
		client.setBounds(10,80,100,25);
		client.setForeground(new Color(255, 255, 255));
		client.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		panel.add(client);
		//Bar de Texte
		t2= new JTextField(20);
		t2.setBounds(120,80,165,25);
		panel.add(t2);
		
		//Telephone
		tel=new JLabel("Client_Phone");
		tel.setBounds(10,110,100,25);
		tel.setForeground(new Color(255, 255, 255));
		tel.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		panel.add(tel);
		//Bar de Texte
		t3= new JTextField(20);
		t3.setBounds(120,110,165,25);
		panel.add(t3);
				
		//dateEntrée
		 dateE=new JLabel("Date_Entée");
		 dateE.setBounds(10,140,100,25);
		 dateE.setForeground(new Color(255, 255, 255));
		 dateE.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		 panel.add(dateE);
		//Bar de Texte
		 t5= new JTextField(20);
		 t5.setBounds(120,140,165,25);
		 panel.add(t5);
				
		  //dateSortie
		 dateS=new JLabel("Date_Sortie");
		 dateS.setBounds(10,170,100,25);
		 dateS.setForeground(new Color(255, 255, 255));
		 dateS.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		 panel.add(dateS);
		 //Bar de Texte
		 t6= new JTextField(20);
		 t6.setBounds(120,170,165,25);
		 panel.add(t6);
				
		 //prix
		 prix=new JLabel("Prix_Nuit");
		 prix.setBounds(10,200,100,25);
		 prix.setForeground(new Color(255, 255, 255));
		 prix.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		 panel.add(prix);
		 //Bar de Texte
		 t7= new JTextField(20);
		 t7.setBounds(120,200,165,25);
		 panel.add(t7);
			    
		//nombre de nuit
		 nombreNuit=new JLabel("Nombre_Nuit");
		 nombreNuit.setBounds(10,230,100,25);
		 nombreNuit.setForeground(new Color(255, 255, 255));
		 nombreNuit.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		 panel.add(nombreNuit);
		//Bar de Texte
		 t8= new JTextField(20);
		 t8.setBounds(120,230,165,25);
		 panel.add(t8);
				
		//PRIXTOTLA:NOMBRE DE NUIT
		 prixT=new JLabel("PrixTotal");
		 prixT.setBounds(10,260,100,25);
		 prixT.setForeground(new Color(255, 255, 255));
		 prixT.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		 panel.add(prixT);
		//Bar de Texte
		 t9= new JTextField(20);
		 t9.setBounds(120,260,165,25);
		 panel.add(t9);
		 
		//PLACEHOLDER
			p1=new PlaceHolder(t5,"xxxx-xx-xx");
			p2=new PlaceHolder(t6,"xxxx-xx-xx");
		
		//Button
	     button=new JButton("MODIFIER");
		 button.setBounds(180,300,130,30);
		 panel.add(button);
		//Button2 :Pour retourner à l'acceuil 
	     button2=new JButton("ACCEUIL");
		 button2.setBounds(20,300,130,30);
		 panel.add(button2);
		 button2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				Options retourner=new Options();
				retourner.NewScreen();
				frame.dispose();
			}
				
			});
		
		//IMAGE
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\modifier.jpg"));
		lblNewLabel.setBounds(0, 0,350,400);
		panel.add(lblNewLabel);
		//VISUALISER
		frame.setVisible(true);
		
		button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				String c0 =t0.getText();
				String c1 =t1.getText();
		        String c2 =t2.getText();
		        String c3 =t3.getText();
		        String c5 =t5.getText();
		        String c6 =t6.getText();
		        String c7 =t7.getText();
		        String c8 =t8.getText();
		        String c9 =t9.getText();
				if(c0.isEmpty()|| c1.isEmpty() || c2.isEmpty()||c3.isEmpty() ||  c5.isEmpty() || c6.isEmpty()|| c7.isEmpty()|| c8.isEmpty()|| c9.isEmpty() ) {
					 JOptionPane.showMessageDialog(null, "Remplir toutes les cases!");	
	            }else {
	            	DB connecter=new DB();
					connecter.getConnection();
					java.sql.Statement pst;
					
					 try {
					 String sql="Update Réservation Set id='"+t1.getText()+"' ,client='"+t2.getText()+"' ,TEL='"+t3.getText()+"', DateE='"+t5.getText()+"',  DateS='"+t6.getText()+"',  Nombre_Nuit='"+t7.getText()+"', Prix='"+t8.getText()+"' ,Prix_Total='"+t9.getText()+"' where id='"+t0.getText()+"'";
					 pst = DB.conn.createStatement();
					 pst.executeUpdate(sql);
					 DB.conn.close();
					 JOptionPane.showMessageDialog(null, "Les Modifications ont été  effectuées!");
					 }catch(Exception e) {
						 e.printStackTrace();
					 }
	            }
	         }
		});
	}
}
