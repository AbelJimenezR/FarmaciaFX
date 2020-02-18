package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Utilitat {

    public static HashMap<Integer, Medicamento> medicamentos = new HashMap<Integer, Medicamento>();

    public static void cargaMedicamentos() {
        String fichero = "med.txt";
        int s = 0;
        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";

            while ((linea = br.readLine()) != null) {
                medicamentos.put(s, lini(linea));
                s++;
            }

            fr.close();
        } catch (Exception e) {
            System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
        }
    }

    public static void cargaMedicamentos(String med) {
        int num = 0;
        for (Map.Entry<Integer, Medicamento> s : medicamentos.entrySet()) {
            if (s.getKey() > num) {
                num = s.getKey();
            }
        }
        medicamentos.put(num + 1, lini(med));
    }

    public static Medicamento lini(String linia) {

        List<String> meda = Arrays.asList(linia.split(","));
        Medicamento medi = null;

        for (Tipo tmp : Tipo.values()) {
            if (meda.get(4).equals("0")) {
                if (meda.get(1).equalsIgnoreCase(tmp.name())) {
                    medi = new MedicamentoSin(meda.get(0), Tipo.valueOf(tmp.toString()), meda.get(2),
                            Double.valueOf(meda.get(3)));
                }
            } else {
                if (meda.get(1).equalsIgnoreCase(tmp.name())) {
                    medi = new MedicamentoCon(meda.get(0), Tipo.valueOf(tmp.toString()), meda.get(2),
                            Double.valueOf(meda.get(3)));
                }
            }
        }
        return medi;

    }

    public static Medicamento compruebaMedicamento(String medicamento) {
        //Medicamento num=null;
        for (Medicamento med : medicamentos.values()) {
            if (med.getNom().toUpperCase().equals(medicamento.toUpperCase())) {
                return med;

                //num = medicamentos.get(num);
            }
        }
        return null;
    }

    public static void cargaEmpleados() {
        File file = new File("Empleados.xml");

        NodeList nList = null;

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("empleat");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                if (eElement.getAttribute("tipus").equals("0")) {
                    Persona e = new Empleado(eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("cognoms").item(0).getTextContent(), eElement.getElementsByTagName("contrasenya").item(0).getTextContent());
                    Persona.emplea.add(e);
                } else {
                    Persona e = new EmpleadoGuardia(eElement.getElementsByTagName("nom").item(0).getTextContent(), eElement.getElementsByTagName("cognoms").item(0).getTextContent(), eElement.getElementsByTagName("contrasenya").item(0).getTextContent());
                    Persona.emplea.add(e);
                }

            }
        }
    }

    public static void alertDades() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Advertència");
        alert.setHeaderText("Dades Incorrectes");
        alert.setContentText("Torna-ho a provar");
        alert.showAndWait();

    }

    public static void afegirMedicamentsRegistre() {

        Registre<Medicamento> rMed = new Registre<Medicamento>();

        for (int i = 0; i < medicamentos.size(); i++) {
            rMed.add(medicamentos.get(i));
        }

    }

    public static void afegirUsuarisRegistre() {

        Registre<Persona> rPer = new Registre<Persona>();

        Iterator<Persona> i = Persona.emplea.iterator();
        while (i.hasNext()) {
            Persona e = i.next();
            rPer.add(e);
        }

    }


}
