package poo1.elecciones.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import poo1.colegio.base.Personero;
import poo1.colegio.fachada.Colegio;

public class ActualizarPersoneroController {

	@FXML private TextField txtNombres;
	@FXML private TextField txtApellidos;
	@FXML private TextField txtNumTarjeton;
	@FXML private TextField txtGrado;
	@FXML private TextField txtLema;
	@FXML private TextField txtIdMascota;
	@FXML private TextField txtNombreMascota;
	
	private Colegio colegioObj;
	
	public ActualizarPersoneroController() {
		colegioObj = Colegio.obtenerInstancia();
	}
	
	public void actualizarPersonero(ActionEvent e) {
		String nombres = txtNombres.getText();
		String apellidos = txtApellidos.getText();
		
		String numTarjeton = txtNumTarjeton.getText();
		int numTarjetonInt = Integer.parseInt(numTarjeton);		
		
		String grado = txtGrado.getText();
		String lema = txtLema.getText();
		
		colegioObj.actualizarPersonero(numTarjetonInt, nombres, apellidos, grado, lema);
	}
	
	public void buscarPersonero(ActionEvent e) {
		String numTarjeton = txtNumTarjeton.getText();
		int intNumTarjeton = Integer.parseInt(numTarjeton);
		
		Personero per = colegioObj.buscarPersonero(intNumTarjeton);
		if(per!=null) {
			
			txtNombres.setText(per.getNombre());
			txtApellidos.setText(per.getApellido());
			txtGrado.setText(per.getGrado());
			txtLema.setText(per.getLema());
			txtIdMascota.setText(per.getIdentificacionMascota());
			txtNombreMascota.setText(per.getNombreMascota());
			
		}else {
			txtNombres.clear();
		}
		
	}
	
	public void volverInicio(ActionEvent e){		
		abrirVentana(e, "PrincipalView");				
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
	
}
