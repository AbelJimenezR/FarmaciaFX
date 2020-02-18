package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Persona;
import sample.Utilitat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModificaUsuariController implements Initializable {

    @FXML
    private TextField nom, cognom, pass, tipus, contraComprova;
    private Persona e;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nom.setVisible(false);
        cognom.setVisible(false);
        pass.setVisible(false);
        tipus.setVisible(false);
    }

    @FXML
    protected void comprovaPass() {
        try {
            e = Persona.comprovaVenedor(contraComprova.getText());
            if (e != null) {
                nom.setText(e.getNom());
                cognom.setText(e.getCognom());
                pass.setText(e.getContra());
                nom.setVisible(true);
                cognom.setVisible(true);
                pass.setVisible(true);
                tipus.setVisible(true);
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
    protected void optBotons(ActionEvent event) throws IOException {
        Button boto = (Button) event.getSource();
        Stage stage = (Stage) boto.getScene().getWindow(); //this accesses the window.
        String bot = boto.getText();
        Boolean x = false;
        if (bot.equals("Tornar")) {

            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//Principal.fxml"));
            stage.setTitle("Farmacia");
            stage.setScene(new Scene(arrel));
            stage.show();

        } else if (bot.equals("Ok")) {

            try {
                e.setNom(nom.getText());
                e.setCognom(cognom.getText());
                e.setContra(pass.getText());

                if (Persona.modificaUsuari(e, tipus.getText())) {
                    nom.setText("");
                    cognom.setText("");
                    pass.setText("");
                    tipus.setText("");
                    contraComprova.setText("");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Informació");
                    alert.setHeaderText("Usuari modificat correctament.");
                    alert.showAndWait();
                    contraComprova.setText("");
                } else {
                    Utilitat.alertDades();
                }

            } catch (Exception e) {
                Utilitat.alertDades();
            }
        }
    }
}
