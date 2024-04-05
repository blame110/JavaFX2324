package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class EjemploTabPane extends Application {

	@Override
	public void start(Stage stage) {

		TabPane panelPestanas = new TabPane();

		// Creamos las pestañas que vamos a añadir al
		// panel
		Tab tab1 = new Tab("Formulario");
		Tab tab2 = new Tab("Imágen");
		Tab tab3 = new Tab("Música");

		tab1.setClosable(false);
		tab2.setClosable(false);
		tab3.setClosable(false);

		// PRIMER PANEL CON FORMULARIO
		VBox pnlFormulario = new VBox();

		pnlFormulario.getChildren().add(new Label("Email"));
		pnlFormulario.getChildren().add(new TextField());

		// Añadimos al tab1 el vbox con los controles
		tab1.setContent(pnlFormulario);

		// EN LA SEGUNDA TAB UNA IMAGEN
		Image imagen;

		try {
			// Abrimos la imagen
			imagen = new Image(new FileInputStream("./img/beatle.jpg"));
			ImageView mImagen = new ImageView(imagen);
			// Reducimos el ancho de la imagen
			mImagen.setPreserveRatio(true);
			mImagen.setFitWidth(560);

			tab2.setContent(mImagen);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TERCERA PESTAÑA UN REPRODUCTOR DE MUSICA
		// Cargamos el fichero de musica en un media
		Media cancion = new Media(new File("./sounds/GretaHighwayTune.mp3").toURI().toString());

		// El media se lo asignamos a un player para
		// poder escucharlo
		MediaPlayer reproductor = new MediaPlayer(cancion);

		// Creamos un boton para que al pulsarlo se
		// escuche la musica
		Button btnPlay = new Button("Escuchar Música");

		// Cuando se pulse sobre el boton se
		// reproducira la cancion
		btnPlay.setOnAction(e -> reproductor.play());

		// Añadimos el boton a la tercera pestaña
		tab3.setContent(btnPlay);

		// Añadimos las pestañas al panel
		panelPestanas.getTabs().addAll(tab1, tab2, tab3);

		// Creamos la escena con el panel de pestañas
		Scene scene = new Scene(panelPestanas, 600, 480);

		// Asignamos la escena al stage
		stage.setScene(scene);

		stage.setTitle("Ejemplo Pestañas Multimedia");
		// Mostramos la ventana
		stage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

}
