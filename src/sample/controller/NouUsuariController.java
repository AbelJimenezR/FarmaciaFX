package sample.controller;

import com.sun.webkit.network.Util;
import javafx.collections.ObservableList;
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

public class NouUsuariController implements Initializable {

    @FXML
    private TextField nom, cognom, pass, tipus;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    protected void optBotons(ActionEvent event) throws IOException {
        Button boto = (Button) event.getSource();
        Stage stage = (Stage) boto.getScene().getWindow(); //this accesses the window.
        String bot = boto.getText();
        if (bot.equals("Tornar")) {

            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//Principal.fxml"));
            stage.setTitle("Farmacia");
            stage.setScene(new Scene(arrel));
            stage.show();

        } else if (bot.equals("Ok")) {

            try {
                if (Persona.nouUsuari(nom.getText(), cognom.getText(), pass.getText(), tipus.getText())) {

                    nom.setText("");
                    cognom.setText("");
                    pass.setText("");
                    tipus.setText("");

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Informació");
                    alert.setHeaderText("Usuari afegit correctament");
                    alert.showAndWait();
                } else {

                    Utilitat.alertDades();
                }

            } catch (Exception e) {

                Utilitat.alertDades();
            }
        }
    }
}


