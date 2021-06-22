/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import GUI.JFrameLogin;
import Server.SolicitudesServidor;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAST_
 */
public class clienteEjecucion implements Serializable, Runnable{
    static int contador = 0;
     JFrameLogin JL =new JFrameLogin();
    public void correr() throws InterruptedException {
            

    }
    public void aumentarContador(){
        clienteEjecucion.contador++;
    }
    public static void main(String []as){
        clienteEjecucion CE = new clienteEjecucion();
        clienteEjecucion CE1 = new clienteEjecucion();
        CE.run();
        CE1.run();
    }

    @Override
    public void run(){
    SolicitudesServidor objRemoto;     
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            // CREAR LA REFERENCIA AL OBJ REMOTO
            objRemoto = (SolicitudesServidor)reg.lookup("token"); 
            
            this.JL.setVisible(true);
           synchronized(this){        
            try{
            aumentarContador();
            System.out.println(clienteEjecucion.contador);
            if(clienteEjecucion.contador>1){ 
            wait();
            }
            
            }catch(InterruptedException e){
                
            }
            
            while(this.JL.ocupado){
                Thread.sleep(1000);
                
            }
            notifyAll();
            
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException ex) {
            ex.printStackTrace();

        }catch(InterruptedException e){
            
        }
    }
}
