package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class EjemploMenusBorderPane extends Application {

	@Override
	public void start(Stage stage) {

		// Creamos el panel principal
		BorderPane pnlDistribucion = new BorderPane();

		// ZONA SUPERIOR MENU
		Label lblMenu = new Label("Menu");

		// Asignamos el menu a la parte superior
		pnlDistribucion.setTop(lblMenu);
		pnlDistribucion.setMargin(lblMenu, new Insets(10, 7, 10, 7));
		pnlDistribucion.setAlignment(lblMenu, Pos.CENTER);

		// ZONA LATERAL IZQUIERDA UN CONJUNTO DE
		// BOTONES
		VBox panelLateral = new VBox();
		Button btnCargar = new Button("Cargar");
		Button btnGuardar = new Button("Guardar");
		panelLateral.setMargin(btnCargar, new Insets(5, 7, 5, 7));
		panelLateral.setMargin(btnGuardar, new Insets(5, 7, 5, 7));

		// Añadimos los dos botones al panel vertial
		panelLateral.getChildren().addAll(btnCargar, btnGuardar);

		// En la zona izquierda del borderpane ponemos
		// el Vbox con los botones
		pnlDistribucion.setLeft(panelLateral);

		// PANEL CENTRAL VAMOS A PONER UN TEXTAREA Y UN
		// SLIDER

		VBox panelCentral = new VBox();

		Label lblValorNota = new Label("5");

		Slider slider = new Slider();
		slider.setMaxWidth(380);
		slider.setMin(0);
		slider.setMax(10);
		slider.setValue(5);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(10);
		slider.setMinorTickCount(1);
		slider.setBlockIncrement(1);

		// Cuando el slider cambia de valor en lugar de
		// un EventHandler,
		// Se utiliza un Listener
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {

				lblValorNota.setText(new_val.toString());

			}
		});

		TextArea textoFich = new TextArea();

		// Añadimos el slider y el textarea al Vbox
		panelCentral.getChildren().addAll(lblValorNota, slider, textoFich);

		panelCentral.setMargin(slider, new Insets(5, 7, 5, 7));
		panelCentral.setMargin(textoFich, new Insets(5, 7, 5, 7));
		panelCentral.setMargin(lblValorNota, new Insets(5, 7, 5, 7));

		// Añadimos el Vbox al centro del borderpane
		// principal
		pnlDistribucion.setCenter(panelCentral);

		// La scene es el contenido de la ventana,
		// cuando se crea se define su tamaño por
		// defecto
		// Cuando creamos la escena le asignamos el
		// contenido que es compatible con node
		var scene = new Scene(pnlDistribucion, 800, 600);

		// El objeto stage es la ventana simplemente,
		// el titulo y los botones de minimizar,
		// maximizar y cerrar
		stage.setTitle("Ejemplo Menu");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();

	}

}