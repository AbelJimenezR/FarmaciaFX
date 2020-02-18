package sample;

import java.util.Scanner;

public abstract class Medicamento implements Comparable<Medicamento>, Cloneable {
    protected String nom;
    protected Tipo tipo;
    protected String empresa;
    protected Double precio;

    public Medicamento() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Medicamento(String nom, Tipo tipo, String empresa, Double precio) {
        this.nom = nom;
        this.tipo = tipo;
        this.empresa = empresa;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Medicamento [nom=" + nom + ", tipo=" + tipo + ", Empresa=" + empresa + ", precio=" + precio + "]";
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        empresa = empresa;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public int compareTo(Medicamento m) {
        if (this.precio < m.precio)
            return -1;
        if (this.precio == m.precio)
            return 0;
        return 1;
    }
}
	


