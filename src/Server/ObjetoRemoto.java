/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Cliente.Usuario;
import Util.Tokenizador;
import static Util.Tokenizador.leerDatos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author LAST_
 * En esta clase estan definidos todos los metodos remotos
 */
public class ObjetoRemoto extends UnicastRemoteObject implements SolicitudesServidor {

    ArrayList<Usuario> users = new ArrayList<>();

    //Constructor
    public ObjetoRemoto() throws RemoteException {
        super();
        leer();
    }
    
    public void leer() throws RemoteException{
        try {
            users.clear();
            //Leer el registro
            ArrayList<String[]> regs = leerDatos();
            // id   user   pass   name   lname  cash
            // [0]   [1]    [2]    [3]    [4]    [5]

            //Rellenar la lista de 
            for (int i = 0; i < regs.size(); i++) {
                String[] u = regs.get(i);
                users.add(new Usuario(Integer.parseInt(u[0]), u[3], u[4], Float.parseFloat(u[5]), u[1], u[2]));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean darAcceso(String usuario, String contrasena) throws RemoteException {
        leer();
        boolean acceso = false;
        try {
            boolean validacionUsuario = false;
            boolean validacionContrasena = false;

            int cnt = 0;
            //Validamos al usuario
            while ((!validacionUsuario) && (cnt < users.size())) {
                if (users.get(cnt).getNombre_usuario().equals(usuario)) {
                    validacionUsuario = true;
                } else {
                    cnt += 1;
                }
            }

            System.out.println(validacionUsuario);

            //Si el usuario es valido, validamos la contraseña
            if (validacionUsuario) {
                if (users.get(cnt).getContra().equals(contrasena)) {
                    validacionContrasena = true;
                }
            }

            //Si ambos son validos, damos acceso
            if (validacionContrasena && validacionUsuario) {
                acceso = true;
            } else {
                acceso = false;
            }

        } catch (Exception e) {

        }

        return acceso;
    }

    public Usuario buscarUsuario(String nombre, String contrasena) throws RemoteException {
        Usuario u = null;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).nombre_usuario.compareTo(nombre) == 0 && users.get(i).contra.compareTo(contrasena) == 0) {
                u = users.get(i);
            }
        }
        return u;
    }

    public String retirarDinero(float cantidad, Usuario u) throws RemoteException {
        String retiro = null;
        leer();
        try {
            //Si se tiene mas dinero que el supuesto retiro
            Usuario a = new Usuario(u);
            int cant = (int) cantidad;
            int dine = (int) users.get(a.getID()-1).getDinero();
            System.out.println("Cantidad: "+cant);
            System.out.println("Dinero antes: "+users.get(a.getID()-1).getDinero());
            if (dine >= cant) {
                float total = users.get(a.getID()-1).getDinero()-cantidad;
                users.get(a.getID()-1).setDinero(total);
                System.out.println("Dinero despues: "+users.get(a.getID()-1).getDinero());
                Tokenizador.actualizar(users);
                retiro = "La transaccion ha sido exitosa, su saldo actual es de: " + users.get(u.getID() - 1).getDinero();
            } else {
                retiro = "Lo sentimos, no cuenta con el dinero para esa transaccion";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return retiro;
        }
    }

    public String depositarDinero(float cantidad, Usuario u) throws RemoteException {
        leer();
        String retiro = null;
        try {
//            Usuario a = new Usuario(u);
            Usuario a = new Usuario(u.getID(),u.getNombre(),u.getApellido(),u.getDinero(),u.getNombre_usuario(),u.getContra());
            System.out.println("Cantidad: "+cantidad);
            System.out.println("Dinero antes: "+users.get(a.getID()-1).getDinero());
            float total = cantidad + users.get(a.getID()-1).getDinero();
//            a.setDinero(a.getDinero() + cantidad);
            users.get(a.getID()-1).setDinero(total);
            System.out.println("Dinero despues: "+users.get(a.getID()-1).getDinero());
            Tokenizador.actualizar(users);
            
            retiro = "La transaccion ha sido exitosa, su saldo actual es de: " + users.get(u.getID() - 1).getDinero();

        } catch (Exception e) {
            retiro = "La transaccion ha sido rechazada";
            e.printStackTrace();
        } finally {
            return retiro;
        }
    }

    public String getNombre(int ID) throws RemoteException {
        return this.users.get(ID-1).nombre;
    }

    public String getApellido(int ID) throws RemoteException {

        return this.users.get(ID-1).apellido;
    }

    public float getDinero(int ID) throws RemoteException {

        return this.users.get(ID-1).dinero;
    }

    public String getNombre_usuario(int ID) throws RemoteException {

        return this.users.get(ID-1).nombre_usuario;
    }

    public int getID(int ID) throws RemoteException {
        return ID;
    }

    public String getContra(int ID) throws RemoteException {
        return this.users.get(ID-1).contra;
    }

    public static void main(String ag[]) {
        try {
            ObjetoRemoto or = new ObjetoRemoto();
            Usuario u = new Usuario(1, "nombre", "apellido", (float) 500.0, "admin", "admin");
            System.out.println("Acceso: " + or.darAcceso("admin", "admn"));
            System.out.println("Retiro: " + or.retirarDinero(50, u));
//            System.out.println("Deposito: " + or.depositarDinero(6, u));
        } catch (Exception e) {

        }

    }

}
