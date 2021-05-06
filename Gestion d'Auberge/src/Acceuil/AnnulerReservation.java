package Acceuil;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AnnulerReservation implements ActionListener {
	
	 private static JLabel id,client;
	 private static JTextField t1,t2;
	 private static JButton button,button2;
	 
	public  void NewScreen() {
		

		JPanel panel=new JPanel();
	    JFrame frame=new JFrame("Annuler une R�servation");
		frame.setSize(500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ICON
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\YAY.PNG"));
		frame.add(panel);
		panel.setLayout(null);
		
		//Annuler  par:
		
		//ID du chambre
		id=new JLabel("ID_ROOM");
		id.setBounds(10,160,80,25);
		id.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
		id.setForeground(new Color(255, 255, 255));
		panel.add(id);
		//Bar de Texte
		t1= new JTextField(20);
		t1.setBounds(100,160,250,25);
		t1.setBackground(new Color(255, 248, 220));
		panel.add(t1);
		
		//Nom du client
		client=new JLabel("CLIENT");
		client.setBounds(10,200,80,25);
		client.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
		client.setForeground(new Color(255, 255, 255));
		panel.add(client);
		//Bar de Texte
		t2= new JTextField(20);
	    t2.setBounds(100,200,250,25);
	    t2.setBackground(new Color(255, 248, 220));
	    panel.add(t2);
	    
	  //Button
	    button=new JButton("ANNULER ");
		button.setBounds(150,240,100,29);
		button.addActionListener(new AnnulerReservation());
		button.setBackground(new Color(255, 255, 204));
		panel.add(button);
		
	//Button2 :Pour retourner � l'acceuil 
	    button2=new JButton("ACCEUIL");
		button2.setBounds(20,240,100,29);
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
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\annuler.jpg"));
		lblNewLabel.setBounds(0, 0,600,400);
		panel.add(lblNewLabel);
		
		
	//Visualiser
		frame.setVisible(true);
		
		
		
		
		
		
}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String case1=t1.getText();
		String case2=t2.getText();
		if (!(case1.isEmpty()) && !(case2.isEmpty())) {
			// se connecter � la base de donn�e en supprimant delete where id = x or client=y
			DB connecter=new DB();
			connecter.getConnection();
			java.sql.Statement st;
			PreparedStatement pst;
			ResultSet rs;
			
			 try {
				 pst=DB.conn.prepareStatement("Select id , client from r�servation where id=? and client=?");
				 pst.setString(1, case1);
				 pst.setString(2, case2);
				 rs= pst.executeQuery();
				 //executer 
				 if(rs.next()) {
					 String sql="Delete From  R�servation where id='"+t1.getText()+"' and client='"+t2.getText()+"'";
					 st = DB.conn.createStatement();
					 st.executeUpdate(sql);
					 JOptionPane.showMessageDialog(null, "La r�servation a �t�  annull�e");
					 DB.conn.close();}
				 else {
					 JOptionPane.showMessageDialog(null, "Les donn�es ins�r�es sont incorrectes!");
				 }
			 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		
		
		
		}
		else
			JOptionPane.showMessageDialog(null, "Remplir toute les cases!");
		
	}
}