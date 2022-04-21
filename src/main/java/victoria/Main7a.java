/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package victoria;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author victoria
 */
public class Main7a {

    public static void main(String[] args) {
        // Fichero a leer
        String idFichero = "RelPerCen.csv";
        String idFichero2 = "profesoresPorDepartamento.csv";
        String idFichero3 = "profesoresAntiguos.csv";
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        String tmp;
        int contadorProfes = 0;

        //creo lista donde guardare los datos
        ArrayList<Pojo> lista = new ArrayList<>();
        //declaro e inicializo el MAP que luego trataremos
        Map<String, Integer> listaProfes = new HashMap();

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
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

                p1.setNombre(quitarComas(tokens[0] + tokens[1]));
                p1.setDni(quitarComas(tokens[2]));
                p1.setPuesto(quitarComas(tokens[3]));

                /*FECHAS DE INICIO Y DE FIN*/
                //FECHA INICIO. Con los datos de fecha hay  que tratarlos para convertirlos en el tipo que son
                //guardo la posición del token en un string 
                String fecha1 = (quitarComas(tokens[4]));
                //y luego transformo a tipo localDate con .parse y cambio el formato con DateTimeFormatter
                p1.setFecIni(LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                //FECHA FIN. Controlar si es null
                String fecha2 = (quitarComas(tokens[5]));
                int tamanio = fecha2.length();
                if (tamanio > 0) {
                    p1.setFecFin(LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                } else {
                    p1.setFecFin(LocalDate.now());

                }

                p1.setTelf(quitarComas(tokens[6]));

                /*DATOS BOOLEANOS*/
                //con equalsignorecase realizo el simil
                if (quitarComas(tokens[7]).equalsIgnoreCase("SI")) {
                    p1.setEvaluador(true);
                } else {
                    p1.setEvaluador(false);

                }
                if (quitarComas(tokens[8]).equalsIgnoreCase("SI")) {
                    p1.setCoordinador(true);
                } else {
                    p1.setCoordinador(false);

                }

                //una vez acabado agrego todos los tokens a la lista
                lista.add(p1);


                /*
                ccuando tengo una lista cojo departamento y num de profesores*/
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Llegamos aquí el fichero se lee según lo previsto.
        //**********************************************************************
        /**
         * ENUNCIADO[Genera un map para almacenar cuantos profesores hay por
         * cada departamento diferente. Vuelca esta información en otro fichero
         * CSV, llamado "profesoresPorDepartamento.csv", separando los campos
         * con un tabulador.]
         * ********************************************************************
         */
        listaProfes = sacarNumDeptos(lista);

        //ESCRIBO EL ARCHIVO QUE GUARDA EL MAPEO
        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero2))) {
            flujo.write("Depto\t Numero");
            flujo.newLine();

            //foreach que recorra en función de la clave primaria y su valor que son los profes
            for (String key : listaProfes.keySet()) {
                //lo que quiero escribir
                flujo.write(key + " \t " + listaProfes.get(key));
                //siguiente linea
                flujo.newLine();

            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero2 + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //recorro el map y saco el númer 
        int contadorProf = 0;
        System.out.println("\n******************************************");
        System.out.println("\n*********PROFESORES***********************");
        for (Pojo p : lista) {
            System.out.println(p.toString());
            contadorProf++;
        }

        System.out.println("Existen " + contadorProf + " profesores");

        /**
         * Guarda en otro fichero CSV los registros de aquellos empleados que
         * hayan trabajado más de 100 días en el curso 20/21. Ten en cuenta que
         * si la fecha de cese está vacía significa que el empleado está en
         * servicio activo.]
         * ********************************************************************
         */
        //variables localdate a tener 
        LocalDate fecha1 = LocalDate.of(2020, Month.JANUARY, 1);//inicio
        LocalDate fecha2 = LocalDate.of(2021, Month.DECEMBER, 31);//fin

        //usamos de nuevo BufferedWriter
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero3))) {
            flujo.write("Nombre\tDNI\tPasaporte\tPuesto\tFechaInicio\tFechaFin\tTelefono"
                    + "\tEvaluador\tCoordinador");
            flujo.newLine();

            for (Pojo profesor : lista) {
                //if para comprobar si está entre la fecha de inicio y de fin
                if (profesor.getFecIni().isAfter(fecha1)
                        && profesor.getFecFin().isBefore(fecha2)) {

                    if (diasEntreFechas(profesor.getFecIni(), profesor.getFecFin()) > 101) {
                        //si cumple ambas lo escribo
                        flujo.write(profesor.toStringProfesAntiguos());
                        flujo.newLine();

                    }

                }
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("\n");
            System.out.println("Fichero " + idFichero3 + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //método para quitar las comillas del string usando replace
    private static String quitarComas(String texto) {
        String resultado;
        return resultado = texto.replace("\"", "");

    }
    //Fuente:https://parzibyte.me/blog/2018/08/21/remover-comillas-de-cadena-en-java/

    //método quitar las comillas de un string usando substring
    private static String takeoffComillasSubstring(String texto) {
        String resultado;
        return resultado = texto.substring(1, texto.length() - 1);

    }
    //Fuente:https://es.stackoverflow.com/questions/454320/eliminar-comillas-de-un-string-java#:~:text=Prueba%20con%20estas%20dos%20sentencias,al%20inicio%20y%20al%20final.

    /*Método que devuelve un MAP donde cuenta el numeros de 
    profesiones diferentes por asignatura
     */
    private static Map<String, Integer> sacarNumDeptos(ArrayList<Pojo> lista) {
        //declaro e inicializo el map
        Map<String, Integer> listaDeptos = new TreeMap<>();
        //mínimo cuando se encuentra un departamento es porque hay un profe
        int contDepto = 1;

        for (Pojo p : lista) {
            //si es igual que el puesto se suma el contador
            if (listaDeptos.containsKey(p.getPuesto())) {
                contDepto++;

            } else {
                //se queda igual
                contDepto = 1;
                listaDeptos.put(p.getPuesto(), contDepto);

            }
        }

        return listaDeptos;

    }

    //método que calcula los días
    public static long diasEntreFechas(LocalDate fecha1, LocalDate fecha2) {

        long result = ChronoUnit.DAYS.between(fecha1, fecha2);
        return result;

    }

}
