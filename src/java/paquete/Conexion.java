/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author i14i34500w10
 */
public class Conexion {
    public Connection conexionBD;
    public final String db = "db_empresa";
    public final String urlconexion = String.format("jdbc:mysql://localhost:3306/%s?useTimezone=true&serverTimezone=UTC", db) ;
    public final String usuario ="usr_empresa";
    public final String  contra = "123456";    
    public final String  jdbc = "com.mysql.cj.jdbc.Driver";
  
    public void abrir_conexion(){
    
    try{
    
        Class.forName(jdbc);
    conexionBD = DriverManager.getConnection(urlconexion,usuario,contra);
  //JOptionPane.showMessageDialog(null,"Conexion exitosa.... "  ,"Exito ",JOptionPane.INFORMATION_MESSAGE);
    }catch(HeadlessException | ClassNotFoundException | SQLException ex){
    System.out.println("Error!!" + ex.getMessage());
    
    }  
    }
    public void cerrar_conexion(){
    try{
    
     conexionBD.close();
    
    }catch(SQLException ex){
    System.out.println("Error!!" + ex.getMessage());
    }
    }
    
    
}


 

