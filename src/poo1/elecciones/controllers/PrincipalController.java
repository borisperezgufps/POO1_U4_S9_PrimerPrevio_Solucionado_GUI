package poo1.elecciones.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrincipalController implements Initializable{

	@FXML private ComboBox<String> cmbOpciones;
	
	public void abrirOpcion(ActionEvent e){
		
		String opcionCombo = cmbOpciones.getValue();
		String viewACargar = obtenerNombreView(opcionCombo);
		
		abrirVentana(e, viewACargar);
	}
	
	public void abrirRegistrarPersonero(ActionEvent e){		
		abrirVentana(e, "RegistrarPersoneroView");				
	}
	
	public void abrirRegistrarRepresentante(ActionEvent e){		
		abrirVentana(e, "RegistrarRepresentanteView");				
	}
	
	public void abrirRegistrarVoto(ActionEvent e){		
		abrirVentana(e, "RegistrarVotoView");				
	}
	
	public void abrirGenerarReportes(ActionEvent e){		
		abrirVentana(e, "GenerarReportesView");				
	}
	
	private void abrirVentana(ActionEvent e, String vista) {
		Stage stage = obtenerStage(e);
		stage.close();
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().
					getResource("/poo1/elecciones/views/"+vista+".fxml"));
			
			Pane root = loader.load();			
			
			Scene scene = new Scene(root);
		    stage.setScene(scene);
		    
		    stage.show();		    		    

		} catch (IOException ev) {
			ev.printStackTrace();
		}
	}

	private Stage obtenerStage(ActionEvent event) {
		Node node = (Node) event.getSource();
		
		Stage stage = (Stage) node.getScene().getWindow();
		
		return stage;
	}
	
	private String obtenerNombreView(String opcion) {
		String vista = "";
		switch(opcion) {
		case "Votar":
			vista = "RegistrarVotoView";
			break;
		case "Registrar Personero":
			vista = "RegistrarPersoneroView";
			break;
		case "Registrar Representante":
			vista = "RegistrarRepresentanteView";
			break;
		case "Generar Reportes":
			vista = "GenerarReportesView";
			break;
		}
		return vista;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ArrayList<String> listaOpciones = new ArrayList<>();
		listaOpciones.add("Votar");
		listaOpciones.add("Registrar Personero");
		listaOpciones.add("Registrar Representante");
		listaOpciones.add("Generar Reportes");
		
		
		// Se invoca el método getItems del ComboBox, y se agregan todos los
		// elementos que vienen de la lista de amigos inicial.
		cmbOpciones.getItems().addAll(listaOpciones);
		
	}
}

