/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chelo
 */
public class CuentaDAO {

    Conexion con;
    public CuentaDAO() {
        con = new Conexion();
    }
    

    public Cuenta getCuentaByID(int idCuenta) {
        
        Connection accesoBD = con.getConexion();
        Credencial cred=null;
        Cuenta c = null;
        try{
            String sql="SELECT * FROM cuenta WHERE idcuenta='"+idCuenta+"'";
            //ejemplo: SELECT * FROM Customers WHERE Country='Mexico'; 
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
            while ( resultados.next() ) {
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                String mail = resultados.getString("email");
                
                //Preparo segunda SQL
                String sql2="SELECT * FROM credencial WHERE idcuenta='"+idCuenta+"'";
              
                //System.out.println(sql);
                Statement st2 = accesoBD.createStatement();
                ResultSet resultados2 = st2.executeQuery(sql);
                
                while (resultados2.next()) {
                    String user = resultados.getString("nombre");
                    String pass = resultados.getString("apellido");
                    cred= new Credencial(user, pass,idCuenta);
                }
                //Una vez que tengo la cred y los datos de la cuenta puedo crear una cuenta
                c = new Cuenta(cred,nombre, apellido, mail);
                
            }
            accesoBD.close();
            return c;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
    }
    
}
