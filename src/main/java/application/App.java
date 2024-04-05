package application;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {
		var javaVersion = SystemInfo.javaVersion();
		var javafxVersion = SystemInfo.javafxVersion();

		// Creo un panel vertical, segun se añaden
		// cosas se van mostrando una encima de otra
		VBox panelVertical = new VBox();

		// Creamos los controles
		Label lblNombre = new Label("Nombre:");
		Label lblInfo = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		TextField txtNombre = new TextField("Pedro");
		txtNombre.setMaxWidth(170);
		CheckBox cbxAcepto = new CheckBox("Acepto los terminos hasta mi muerte");
		ChoiceBox chbCiudad = new ChoiceBox();
		Button btnAceptar = new Button("Aceptar");

		chbCiudad.getItems().addAll("Cadiz", "sanfernando", "Jerez");

		// Les ponemos margen
		panelVertical.setMargin(lblInfo, new Insets(5, 20, 5, 20));
		panelVertical.setMargin(lblNombre, new Insets(5, 20, 5, 20));
		panelVertical.setMargin(txtNombre, new Insets(5, 20, 5, 20));
		panelVertical.setMargin(cbxAcepto, new Insets(5, 20, 5, 20));
		panelVertical.setMargin(chbCiudad, new Insets(5, 20, 5, 20));
		panelVertical.setMargin(btnAceptar, new Insets(5, 20, 5, 20));

		// Añadimos al vBox los controles

		panelVertical.getChildren().addAll(lblInfo, lblNombre, txtNombre, cbxAcepto, chbCiudad, btnAceptar);

		// La scene es el contenido de la ventana,
		// cuando se crea se define su tamaño por
		// defecto
		// Cuando creamos la escena le asignamos el
		// contenido que es compatible con node
		var scene = new Scene(panelVertical, 800, 600);

		// El objeto stage es la ventana simplemente,
		// el titulo y los botones de minimizar,
		// maximizar y cerrar
		stage.setTitle("Mi primera aplicacion");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();

		try {
			// Crear el documento
			Document document = new Document();

			// Crear el OutputStream para el archivo
			// PDF
			FileOutputStream pdfFile = new FileOutputStream("fichero.pdf");

			// Asociar el documento al OutputStream
			PdfWriter.getInstance(document, pdfFile);

			// Abrir el documento
			document.open();

			// Agregar un párrafo
			document.add(new Paragraph("¡Hola, mundo! Este es mi primer PDF con iText."));

			// Agregar una imagen (reemplaza
			// 'pingu.png' con la ruta de tu imagen)
			Image image = Image.getInstance("img/beatle.jpg");
			image.scaleToFit(200, 200); // Ajustar
										// tamaño de la
										// imagen
			document.add(image);

			// Cerrar el documento
			document.close();

			System.out.println("Archivo PDF creado correctamente.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}