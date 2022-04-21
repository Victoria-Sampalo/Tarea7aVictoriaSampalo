/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package victoria;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author victoria
 */
public class Main7a {

    public static void main(String[] args) {
        // Fichero a leer
        String idFichero = "RelPerCen.csv";
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        int contador= 0;
        
        //creo lista donde guardare los datos
        
        ArrayList<Pojo> lista = new ArrayList<>();

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero))) {
            //salto linea 
            datosFichero.nextLine();
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(",");
                
                //instancio objeto pojo donde guardarlo dentro
                Pojo p1 = new Pojo();
                
                p1.setNombre(linea);
                /*
                https://es.stackoverflow.com/questions/454320/eliminar-comillas-de-un-string-java#:~:text=Prueba%20con%20estas%20dos%20sentencias,al%20inicio%20y%20al%20final.
                */
                

            }
            System.out.println();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
