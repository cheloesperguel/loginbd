/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.VentanaLogin;
import modelo.Credencial;
import modelo.CredencialDAO;
import modelo.Cuenta;
import modelo.CuentaDAO;
import vista.VentanaInfo;
/**
 *
 * @author chelo
 */
public class LoginController implements ActionListener{
    
    
    private VentanaLogin vLogin;

    public LoginController(VentanaLogin vLogin) {
        this.vLogin = vLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("ingresar")){
            String user= vLogin.tfUser.getText();
            String pass= vLogin.tfPass.getText();

            Credencial newCred = new Credencial(user, pass);
            
            CredencialDAO c = new CredencialDAO(); // Creo el objeto para acceder a la BD

            ArrayList<Credencial> listaDeCred= c.getCredenciales(); // Creo lista y llamo al metodo getCredenciales del DAO
            
             boolean flag=false;
            for(int i=0; i<listaDeCred.size();i++){ // Recorro los resultados
                
                if(listaDeCred.get(i).getUsuario().equals(newCred.getUsuario())){ //Match en usuario
                    System.out.println("Usuario encontrado");
                    
                    if(listaDeCred.get(i).getPass().equals(newCred.getPass())){ //Match en pass
                        System.out.println("Password correcto");
                        VentanaInfo vInfo = new VentanaInfo();
                        
                        CuentaDAO cuentadao= new CuentaDAO();
                        Cuenta cuenta = cuentadao.getCuentaByID(listaDeCred.get(i).getIdCuenta());
                        
                        vInfo.nombreLabelValue.setText(cuenta.getNombre());
                        vInfo.apellidoLabelValue.setText(cuenta.getApellido());
                        vInfo.correoLabelValue.setText(cuenta.getEmail());
                        
                        vInfo.setVisible(true);
                        JOptionPane.showMessageDialog(vInfo, "Login Exitoso");
                        vLogin.dispose();
                        flag=true; 
                    }
                }
            }
            
            if(!flag){
                JOptionPane.showMessageDialog(vLogin, "USer o Pass incorrectos");
            }
        }
        
    }
    
    
    
    
    
    
}
