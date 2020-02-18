package sample;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public abstract class Persona {
    protected static HashSet<Persona> emplea = new HashSet<Persona>();

    protected String nom;
    protected String cognom;
    protected String contra;

    public Persona() {

    }

    public Persona(String nom, String cognom, String contra) {
        this.nom = nom;
        this.cognom = cognom;
        this.contra = contra;
    }

    @Override
    public String toString() {
        return "Persona [Nom=" + nom + ", Cognom=" + cognom + ", Pass =" + contra + "]";
    }

    public abstract String getContra();

    public static Persona comprovaVenedor(String ident) {

        Iterator<Persona> i = emplea.iterator();
        while (i.hasNext()) {
            Persona e = i.next();
            if (ident.compareTo(e.getContra()) == 0) {
                return e;
            }
        }
        return null;
    }

    public static boolean nouUsuari(String nom, String cognom, String contra, String a) {

        int b = Integer.parseInt(a);
        if (b == 1) {
            Persona e = new Empleado(nom, cognom, contra);
            emplea.add(e);
            return true;
        } else if (b == 2) {
            Persona e = new EmpleadoGuardia(nom, cognom, contra);
            emplea.add(e);
            return true;
        } else {
            return false;
        }

    }

    public static boolean modificaUsuari(Persona emple, String tipus) {

        int tip = Integer.parseInt(tipus);

        if (tip == 1) {
            Persona e2 = new Empleado(emple.nom, emple.cognom, emple.contra);
            emplea.add(e2);
            emplea.remove(emple);
            return true;
        } else if (tip == 2) {
            Persona e2 = new EmpleadoGuardia(emple.nom, emple.cognom, emple.contra);
            emplea.add(e2);
            emplea.remove(emple);
            return true;
        } else {
            return false;

        }
    }

    public static HashSet<Persona> getEmplea() {
        return emplea;
    }

    public static void setEmplea(HashSet<Persona> emplea) {
        Persona.emplea = emplea;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}