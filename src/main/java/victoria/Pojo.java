/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victoria;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author victoria
 */
public class Pojo {

    //encapsulo los atributos del cvs
    private String nombre, dni, puesto;
    private LocalDate fecIni, fecFin;
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

        return "Profesor: " + nombre
                + ", dni: " + dni + ", puesto: " + puesto
                + ", fecIni: " + fecIni + ", fecFin: " + fecFin
                + ", telf: " + telf + ", evaluador: " + evaluador
                + ", coordinador: " + coordinador;
    }
    
    
    public String toStringProfesAntiguos() {

        return   nombre
                + "\t" + dni +"\t" + puesto
                + "\t" + fecIni + "\t" + fecFin
                + "\t" + telf + "\t" + evaluador
                + "\t" + coordinador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nombre);
        hash = 43 * hash + Objects.hashCode(this.dni);
        hash = 43 * hash + Objects.hashCode(this.puesto);
        hash = 43 * hash + Objects.hashCode(this.fecIni);
        hash = 43 * hash + Objects.hashCode(this.fecFin);
        hash = 43 * hash + Objects.hashCode(this.telf);
        hash = 43 * hash + (this.evaluador ? 1 : 0);
        hash = 43 * hash + (this.coordinador ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pojo other = (Pojo) obj;
        if (this.evaluador != other.evaluador) {
            return false;
        }
        if (this.coordinador != other.coordinador) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.puesto, other.puesto)) {
            return false;
        }
        if (!Objects.equals(this.telf, other.telf)) {
            return false;
        }
        if (!Objects.equals(this.fecIni, other.fecIni)) {
            return false;
        }
        return Objects.equals(this.fecFin, other.fecFin);
    }
    
    

}
