/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.Serializable;

/**
 *
 * @author LAST_
 */
public class Usuario implements Serializable{
    public String nombre;
    public String apellido;
    public float dinero;
    public String nombre_usuario;
    public int ID;
    public String contra;
    
     public Usuario(Usuario u){
        this.nombre = u.getNombre();
        this.apellido = u.getApellido();
        this.dinero = u.getDinero();
        this.nombre_usuario = u.getNombre_usuario();
        this.ID = u.getID();
        this.contra = u.getContra();
     }
    
    public Usuario(int ID, String nombre, String apellido, float dinero, String nombre_usuario,String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dinero = dinero;
        this.nombre_usuario = nombre_usuario;
        this.ID = ID;
        this.contra= contrasena;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    

    
    
}
