package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Ticket {

    private int numTicket;
    private Persona persona;
    public static ArrayList<Medicamento> medicamento;
    private double precioTotal;
    private double precioTotalReceta;

    public Ticket() {
        medicamento = new ArrayList<Medicamento>();
    }

    public Ticket(int numTicket, Persona persona) {
        this();
        this.numTicket = numTicket;
        this.persona = persona;

    }

    public void setMedicamento(Medicamento med) {
        medicamento.add(med);
    }

    public void preuTotalDescompte(ArrayList<Double> preus) {
        for (Double p : preus) {
            precioTotalReceta = preus.stream().mapToDouble(f -> f.doubleValue()).sum();
        }

    }

    public void preuTotal() {
        for (Medicamento m : medicamento) {
            precioTotal = precioTotal + m.precio;
        }
    }

    @Override
    public String toString() {
        return "Ticket " + numTicket + "\n" + "Atendido por: " + persona.nom + "\n" + medicamento + "\n" + "SubTotal: " + precioTotal + "\n" + "Total con dto recetas: " + precioTotalReceta;
    }

    public static void log(Ticket t) {
        try {
            FileReader fr = new FileReader("log.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String text = "";

            while ((linea = br.readLine()) != null) {
                text = text + linea + "\n";
            }
            fr.close();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
            Calendar calendar = Calendar.getInstance();
            text = text + formatter.format(calendar.getTime()) + " - " + t.toString() + "\n";
            FileWriter archivo = new FileWriter("log.txt");
            for (int i = 0; i < text.length(); i++) {
                archivo.append(text.charAt(i));
            }
            archivo.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }
    }


}
	
	


