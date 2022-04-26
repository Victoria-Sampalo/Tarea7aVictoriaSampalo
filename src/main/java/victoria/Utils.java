/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author victoria Sube el proyecto de la tarea 7A que implementa los
 * ejercicios propuestos. Además incluye una clase, llamada Utils, con los
 * siguientes métodos de clase: A partir de una lista de empleados y un nombre,
 * indique si hay algún empleado con ese nombre. A partir de una lista de
 * empleados y un nombre de departamento, indique el número de empleados
 * Coordinadores de ese departamento. A partir de una lista de empleados y una
 * letra del NIF (char), obtener una nueva lista ordenada alfabéticamente SOLO
 * con los apellidos de los empleados cuyo NIF contenga esa letra. A partir de
 * una lista de empleados y una fecha, obtener una nueva lista con los NIF
 * (ordenados de forma inversa) de todos los empleados cuya toma de posesión
 * coincida con esa fecha.
 */
public class Utils {

    /*MÉTODO 1
    A partir de una lista de empleados y un nombre, indique si hay algún empleado 
   con ese nombre.*/
    public static boolean contieneEmpleados(ArrayList<Profesor> lista, String nombre) {
        //por defecto no va a estar el empleado
        boolean contiene = false;

        //se recorre la lista
        for (Profesor p : lista) {
            //accedemos con contains para mirar si esta o no el empleado.
            if (p.getNombre().contains(nombre)) {
                //nota: se ha provado con .equalsIgnoreCase(nombre) y no funciona
                contiene = true;
            }
        }

        return contiene;

    }
    public static boolean contieneEmpleados(ArrayList<Profesor> lista, String nombre) {
        //por defecto no va a estar el empleado
        boolean contiene = false;

        //se recorre la lista
        for (Profesor p : lista) {
            //accedemos con contains para mirar si esta o no el empleado.
            if (p.getNombre().contains(nombre)) {
                //nota: se ha provado con .equalsIgnoreCase(nombre) y no funciona
                contiene = true;
            }
        }

        return contiene;

    }

    /*MÉTODO 2
    A partir de una lista de empleados y un nombre de departamento, indique 
    el número de empleados Coordinadores de ese departamento.
     */
//    public static int numEmpleDeptosJesus(ArrayList<Profesor> lista, String depto) {
//        
//        for (int i = 0; i < lista.size(); i++) {
//            
//        }
//        
//        
//        return false; 
//    }

    /*MÉTODO 3
    A partir de una lista de empleados y una letra del NIF (char), obtener 
    una nueva lista ordenada alfabéticamente SOLO con los apellidos de los 
    empleados cuyo NIF contenga esa letra.
     */
    //no sale el método
    public static ArrayList<String> listaNifOrdenada(ArrayList<Profesor> lista, char letra) {
        //creo lista que vamos a devolver
        ArrayList<String> listaNIF = new ArrayList<>();

        //uso foreach para recorrer la lista ojo
        for (Profesor p : lista) {
            //con constains miro si tiene ese valor en la cadena con value
            if (p.getDni().charAt(p.getDni().length() - 1) == letra) {
                listaNIF.add(p.getNombre() + ", dni " + p.getDni());
            }
        }

        return listaNIF;
    }

    /*MÉTODO 4
    A partir de una lista de empleados y una fecha, obtener una nueva lista con 
    los NIF (ordenados de forma inversa) de todos los empleados cuya toma de 
    posesión coincida con esa fecha.*/
    public static ArrayList<String> listaNifFechaIni(ArrayList<Profesor> lista, LocalDate fecha) {
        //creo lista que vamos a devolver
        ArrayList<String> listaPosesion = new ArrayList<>();
        for (Profesor p : lista) {
            //recorro el array y si es la misma fecha lo añado a la lista
            if (p.getFecIni().isEqual(fecha)) {
                listaPosesion.add(p.getDni());

            }
        }
        //ordenar de forma alfabética inversa
        Collections.reverse(listaPosesion);
        return listaPosesion;
    }

}
