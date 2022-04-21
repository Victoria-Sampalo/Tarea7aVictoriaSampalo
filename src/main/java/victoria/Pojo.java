/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victoria;

import java.time.LocalDate;

/**
 *
 * @author victoria
 */
public class Pojo {
    //encapsulo los atributos del cvs
    private String nombre, dni, puesto;
    private LocalDate fecIni,fecFin;
    private String telf; 
    private boolean evaluador, coordinador;
    
    //constructor por defecto

    public Pojo() {
    }

    public Pojo(String nombre, String dni, String puesto, LocalDate fecIni, LocalDate fecFin, String telf, boolean evaluador, boolean coordinador) {
        this.nombre = nombre;
        this.dni = dni;
        this.puesto = puesto;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.telf = telf;
        this.evaluador = evaluador;
        this.coordinador = coordinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public LocalDate getFecIni() {
        return fecIni;
    }

    public void setFecIni(LocalDate fecIni) {
        this.fecIni = fecIni;
    }

    public LocalDate getFecFin() {
        return fecFin;
    }

    public void setFecFin(LocalDate fecFin) {
        this.fecFin = fecFin;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public boolean isEvaluador() {
        return evaluador;
    }

    public void setEvaluador(boolean evaluador) {
        this.evaluador = evaluador;
    }

    public boolean isCoordinador() {
        return coordinador;
    }

    public void setCoordinador(boolean coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public String toString() {
        int contador= 0;
        return "Profesor: "+ nombre + 
                ", dni: " + dni + ", puesto: " + puesto + 
                ", fecIni: " + fecIni + ", fecFin: " + fecFin + 
                ", telf: " + telf + ", evaluador: " + evaluador +
                ", coordinador: " + coordinador ;
    }
    
    
    
    
    
}
