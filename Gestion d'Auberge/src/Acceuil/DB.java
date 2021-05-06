package Acceuil;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;


public class DB {    
	//Confirmation d'accés à la base de données
	static String url="jdbc:mysql://localhost/auberge";
	static String login="root";
	static String psswd="";
    static Connection conn=null;
    Statement st=null;

public  Connection getConnection(){
        try{
        	
        	//ETAPE1:Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //ETAPE2: Récuperation de la connexion
            conn=DriverManager.getConnection(url,login,psswd);
            
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, "Vous n'etes pas connecter à la Base de Donnée");
        }

        return conn;        
    }

}
