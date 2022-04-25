package poo1.elecciones.controllers;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
		
		colegioObj.agregarCandidatoPersonero(nombres, apellidos, grado, lema, numTarjetonInt, idMascota, nombreMascota);
		
		JOptionPane.showMessageDialog(null, "El personero se agregó satisfactoriamente");
		
	}
	
	@FXML public void volverInicio(ActionEvent e) {
		
	}
	
}
