package Util;

import Cliente.Usuario;
import Server.ObjetoRemoto;
import Server.SolicitudesServidor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author DKghost
 * En esta clase se realiza la lectura de los datos y la actualizacion del registro
 */
public class Tokenizador {

    public static ArrayList<String[]> registros;

    public static ArrayList<String[]> leerDatos() {
        registros = new ArrayList<>();
        String texto, aux;
        LinkedList<String> lista = new LinkedList();

        try {
            //llamamos el metodo que permite cargar la ventana       
            String directorio = new File("").getAbsolutePath();
            directorio += "\\";
            File file = new File(directorio + "registro.txt");
            File abre = file;

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();

                ArrayList<String> lista2 = new ArrayList<>();

                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    String[] vector = new String[lista2.size()];

                    for (int x = 0; x < lista2.size(); x++) {
                        vector[x] = lista2.get(x);
                    }

                    registros.add(vector);
                    lista2.clear();
                }

            }
            return registros;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);

        }
        return null;
    }
    
    
    public static void actualizar( ArrayList<Usuario> users) {
        try {
            FileWriter pw = new FileWriter((System.getProperty("user.dir") + "//registro.txt"));
            Usuario u;
            for (int i = 0; i < users.size(); i++) {
                u = users.get(i);
                pw.write(String.valueOf(u.getID()));
                pw.write(","+u.getNombre_usuario());
                pw.write(","+u.getContra());
                pw.write(","+u.getNombre());
                pw.write(","+u.getApellido());
                pw.write(","+String.valueOf(u.getDinero())+"\n");
            }
            pw.close();
        } catch (Exception e) {

        }
    }
    
    public static void main(String ags[]){
        ArrayList<String[]> lista = leerDatos();
        
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(i).length; j++) {
                System.out.print(lista.get(i)[j]+" ");
            }
            System.out.println("");
        }
    }

}
