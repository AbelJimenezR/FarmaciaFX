package sample;

import javafx.beans.property.SimpleStringProperty;

public class TaulaUsuaris {
    private final SimpleStringProperty nom = new SimpleStringProperty("");
    private final SimpleStringProperty cognom = new SimpleStringProperty("");
    private final SimpleStringProperty pass = new SimpleStringProperty("");
    private final SimpleStringProperty tipus = new SimpleStringProperty("");



    public TaulaUsuaris(String n, String c,String p,String t) {
        nom.set(n);
        cognom.set(c);
        pass.set(p);
        tipus.set(t);
    }

    public String getTipus() {
        return tipus.get();
    }

    public void setTipus(String t) {
        tipus.set(t);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String v) {
        nom.set(v);
    }

    public String getCognom() {
        return cognom.get();
    }

    public void setCognom(String t) {
        cognom.set(t);
    }

    public String getPass() { return pass.get(); }

    public void setPass(String v) {
        pass.set(v);
    }

}
