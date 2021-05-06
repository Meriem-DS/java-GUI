package Acceuil;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.placeholder.PlaceHolder;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class Login  implements ActionListener{
		
		public ResultSet rs=null;
		private static JLabel userLabel;
		private static JLabel passwordLabel;
		private static  JTextField userText;
		private static JPasswordField passText;
		private static JButton btnLogin;
		private static JFrame frame;
		private static JPanel panel;
		private static JLabel lblNewLabel;
		static PlaceHolder p1;
			
public static void main(String[] args) {
			panel=new JPanel();
			panel.setBackground(new Color(25, 25, 112));
		    frame=new JFrame("LOGIN ");
		    frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\YAY.PNG"));
			frame.setSize(433,428);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(panel);
			
				
			//label username
			userLabel=new JLabel("UserName");
			userLabel.setBackground(new Color(0, 0, 0));
			userLabel.setForeground(new Color(255, 255, 255));
			userLabel.setFont(new Font("Century Gothic", Font.BOLD, 13));
			//texte bar for username
			userText= new JTextField(20);
			userText.setToolTipText("");
				
			//label password
			passwordLabel=new JLabel("Password");
			passwordLabel.setForeground(new Color(255, 255, 255));
			passwordLabel.setFont(new Font("Century Gothic", Font.BOLD, 13));
			passwordLabel.setBackground(new Color(0, 0, 0));
			//texte bar specially for password
			passText= new JPasswordField(20);
			passText.setBackground(Color.WHITE);
			
			//PLACEHOLDER
			p1=new PlaceHolder(userText,"Entrer Votre Nom");
			
			//Button
			btnLogin=new JButton("LOGIN");
			btnLogin.setFont(new Font("Arial", Font.BOLD, 12));
			btnLogin.setBackground(new Color(224, 255, 255));
			btnLogin.addActionListener(new Login());
			
			//IMAGE
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\Gestion d'Auberge\\image\\IMG1.PNG"));
			
			//Auto-Resize Components
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(10)
						.addComponent(userLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(userText, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
						.addGap(100))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(10)
						.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(passText, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
						.addGap(100))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(148)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addGap(158))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addGap(23)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(2)
								.addComponent(userLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addComponent(userText, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(2)
								.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addComponent(passText, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(23)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
			);
			panel.setLayout(gl_panel);
				
			//Visualiser notre code	
			frame.setVisible(true);	
}
			
			

		
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent a) {
			String user =userText.getText();
	        String passWord = passText.getText();
			if(user.isEmpty() || passWord.isEmpty()) {
				 JOptionPane.showMessageDialog(null, "Remplir toutes les cases!");
			}else {
				DB connecter=new DB();
				connecter.getConnection();
				 PreparedStatement pst;
				 try {
				 pst=DB.conn.prepareStatement("Select*from login where UserName=? and Password=?");
				 pst.setString(1, user);
				 pst.setString(2, passWord);
				 rs= pst.executeQuery();
				 //executer 
				 if(rs.next()) {
					 DB.conn.close();
					 Options seConnecter= new Options();
					  seConnecter.NewScreen();
					  //FERMER FENETRE LOGIN
					  frame.dispose();
				 }else {
					 JOptionPane.showMessageDialog(null, "Incorrect UserName Or Password!");
				 }
				 }catch(Exception e) {
					 //Error au niveau de connexion à la BD
				 }
				 
		}
			
	}
}



