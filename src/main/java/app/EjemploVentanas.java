package app;

import app.panel.PanelFormulario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjemploVentanas extends Application {

	@Override
	public void start(Stage stage) {

		PanelFormulario panelF = new PanelFormulario();

		VBox panelVertical = new VBox();

		panelVertical.getChildren().add(panelF);

		Button btnVentana1 = new Button("Ventana Info");
		Label lblInfo = new Label("Información");

		// Añadimos los elementos al panel Vertical
		panelVertical.getChildren().addAll(btnVentana1, lblInfo);

		panelVertical.setMargin(btnVentana1, new Insets(5, 10, 5, 10));
		panelVertical.setMargin(lblInfo, new Insets(5, 10, 5, 10));

		// Añadimos a la escena el panel vertical
		Scene scene = new Scene(panelVertical, 600, 600);

		stage.setScene(scene);

		stage.setTitle("Formulario de Contacto");

		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();

	}
}
