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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image image = null;
        try {
            image = new Image(new FileInputStream("farmacia.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageView.setImage(image);
    }

    @FXML
    private Label label;

    @FXML
    protected void menuUsuari(ActionEvent event) throws IOException {
        Stage stage = (Stage) label.getScene().getWindow(); //this accesses the window.

        MenuItem item = (MenuItem) event.getSource();
        String sItem = item.getText();

        if (sItem.equals("Nou Usuari")) {
            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//nouUsuari.fxml"));

            stage.setTitle("Usuaris");
            stage.setScene(new Scene(arrel));
            stage.show();
        } else if (sItem.equals("Veure Usuaris")) {
            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//veureUsuaris.fxml"));

            stage.setTitle("Usuaris");
            stage.setScene(new Scene(arrel));
            stage.show();
        } else if (sItem.equals("Modifica Usuari")) {
            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//modificaUsuari.fxml"));

            stage.setTitle("Usuaris");
            stage.setScene(new Scene(arrel));
            stage.show();
        } else if (sItem.equals("Veure Medicaments")) {
            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//veureMedicaments.fxml"));

            stage.setTitle("Medicaments");
            stage.setScene(new Scene(arrel));
            stage.show();
        } else if (sItem.equals("Nou Medicament")) {
            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//nouMedicament.fxml"));

            stage.setTitle("Medicaments");
            stage.setScene(new Scene(arrel));
            stage.show();
        } else if (sItem.equals("Venda")) {
            Parent arrel = FXMLLoader.load(getClass().getResource("..//view//venda.fxml"));

            stage.setTitle("Venda");
            stage.setScene(new Scene(arrel));
            stage.show();
        }
    }

}




