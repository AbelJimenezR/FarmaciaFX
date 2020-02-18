package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.*;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class nouMedicamentController implements Initializable {

    @FXML
    private TextField nom, empresa, preu;
    @FXML
    private ChoiceBox tipus;
    @FXML
    private CheckBox recepta;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tipo[] t = Tipo.values();
        for (Tipo tipo : t) {
            tipus.getItems().add(tipo);
        }
    }

    @FXML
    protected void optBotons(ActionEvent event) throws IOException {
        Button boto = (Button) event.getSource();
        Stage stage = (Stage) boto.getScene().getWindow(); //this accesses the window.
        String bot = boto.getText();
        String rec = "0";

        if (bot.equals("Tornar")) {

            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//Principal.fxml"));
            stage.setTitle("Farmacia");
            stage.setScene(new Scene(arrel));
            stage.show();

        } else if (bot.equals("Ok")) {

            try {
                if (recepta.isSelected()) {
                    rec = "1";
                } else {
                    rec = "0";
                }
                String medi = "" + nom.getText() + "," + tipus.getValue().toString() + "," + empresa.getText() + "," + preu.getText() + "," + rec;
                Utilitat.cargaMedicamentos(medi);

                nom.setText("");
                empresa.setText("");
                preu.setText("");
                tipus.setValue(null);
                recepta.setSelected(false);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informació");
                alert.setHeaderText("Medicament afegit correctament");
                alert.showAndWait();

            } catch (Exception e) {

                Utilitat.alertDades();
            }

        }
    }

}


