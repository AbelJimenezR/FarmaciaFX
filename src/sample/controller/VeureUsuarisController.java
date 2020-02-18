package sample.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.Empleado;
import sample.Persona;
import sample.TaulaUsuaris;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class VeureUsuarisController implements Initializable {

    @FXML
    private TableView<TaulaUsuaris> taulaUsuaris;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<TaulaUsuaris> dades = taulaUsuaris.getItems();
        Iterator<Persona> i = Persona.getEmplea().iterator();
        while (i.hasNext()) {
            Persona e = i.next();
            if (e instanceof Empleado) {
                dades.add(new TaulaUsuaris(e.getNom(), e.getCognom(), e.getContra(), "Empleat Normal"));
            } else {
                dades.add(new TaulaUsuaris(e.getNom(), e.getCognom(), e.getContra(), "Empleat de guàrdia"));
            }
        }

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
