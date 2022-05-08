package poo1.elecciones.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import poo1.colegio.fachada.Colegio;

public class GenerarReportesController implements Initializable{

	@FXML ComboBox<String> cmbReportes;
	@FXML TextArea taContenido;
	
	private Colegio colegioObj;
	
	public GenerarReportesController() {
		colegioObj = Colegio.obtenerInstancia();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cmbReportes.getItems().add("Listar datos personeros");
		cmbReportes.getItems().add("Reporte 1");
		cmbReportes.getItems().add("Reporte 2");
		cmbReportes.getItems().add("Reporte 3");
	}
	
	public void generarReporte(ActionEvent e) {
		if(cmbReportes.getValue().equals("Listar datos personeros")) {
			String mensaje = colegioObj.listarDatosPersoneros();
			taContenido.setText(mensaje);
		}
	}
	
	public void limpiarReporte(ActionEvent e) {
		
	}

	public void volverInicio(ActionEvent e) {
		
	}
	
	
	
}
