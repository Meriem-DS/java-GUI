package Acceuil;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class Facturer implements ActionListener{

	 private static JLabel client;
	 private static JTextField t1;
	 private static JButton button,button2;
	
	public void NewScreen() {
		 


			JPanel panel=new JPanel();
		    JFrame frame=new JFrame("DEMANDE D'UNE FACTURE");
			frame.setSize(400,400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//ICON
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\YAY.PNG"));
			frame.add(panel);
			panel.setLayout(null);
			
			//TITLE
			JLabel title=new JLabel("FACTURE");
			title.setBounds(100,2,200,100);
			title.setForeground(new Color(255, 255, 255));
			title.setFont(new Font("Lucida Handwriting", Font.BOLD, 30));
			panel.add(title);
	
	
	//Nom du client (un seul client peut reserver plusieurs chambres à la fois)
			client=new JLabel("CLIENT");
			client.setBounds(10,100,100,25);
			client.setFont(new Font("Lucida Handwriting", Font.BOLD,12));
			panel.add(client);
			//Bar de Texte
			t1= new JTextField(20);
		    t1.setBounds(60,100,300,25);
		    t1.setBackground(new Color(255, 255, 204));
		    panel.add(t1);	
		    
    //Button
		    button=new JButton("Sa Facture");
			button.setBounds(200,170,165,30);
			button.setBackground(new Color(102,205,170));
			button.addActionListener(new Facturer());
			panel.add(button);
	//Button2 :Pour retourner à l'acceuil 
		    button2=new JButton("ACCEUIL");
			button2.setBounds(22,170,165,30);
			button2.setBackground(new Color(102,205,170));
			panel.add(button2);
			button2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent arg) {
					Options retourner=new Options();
					retourner.NewScreen();
					frame.dispose();
				}
					
				});
      //IMAGE
			 JLabel load = new JLabel("");
			load.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\facture.jpg"));
			load.setBounds(0, 0,400,400);
			panel.add(load);
			
      //Visualiser
			frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String  c1=t1.getText();
		
		if (c1.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Remplir la case!");
		}
		else {
			//Connecter à la BD 
			DB connecter=new DB();
			connecter.getConnection();
			PreparedStatement pst;
			ResultSet rs;
			
			 try {
				 pst=DB.conn.prepareStatement("Select client, SUM(Prix_Total) from réservation where client=?");
				 pst.setString(1, t1.getText());
				 rs= pst.executeQuery();
				 //
				 
				   int i = 0; //variable pour l'incrémentation de while
                   int k = 0;// variable utiliser pour obtenir le nombre de rangées

                 if(rs.next()){ //passe le curseur à l'élément suivant ;
	                    rs.first();    //passe le curseur sur le premier élément
	                    rs.last(); //last : passe le curseur sur le dernier élément ;
	                    k = rs.getRow(); //résultat.pour obtenir le nombre de rangées de la table
	                    rs.beforeFirst(); // passe le curseur avant le premier élément (position par défaut du curseur) ;
	                }
                 
   			    
                Object[][] t = new Object[k][2]; //déclaration d'un tableau Object double

                //on met le resultat de la requete dans un tableau
                //la boucle ci-dessous affiche les données de 2colonnes (j'en ai  2)
                //si je supprime une ligne de cette boucle j'obtiens un NULL sur une donnée de la colonne concernée.
                while (rs.next()){
                    t[i][0]=rs.getString(1);  //résultat.obtenir un Srring
                    t[i][1]=rs.getInt(2); //résultat.obtenir un int
                    i++;
                }
                
                
                JFrame voirtable = new JFrame( "Facture de notre Client " );


        //Affichage des colonnes table dans la jTable**********************************
               String[] columns = {"Client","Prix_Total"};

       //****Affichage des données lignes de la table contenu dans la jTable**********************************
               DefaultTableModel tableModel = new DefaultTableModel(t, columns);
               JTable table = new JTable(tableModel);
               table.setBackground(new Color(176,196,222));
               
            //SI LE NOM EST INTROUVABLE DANS LA BASE DE donnée
               if(t[0][1].equals(0)) {
            	   JOptionPane.showMessageDialog(null, "Le nom inséré est incorrecte"); 
               }
               else {

           //configuration de la jTable
               voirtable.setSize(600, 200);
               voirtable.add(new JScrollPane(table));
               voirtable.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\YAY.PNG"));
               voirtable.setVisible(true);
               voirtable.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
               DB.conn.close();}
				 
                
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		
	}
  }
}
