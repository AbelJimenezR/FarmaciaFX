package sample.controller;

import com.sun.webkit.network.Util;
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
    private CheckBox recepta;

    @FXML
    private TextField contraComprova;

    @FXML
    private Label usuari;

    @FXML
    private Persona e;

    @FXML
    private Button afegir;

    @FXML
    private Label medLlista;

    @FXML
    Ticket ti1;

    @FXML
    ArrayList<Double> preus= new ArrayList<Double>();



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // medi.setVisible(false);
       // afegir.setVisible(false);
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
                ti1 = new Ticket(1,e);


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
    protected void afegirMedicament() {
        String med = medi.getValue().toString();
        String rec="";


        if (recepta.isSelected()) {
            rec="S";
        }else{
            rec="N";
        }

        if (Utilitat.compruebaMedicamento(med) instanceof MedicamentoCon){
            MedicamentoCon mc = (MedicamentoCon) Utilitat.compruebaMedicamento(med);

            if (rec.equals("S")) {
                ti1.setMedicamento(mc);
                preus.add(mc.descuento());

            } else {
                Utilitat.alertDades();
            }
        }else{
            MedicamentoSin ms = (MedicamentoSin) Utilitat.compruebaMedicamento(med);
            if (recepta.equals("S")) {
                preus.add(ms.descuento());
                ti1.setMedicamento(ms);
            } else {
                preus.add(ms.getPrecio());
                ti1.setMedicamento(ms);
            }
        }



        medLlista.setText(med);

    }

    public void tanca(ActionEvent event) throws IOException {
        Button boto = (Button) event.getSource();
        Stage stage = (Stage) boto.getScene().getWindow(); //this accesses the window.

        ti1.preuTotalDescompte(preus);
        ti1.preuTotal();
        Ticket.log(ti1);

        medi.setValue(null);
        recepta.setSelected(false);

        ti1 = new Ticket(1,e);



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
