package sample.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class VendaController implements Initializable {
    @FXML
    private Pane medicament;
    @FXML
    private ChoiceBox medi;
    @FXML
    Double tot = 0.;

    @FXML
    private CheckBox recepta;

    @FXML
    private TextField contraComprova;

    @FXML
    private Label usuari;

    @FXML
    private Persona e;

    @FXML
    Ticket ti1;

    @FXML
    ArrayList<Double> preus = new ArrayList<Double>();

    @FXML
    private TableView<TaulaTicket> taulaTicket;

    @FXML
    private Label total;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        medicament.setVisible(false);

        HashMap<Integer, Medicamento> m = Utilitat.medicamentos;
        for (Map.Entry<Integer, Medicamento> s : m.entrySet()) {
            medi.getItems().add(s.getValue().getNom());
        }
    }

    @FXML
    protected void comprovaPass() {
        try {
            e = Persona.comprovaVenedor(contraComprova.getText());
            if (e != null) {
                contraComprova.setText("");
                medi.setVisible(true);
                contraComprova.setVisible(false);
                //afegir.setVisible(true);
                medicament.setVisible(true);
                usuari.setText(e.getNom());
                ti1 = new Ticket(1, e);

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informació");
                alert.setHeaderText("No s'ha trobat l'usuari.");
                alert.showAndWait();
                contraComprova.setText("");
            }
        } catch (Exception e) {

        }
    }

    @FXML
    protected void afegirMedicament() throws CloneNotSupportedException {
        String med = medi.getValue().toString();
        String rec = "";
        ObservableList<TaulaTicket> dades = taulaTicket.getItems();

        if (recepta.isSelected()) {
            rec = "S";
        } else {
            rec = "N";
        }

        if (Utilitat.compruebaMedicamento(med) instanceof MedicamentoCon) {
            MedicamentoCon mc = (MedicamentoCon) Utilitat.compruebaMedicamento(med);

            if (rec.equals("S")) {
                MedicamentoCon medClone = (MedicamentoCon) mc.clone();
                preus.add(medClone.descuento());
                ti1.setMedicamento(medClone);
                dades.add(new TaulaTicket(mc.getNom(), String.valueOf(mc.getPrecio()), String.valueOf(mc.descuento())));

            } else {
                Utilitat.alertDades();
            }
        } else {
            MedicamentoSin ms = (MedicamentoSin) Utilitat.compruebaMedicamento(med);
            if (rec.equals("S")) {
                MedicamentoSin medsClone = (MedicamentoSin) ms.clone();
                preus.add(medsClone.descuento());
                ti1.setMedicamento(medsClone);
                dades.add(new TaulaTicket(ms.getNom(), String.valueOf(ms.getPrecio()), String.valueOf(ms.descuento())));

            } else {
                MedicamentoSin medsClone = ms.clone();
                preus.add(medsClone.getPrecio());
                ti1.setMedicamento(medsClone);
                dades.add(new TaulaTicket(ms.getNom(), String.valueOf(ms.getPrecio()), String.valueOf(ms.getPrecio())));

            }
        }

        for (TaulaTicket item : taulaTicket.getItems()) {
            tot = tot + Double.parseDouble(item.getPreu2());
            total.setText(tot.toString());
        }

    }

    public void tanca(ActionEvent event) throws IOException {

        ti1.preuTotalDescompte(preus);
        ti1.preuTotal();
        Ticket.medicamento.sort(null);
        Ticket.log(ti1);
        medi.setValue(null);
        recepta.setSelected(false);
        ti1 = new Ticket(1, e);
        taulaTicket.getItems().clear();
        total.setText("");
        tot = 0.;
        preus.clear();
    }

    @FXML
    protected void tornaPrincipal(ActionEvent event) throws IOException {
        Button boto = (Button) event.getSource();
        Stage stage = (Stage) boto.getScene().getWindow(); //this accesses the window.

        Parent arrel = FXMLLoader.load(getClass().getResource("..//view//Principal.fxml"));
        stage.setTitle("Farmacia");
        stage.setScene(new Scene(arrel));
        stage.show();
    }
}
