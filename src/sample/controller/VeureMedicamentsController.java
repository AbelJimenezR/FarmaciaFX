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
import sample.Medicamento;
import sample.MedicamentoCon;
import sample.TaulaMedicamento;
import sample.Utilitat;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

public class VeureMedicamentsController implements Initializable {

@FXML
private TableView<TaulaMedicamento> taulaMedicaments;


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<TaulaMedicamento> dades = taulaMedicaments.getItems();

        HashMap<Integer, Medicamento> med= Utilitat.medicamentos;
        for (Map.Entry<Integer,Medicamento> s : med.entrySet()){
            if (s.getValue() instanceof MedicamentoCon) {
                dades.add(new TaulaMedicamento(s.getValue().getNom(), s.getValue().getTipo().toString(), s.getValue().getEmpresa(), String.valueOf(s.getValue().getPrecio()), "Sí"));
            }else{
                dades.add(new TaulaMedicamento(s.getValue().getNom(), s.getValue().getTipo().toString(), s.getValue().getEmpresa(), String.valueOf(s.getValue().getPrecio()), "No"));

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





