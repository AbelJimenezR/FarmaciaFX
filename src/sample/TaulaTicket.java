package sample;

import javafx.beans.property.SimpleStringProperty;

public class TaulaTicket {
    private final SimpleStringProperty producte = new SimpleStringProperty("");
    private final SimpleStringProperty preu1 = new SimpleStringProperty("");
    private final SimpleStringProperty preu2 = new SimpleStringProperty("");

    public TaulaTicket(String p, String p1, String p2) {
        producte.set(p);
        preu1.set(p1);
        preu2.set(p2);
    }

    public String getProducte() {
        return producte.get();
    }

    public void setProducte(String producte) {
        this.producte.set(producte);
    }

    public String getPreu1() {
        return preu1.get();
    }

    public void setPreu1(String preu1) {
        this.preu1.set(preu1);
    }

    public String getPreu2() {
        return preu2.get();
    }

    public void setPreu2(String preu2) {
        this.preu2.set(preu2);
    }
}

