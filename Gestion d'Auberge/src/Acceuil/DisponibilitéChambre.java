package Acceuil;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.placeholder.PlaceHolder;


public class DisponibilitéChambre  {
	   private static JLabel nombreL, statut;
	   private static JLabel prix;
	   private static JLabel dateS;
	   private static JLabel dateE;
	   private static JTextField t1,t2,t3,t4;
	   private static JButton button,button2;
	   private static JRadioButton r1;
	   public ResultSet rs=null;
	   static JFrame frame,voirtable; 
	   static PlaceHolder p1,p2;
	   
    
	public  void NewScreen() {

		JPanel panel=new JPanel();
	    frame=new JFrame("Consulter Chambre");
		frame.setSize(320,630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ICON
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\YAY.PNG"));
		frame.add(panel);
		panel.setLayout(null);
		
		JLabel title=new JLabel("Consulter la Disponibilité");
		title.setBounds(20,2,220,100);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Lucida Handwriting", Font.BOLD, 15));
		panel.add(title);
		
		//NombreLit
		nombreL=new JLabel("Nombre_Lit");
		nombreL.setBounds(10,100,80,25);
		nombreL.setForeground(new Color(255, 255, 255));
		nombreL.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		panel.add(nombreL);
		//Bar de Texte
		t1= new JTextField(20);
		t1.setBounds(100,100,165,25);
		panel.add(t1);
		
		//dateEntrée
		dateE=new JLabel("Date_Entée");
		dateE.setBounds(10,140,80,25);
		dateE.setForeground(new Color(255, 255, 255));
		dateE.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		panel.add(dateE);
		//Bar de Texte
		t2= new JTextField(20);
	    t2.setBounds(100,140,165,25);
	    panel.add(t2);
		
		//dateSortie
		dateS=new JLabel("Date_Sortie");
		dateS.setBounds(10,180,80,25);
		dateS.setForeground(new Color(255, 255, 255));
		dateS.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		panel.add(dateS);
		//Bar de Texte
		t3= new JTextField(20);
	    t3.setBounds(100,180,165,25);
		panel.add(t3);
		
		//prix
		prix=new JLabel("Prix_Nuit");
		prix.setBounds(10,220,80,25);
		prix.setForeground(new Color(255, 255, 255));
		prix.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		panel.add(prix);
		//Bar de Texte
	    t4= new JTextField(20);
		t4.setBounds(100,220,165,25);
	    panel.add(t4);
	    
	    //Statut:reserver ou non
	    statut=new JLabel("Statut");
		statut.setBounds(10,260,80,25);
		statut.setForeground(new Color(255, 255, 255));
		statut.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
		panel.add(statut);
		//RadioButton:un seul choix  
		r1 = new JRadioButton("disponible",true);  
		r1.setBounds(100,260, 165,25);  
        panel.add(r1);  
        
      //PLACEHOLDER
		p1=new PlaceHolder(t3,"xxxx-xx-xx");
		p2=new PlaceHolder(t2,"xxxx-xx-xx");
        
		
		//Button
	    button=new JButton("CHERCHER");
		button.setBounds(180,300,100,40);
		button.setBackground(new Color(255, 255, 204));
		panel.add(button);
		//Button2 :Pour retourner à l'acceuil 
	    button2=new JButton("ACCEUIL");
		button2.setBounds(20,300,100,40);
		button2.setBackground(new Color(255, 255, 204));
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
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\dispo.jpg"));
		lblNewLabel.setBounds(0, 0,600,600);
		panel.add(lblNewLabel);
		
		//VISUALISER
		frame.setVisible(true);
		
		//Connexion to DB pour afficher la liste (si existe oun non afficher message!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				String c1 =t1.getText();
		        String c2 =t2.getText();
		        String c3 =t3.getText();
		        String c4 =t4.getText();
				if(!(r1.isSelected()) || c1.isEmpty() || c2.isEmpty()|| c3.isEmpty() || c4.isEmpty()) {
					 JOptionPane.showMessageDialog(null, "Remplir toutes les cases !");	
				}else {
					DB connecter=new DB();
					connecter.getConnection();
					 PreparedStatement pst;
					 try {
					 pst=DB.conn.prepareStatement("Select id_Chambre,DateE,DateS, Prix from disponibilitéchambre where nombre_Lit=? and DateE=? and DateS=? and Prix=? and Statut='disponible' ");
					 pst.setString(1, c1);
					 pst.setString(2, c2);
					 pst.setString(3, c3);
					 pst.setString(4, c4);
					 rs= pst.executeQuery();
					 
					
					
					 //TABLE

					   int i = 0; //variable pour l'incrémentation de while
	                   int k = 0;// variable utiliser pour obtenir le nombre de rangées

	                 if(rs.next()){ 
	                	 //passe le curseur à l'élément suivant ;
		                    rs.first();    //passe le curseur sur le premier élément
		                    rs.last(); //last : passe le curseur sur le dernier élément ;
		                    k = rs.getRow(); //résultat.pour obtenir le nombre de rangées de la table
		                    rs.beforeFirst(); // passe le curseur avant le premier élément (position par défaut du curseur) ;
		                
	                
	                 
	   			    
	                Object[][] t = new Object[k][4]; //déclaration d'un tableau Object double

	                //on met le resultat de la requete dans un tableau
	                //la boucle ci-dessous affiche les données de 4 colonnes (j'en ai 4)
	                //si je supprime une ligne de cette boucle j'obtiens un NULL sur une donnée de la colonne concernée.
	                while (rs.next()){
	                    t[i][0]=rs.getInt(1);//résultat.obtenir un int
	                    t[i][1]=rs.getDate(2);
	                    t[i][2]=rs.getDate(3);
	                    t[i][3]=rs.getFloat(4); //résultat.obtenir DATE
	                    i++;
	                }
	                
	                

	               voirtable= new JFrame( "Liste des Chambres disponible " );
	        //Affichage des colonnes table dans la jTable**********************************
	               String[] columns = {"id_Chambre","DateE","DateS","Prix"};

	       //****Affichage des données lignes de la table contenu dans la jTable**********************************
	               DefaultTableModel tableModel = new DefaultTableModel(t, columns);
	               JTable table = new JTable(tableModel);
	               table.setBackground(new Color(176,196,222));
	               
	               //configuration de la jTable
	               voirtable.setSize(600, 200);
	               voirtable.add(new JScrollPane(table));
	               frame.dispose();
	             //ICON
				   voirtable.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\YAY.PNG"));
	               voirtable.setVisible(true);
	               voirtable.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
	               DB.conn.close();
	             //ACCEDER AU FORM
				        Reserver reservation= new Reserver();
					     reservation.NewScreen();}
	              
	               else {
						 JOptionPane.showMessageDialog(null, "Aucune chambre est diponible avec ses critères!");
						 
					 }

					 }catch(Exception e) {
						 e.printStackTrace();
					 }
				
				}
			}});
}
}


