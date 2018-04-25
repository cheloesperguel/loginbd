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
public class Cuenta {
    
    private Credencial cred;
    private String nombre;
    private String apellido;
    private String  email;
    
    

    public Cuenta(Credencial cred, String nombre, String apellido, String email) {
        this.cred = cred;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    
    public Credencial getCred() {
        return cred;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getApellido() {
        return apellido;
    }
    
    
    
}
