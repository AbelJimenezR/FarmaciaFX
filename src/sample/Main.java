package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Utilitat.cargaMedicamentos();
		Utilitat.cargaEmpleados();
		Parent arrel = FXMLLoader.load(getClass().getResource("view/Principal.fxml"));

		stage.setTitle("Farmàcia");
		stage.setScene(new Scene(arrel, 300, 275));
		stage.show();
	}
}

	

	
	
	

