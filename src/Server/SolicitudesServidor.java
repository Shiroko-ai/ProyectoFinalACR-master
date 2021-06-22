/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import java.rmi.Remote;
import java.rmi.RemoteException;
import Cliente.Usuario;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author LAST_
 * Esta es la interfaz del desrvidor
 */
public interface SolicitudesServidor extends Remote{
    ArrayList<Usuario> users = new ArrayList<>();
    public void leer() throws RemoteException;
    public boolean darAcceso(String usuario,String contrasena) throws RemoteException;
    public String retirarDinero(float cantidad, Usuario u) throws RemoteException;
    public String depositarDinero(float cantidad, Usuario u) throws RemoteException;
    public Usuario buscarUsuario(String nombre, String contrasena) throws RemoteException;
    public String getNombre(int ID) throws RemoteException; 
    public String getApellido(int ID) throws RemoteException;
    public float getDinero(int ID) throws RemoteException;
    public String getNombre_usuario(int ID) throws RemoteException;
    public int getID(int ID) throws RemoteException; 
    public String getContra(int ID) throws RemoteException;
}
