/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author LAST_
 * El servidor RMI implementado con hilos
 */
public class ServidorRMI implements Runnable{
    
    public static void main(String[] args){
        (new Thread(new ServidorRMI())).start();
    }
    
    @Override
    public void run() {
        try {
            ObjetoRemoto obj = new ObjetoRemoto();
            // hacer registro del obj remoto
            Registry reg = LocateRegistry.createRegistry(1099);
            // refencia al objeto remoto
            reg.rebind("token", obj);
            System.out.println("servidor activo...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
