/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import GUI.JFrameLogin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Cliente.*;
import Server.ServidorRMI;

/**
 *
 * @author LAST_
 * En esta clase se realiza la corrida del cliente
 */
public class prueba {

    public static void main(String[] as) {
        JFrameLogin l = new JFrameLogin();
        l.setVisible(true);
    }
}
