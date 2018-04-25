/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author chelo
 */
public class Credencial {
    
    private String usuario;
    private String pass;
    private int idCuenta;

    public Credencial(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }
    
    

    public Credencial(String usuario, String pass, int idCuenta) {
        this.usuario = usuario;
        this.pass = pass;
        this.idCuenta=idCuenta;
    }

    public String getPass() {
        return pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getIdCuenta() {
        return idCuenta;
    }
    
    
    
    
}
