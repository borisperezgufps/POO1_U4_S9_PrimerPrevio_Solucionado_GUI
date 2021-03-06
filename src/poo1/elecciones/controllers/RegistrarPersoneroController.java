package poo1.elecciones.controllers;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import poo1.colegio.fachada.Colegio;

public class RegistrarPersoneroController {
	
	@FXML private TextField txtNombres;
	@FXML private TextField txtApellidos;
	@FXML private TextField txtNumTarjeton;
	@FXML private TextField txtGrado;
	@FXML private TextField txtLema;
	@FXML private TextField txtIdMascota;
	@FXML private TextField txtNombreMascota;
	
	private Colegio colegioObj;
	
	public RegistrarPersoneroController() {
		colegioObj = Colegio.obtenerInstancia();
	}
	
	@FXML public void registrarPersonero(ActionEvent e) {
		
		String nombres = txtNombres.getText();
		String apellidos = txtApellidos.getText();
		
		String numTarjeton = txtNumTarjeton.getText();
		int numTarjetonInt = Integer.parseInt(numTarjeton);		
		
		String grado = txtGrado.getText();
		String lema = txtLema.getText();
		String idMascota = txtIdMascota.getText();
		String nombreMascota = txtNombreMascota.getText();
		
		colegioObj.agregarCandidatoPersonero(nombres, apellidos, grado, 
				lema, numTarjetonInt, idMascota, nombreMascota);
		
		txtNombres.clear();
		txtApellidos.clear();
		txtNumTarjeton.clear();
		txtGrado.clear();
		txtLema.clear();
		txtIdMascota.clear();
		txtNombreMascota.clear();
		
//		JOptionPane.showMessageDialog(null, "El personero se agrego satisfactoriamente");
		
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
