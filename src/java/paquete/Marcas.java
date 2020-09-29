/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
/**
 *
 * @author i14i34500w10
 */
public class Marcas {
    private int id_marca;
 
    
    public Marcas(){} 
    public Marcas(int id_marca) {
        this.id_marca = id_marca;
      
    }
    Conexion conexion;

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

  
    
   
     public HashMap Mostrar_marca(){
    
    HashMap<String,String> drop = new HashMap();
    try{
    conexion = new Conexion();
    String codigoquery = "select id_Marca as id,Marca from marca;";
   
    conexion.abrir_conexion();
    ResultSet consultar = conexion.conexionBD.createStatement().executeQuery(codigoquery);
    while(consultar.next()){
    drop.put(consultar.getString("id"),consultar.getString("Marca"));
    }
    
    conexion.cerrar_conexion();
    
    
    }catch(SQLException ex){}
    
    return drop;
    }
    
public int agregar(){return 0;}
public int modificar(){return 0;}
public int eliminar(){return 0;}
     
     
}
