package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Label label;



    @FXML
    protected void menuUsuari(ActionEvent event) throws IOException {
        Stage stage = (Stage) label.getScene().getWindow(); //this accesses the window.

        MenuItem item= (MenuItem) event.getSource();
        String sItem=item.getText();

        if(sItem.equals("Nou Usuari")) {
            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//nouUsuari.fxml"));

            stage.setTitle("Usuaris");
            stage.setScene(new Scene(arrel));
            stage.show();
        }else if(sItem.equals("Veure Usuaris")) {
            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//veureUsuaris.fxml"));

            stage.setTitle("Usuaris");
            stage.setScene(new Scene(arrel));
            stage.show();
        } else if(sItem.equals("Modifica Usuari")) {
        Parent arrel = FXMLLoader.load(getClass().getResource("..//view//modificaUsuari.fxml"));

        stage.setTitle("Usuaris");
        stage.setScene(new Scene(arrel));
        stage.show();
    }else if(sItem.equals("Veure Medicaments")) {
            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//veureMedicaments.fxml"));

            stage.setTitle("Medicaments");
            stage.setScene(new Scene(arrel));
            stage.show();
        }else if(sItem.equals("Nou Medicament")) {
            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//nouMedicament.fxml"));

            stage.setTitle("Medicaments");
            stage.setScene(new Scene(arrel));
            stage.show();
        }




    }

    @FXML
    protected void tornaPrincipal(ActionEvent event) throws IOException {
        Button boto = (Button) event.getSource();
        Stage stage = (Stage) boto.getScene().getWindow(); //this accesses the window.

        Parent arrel = FXMLLoader.load(getClass().getResource("view/Principal.fxml"));
        stage.setTitle("Farmacia");
        stage.setScene(new Scene(arrel));
        stage.show();
    }



    }




