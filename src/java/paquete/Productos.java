/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author i14i34500w10
 */
public class Productos extends Marcas{
    private int id_producto;
    private String producto,descripcion;
    private int existencia;
    private float precio_costo,precio_venta;
     
    
    public Productos(){}
    public Productos(int id_producto, String producto, String descripcion, int existencia, float precio_costo, float precio_venta, int id_marca) {
        super(id_marca);
        this.id_producto = id_producto;
        this.producto = producto;
        this.descripcion = descripcion;
        this.existencia = existencia;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
    }
 
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public float getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(float precio_costo) {
        this.precio_costo = precio_costo;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    
    @Override
    public int agregar(){
    int retornar=0;
    try{
        PreparedStatement parametros;
       conexion = new Conexion();
      String codigo_query="insert into productos (Producto,id_Marca,Descripcion,Precio_costo,Precio_venta,Existencia) values (?,?,?,?,?,?);"; 
      conexion.abrir_conexion();
        
        parametros=(PreparedStatement)conexion.conexionBD.prepareStatement(codigo_query);
        
        parametros.setString(1, getProducto());
        parametros.setInt(2, getId_marca());
        parametros.setString(3, getDescripcion());
        parametros.setFloat(4, getPrecio_costo());
        parametros.setFloat(5, getPrecio_venta());
        parametros.setInt(6, getExistencia());
        
        retornar = parametros.executeUpdate();
        conexion.cerrar_conexion();
    }catch(SQLException ex){
       System.out.println(ex.getMessage());
      return retornar = 0;
   
    }
    
    
    return retornar;
    }
      
    @Override
    public int modificar(){
    int retorno =0;
    try{
           PreparedStatement parametros;
       conexion = new Conexion();
      String codigo_query="update productos set  Producto=? , id_Marca=? , Descripcion=?, Precio_costo=?, Precio_venta=?, Existencia=? where id_producto=?;"; 
        conexion.abrir_conexion();
        
        parametros=(PreparedStatement)conexion.conexionBD.prepareStatement(codigo_query);
        
         parametros.setString(1, getProducto());
        parametros.setInt(2, getId_marca());
        parametros.setString(3, getDescripcion());
        parametros.setFloat(4, getPrecio_costo());
        parametros.setFloat(5, getPrecio_venta());
        parametros.setInt(6, getExistencia());
        parametros.setInt(7, getId_producto());
     
        
        retorno = parametros.executeUpdate();
        conexion.cerrar_conexion();
    
    }catch(SQLException ex){
      System.out.println(ex.getMessage());
      return retorno = 0;
    
    
    }
    
    return retorno;
    }
    @Override
        public int eliminar(){
    int retorno=0;
        try{
           PreparedStatement parametros;
       conexion = new Conexion();
      String codigo_query="DELETE FROM  productos  WHERE id_producto=?;"; 
        conexion.abrir_conexion();
        
        parametros=(PreparedStatement)conexion.conexionBD.prepareStatement(codigo_query);
         
        parametros.setInt(1, getId_producto());
        
        retorno = parametros.executeUpdate();
        conexion.cerrar_conexion();
    
    }catch(SQLException ex){
      System.out.println(ex.getMessage());
      return retorno = 0;
    
    }
    
    return retorno;
    }
    public DefaultTableModel mostrar_elementos(){
    
    DefaultTableModel tabla = new DefaultTableModel();
    try{
    conexion = new Conexion();
    conexion.abrir_conexion();
    
    String codigo_query = "select e.id_producto as id,e.producto,t.id_Marca,t.Marca,e.Descripcion,e.Precio_costo,e.Precio_venta,e.Existencia from productos as e inner join marca as t on e.id_Marca = t.id_Marca;";
    ResultSet consulta = conexion.conexionBD.createStatement().executeQuery(codigo_query);
    String encabezado[]= {"Id","Producto","id_Marca","Marca","Descripcion","Precio_costo","Precio_venta","Existencia"};
    tabla.setColumnIdentifiers(encabezado);
    String datos[]=new String[8];
    while(consulta.next()){
    datos[0] = consulta.getString("id");
    datos[1] = consulta.getString("producto");
    datos[2] = consulta.getString("id_Marca");
    datos[3] = consulta.getString("Marca");
    datos[4] = consulta.getString("Descripcion");
    datos[5] = consulta.getString("Precio_costo");
    datos[6] = consulta.getString("Precio_venta");
    datos[7] = consulta.getString("Existencia");
    
   // datos[9] = consulta.getString("id_tipo_sangre");
 
  
    tabla.addRow(datos);
  
    }
    
      conexion.cerrar_conexion();
    
    }catch(SQLException ex){
    
    System.out.println(ex.getMessage());
    
    }
    
    
    
    return tabla;
    } 
    
}
