package sample;

import javafx.beans.property.SimpleStringProperty;

public class TaulaMedicamento {
    private final SimpleStringProperty nom = new SimpleStringProperty("");
    private final SimpleStringProperty tipus = new SimpleStringProperty("");
    private final SimpleStringProperty empresa = new SimpleStringProperty("");
    private final SimpleStringProperty preu = new SimpleStringProperty("");
    private final SimpleStringProperty recepta = new SimpleStringProperty("");

    public TaulaMedicamento(String n, String t, String e, String p, String r) {
        nom.set(n);
        tipus.set(t);
        empresa.set(e);
        preu.set(p);
        recepta.set(r);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getTipus() {
        return tipus.get();
    }

    public void setTipus(String tipus) {
        this.tipus.set(tipus);
    }

    public String getEmpresa() {
        return empresa.get();
    }

    public void setEmpresa(String empresa) {
        this.empresa.set(empresa);
    }

    public String getPreu() {
        return preu.get();
    }

    public void setPreu(String preu) {
        this.preu.set(preu);
    }

    public String getRecepta() {
        return recepta.get();
    }

    public void setRecepta(String recepta) {
        this.recepta.set(recepta);
    }
}
