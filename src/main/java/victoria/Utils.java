/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victoria;

import java.util.ArrayList;

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
    public static boolean contieneEmpleados(ArrayList<Pojo> lista, String nombre) {
        //por defecto no va a estar el empleado
        boolean contiene = false;

        //se recorre la lista
        for (Pojo p : lista) {
            //accedemos con contains para mirar si esta o no el empleado.
            if (p.getNombre().contains(nombre)) {
                contiene = true;
            }
        }

        return contiene;

    }

    /*MÉTODO 2
    A partir de una lista de empleados y un nombre de departamento, indique 
    el número de empleados Coordinadores de ese departamento.
     */
    public static int numEmpleDeptos(ArrayList<Pojo> lista, String depto) {
        int cont = 0;

        for (Pojo p : lista) {
            //si coincide con el nombre del depto que se sume
            if (p.getPuesto().equalsIgnoreCase(depto)) {
                cont++;

            }
        }
        return cont;
    }
    
    
    /*MÉTODO 3
    A partir de una lista de empleados y una letra del NIF (char), obtener 
    una nueva lista ordenada alfabéticamente SOLO con los apellidos de los 
    empleados cuyo NIF contenga esa letra.
    */
    //no sale el método
//    public static ArrayList<String>listaNifOrdenada(ArrayList<Pojo> lista, char letra){
//    //creo lista que vamos a devolver
//     ArrayList<String> listaNIF = new ArrayList<>();
//     
//     //uso foreach para recorrer la lista ojo
//        for (Pojo p : lista) {
//            //con constains miro si tiene ese valor en la cadena con value
//            if(p.getDni().contain())
//        }
//     
//         
//        return listaNIF;
//    }
    
    

}