package Acceuil;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.*;

import com.placeholder.PlaceHolder;


public class Reserver extends DisponibilitéChambre {
	
	private JButton jb1;
	private JButton jb2, button2;
	private JLabel id,prixT,nombreNuit,tel,client;
	private static JLabel prix;
    private static JLabel dateS;
	private static JLabel dateE;
	private static JTextField t1,t2,t3,t5,t6,t7,t8,t9;
	static PlaceHolder p3,p4;
	
	   
	public void  NewScreen() {
			   JFrame frame= new JFrame( "Formulaire de Réservation " );
			 //ICON
			   frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\YAY.PNG"));
			   frame.setSize(450,350);
			   JPanel panel=new JPanel();
			   frame.add(panel);
			   panel.setLayout(null);
			//NEW ID
				  id=new JLabel("ID_Chambre");
				  id.setBounds(10,20,100,25);
				  id.setForeground(new Color(255, 255, 255));
				  id.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
				  panel.add(id);
			//Bar de Texte
				  t1= new JTextField(20);
				  t1.setBounds(105,20,300,25);
				  panel.add(t1);
							
			//CLIENT
				  client=new JLabel("Client");
				  client.setBounds(10,50,100,25);
				  client.setForeground(new Color(255, 255, 255));
				  client.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
				  panel.add(client);
		   //Bar de Texte
				  t2= new JTextField(20);
				  t2.setBounds(105,50,300,25);
				  panel.add(t2);
					
		  //Telephone
				  tel=new JLabel("Client_Phone");
				  tel.setBounds(10,80,100,25);
				  tel.setForeground(new Color(255, 255, 255));
				  tel.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
				  panel.add(tel);
		  //Bar de Texte
				  t3= new JTextField(20);
				  t3.setBounds(105,80,300,25);
				  panel.add(t3);
						
		 //dateEntrée
				 dateE=new JLabel("Date_Entée");
				 dateE.setBounds(10,110,100,25);
				 dateE.setForeground(new Color(255, 255, 255));
				 dateE.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
				 panel.add(dateE);
		//Bar de Texte
				 t5= new JTextField(20);
				 t5.setBounds(105,110,300,25);
				 panel.add(t5);
						
		//dateSortie
				 dateS=new JLabel("Date_Sortie");
				 dateS.setBounds(10,140,100,25);
				 dateS.setForeground(new Color(255, 255, 255));
				 dateS.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
				 panel.add(dateS);
				 //Bar de Texte
				 t6= new JTextField(20);
				 t6.setBounds(105,140,300,25);
				 panel.add(t6);
						
		//prix
				 prix=new JLabel("Prix_Nuit");
				 prix.setBounds(10,170,100,25);
				 prix.setForeground(new Color(255, 255, 255));
				 prix.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
				 panel.add(prix);
				 //Bar de Texte
				 t8= new JTextField(20);
				 t8.setBounds(105,170,300,25);
				 panel.add(t8);
					    
				//nombre de nuit
				 nombreNuit=new JLabel("Nombre_Nuit");
				 nombreNuit.setBounds(10,200,100,25);
				 nombreNuit.setForeground(new Color(255, 255, 255));
				 nombreNuit.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
				 panel.add(nombreNuit);
				//Bar de Texte
				 t7= new JTextField(20);
				 t7.setBounds(105,200,300,25);
				 panel.add(t7);
						
				//PRIXTOTLA:NOMBRE DE NUIT
				 prixT=new JLabel("PrixTotal");
				 prixT.setBounds(10,230,100,25);
				 prixT.setForeground(new Color(255, 255, 255));
				 prixT.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
			     panel.add(prixT);
				//Bar de Texte
				 t9= new JTextField(20);
				 t9.setBounds(105,230,300,25);
				 panel.add(t9);
				 
				//PLACEHOLDER
					p3=new PlaceHolder(t5,"xxxx-xx-xx");
					p4=new PlaceHolder(t6,"xxxx-xx-xx");
				
						
				//Button
				jb1=new JButton("Add Reservation ");
			    jb1.setBounds(150,270,130,30);
			    jb1.setBackground(new Color(204, 255,255));
				panel.add(jb1);
				//Button
			    jb2=new JButton("Update statut ");
				jb2.setBounds(290,270,130,30);
				jb2.setBackground(new Color(204, 255,255));
				panel.add(jb2);	
				//Button2 :Pour retourner à l'acceuil 
			    button2=new JButton("ACCEUIL");
				button2.setBounds(10,270,130,30);
				button2.setBackground(new Color(204, 255,255));
				panel.add(button2);
				button2.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(ActionEvent arg) {
						Options retourner=new Options();
						retourner.NewScreen();
						frame.dispose();
						voirtable.dispose();
					}
						
					});
				//IMAGE
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\divers.jpg"));
				lblNewLabel.setBounds(0, 0,600,400);
				panel.add(lblNewLabel);
			    
			    
			  //VISUALISER
		     frame.setVisible(true);
		     frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			
				
			//EVENT BUTTON ADD
		     jb1.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(ActionEvent arg1) {	
						String c1 =t1.getText();
						String c2 =t2.getText();
					    String c3 =t3.getText();
					    String c5 =t5.getText();
					    String c6 =t6.getText();
					    String c7 =t7.getText();
					    String c8 =t8.getText();
					    String c9 =t9.getText();
				    
						if( c1.isEmpty() || c2.isEmpty()||c3.isEmpty() ||  c5.isEmpty() || c6.isEmpty()|| c7.isEmpty()|| c8.isEmpty()|| c9.isEmpty() ) {
							 JOptionPane.showMessageDialog(null, "Remplir toutes les cases!");	
							} 
						else {
							DB connecter=new DB();
							connecter.getConnection();
							java.sql.Statement pst;
		
							 try {
							pst = DB.conn.createStatement();
							String sql="insert into réservation (id,client,TEL,DateE,DateS,Nombre_Nuit,Prix,Prix_Total) VALUES ('"+t1.getText()+"' ,'"+t2.getText()+"' ,'"+t3.getText()+"', '"+t5.getText()+"',  '"+t6.getText()+"',  '"+t7.getText()+"', '"+t8.getText()+"','"+t9.getText()+"')";
							//EXECUTER
							pst.executeUpdate(sql);
							
							DB.conn.close();
						
							JOptionPane.showMessageDialog(null, "Les Modifications ont été  insérée!");
							 }catch(Exception e) {
								 e.printStackTrace();
							 }
						}
							 
					}
					
				});
		    
		     //EVENT BUTTON UPDATE
		    jb2.addActionListener(new java.awt.event.ActionListener() {
			   public void actionPerformed(ActionEvent arg2) {	
					String c1 =t1.getText();
					String c2 =t2.getText();
				    String c3 =t3.getText();
				    String c5 =t5.getText();
				    String c6 =t6.getText();
				    String c7 =t7.getText();
				    String c8 =t8.getText();
				    String c9 =t9.getText();
					if( c1.isEmpty() || c2.isEmpty()||c3.isEmpty() ||  c5.isEmpty() || c6.isEmpty()|| c7.isEmpty()|| c8.isEmpty()|| c9.isEmpty() ) {
						 JOptionPane.showMessageDialog(null, "Remplir toutes les cases!");	
						}
					else {
						DB connecter=new DB();
						connecter.getConnection();
						java.sql.Statement pst;
						 try {
							 String query="Update disponibilitéchambre set Statut='réservée' where id_Chambre='"+t1.getText()+"'";
							 pst = DB.conn.createStatement();
							 pst.execute(query);
							 //FERMER BD
							 DB.conn.close();
							 JOptionPane.showMessageDialog(null, "La liste des chambres disponibles ont été mis à jour!");
							 }catch(Exception e) {
								 e.printStackTrace();
							 }
					}
				}
					
			});
			
		
		
	}
	
}
