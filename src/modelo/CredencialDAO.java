/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chelo
 */
public class CredencialDAO {
    
    Conexion con;

    public CredencialDAO() {
        this.con = new Conexion();
    }
    
    public ArrayList<Credencial> getCredenciales(){
        
        ArrayList<Credencial> credenciales = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM credencial ";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                String user = resultados.getString("usuario");
                String pass = resultados.getString("pass");
                int idCuenta = Integer.parseInt(resultados.getString("idcuenta"));
                credenciales.add(new Credencial(user, pass,idCuenta));
            }
            accesoBD.close();
            return credenciales;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
    }
}
