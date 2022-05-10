package poo1.elecciones.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import poo1.colegio.fachada.Colegio;

public class PrincipalController implements Initializable{

	@FXML private ComboBox<String> cmbOpciones;
	@FXML private ComboBox<String> cmbPersoneros;
	
	@FXML private ListView<String> lvPersoneros;	
	private ObservableList<String> listaPersoneros;
	
	@FXML private TextField txtNombrePersonero;
	
	private Colegio colegioObj;
	
	public PrincipalController() {
		colegioObj = Colegio.obtenerInstancia();
	}
	
	public void abrirOpcion(ActionEvent e){
		
		String opcionCombo = cmbOpciones.getValue();
		String viewACargar = obtenerNombreView(opcionCombo);
		
		abrirVentana(e, viewACargar);
	}
	
	public void abrirRegistrarPersonero(ActionEvent e){		
		abrirVentana(e, "RegistrarPersoneroView");				
	}
	
	public void abrirActualizarPersonero(ActionEvent e){		
		abrirVentana(e, "ActualizarPersoneroView");				
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
		case "Actualizar Personero":
			vista = "ActualizarPersoneroView";
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
		listaOpciones.add("Actualizar Personero");
		listaOpciones.add("Registrar Representante");
		listaOpciones.add("Generar Reportes");
		listaOpciones.add("POO1");
		
		
		// Se invoca el m�todo getItems del ComboBox, y se agregan todos los
		// elementos que vienen de la lista de amigos inicial.
		cmbOpciones.getItems().addAll(listaOpciones);
		
		// ---------------------------
		// CODIGO PARA LLENAR EL COMBO DE PERSONEROS
		// ---------------------------
		
		ArrayList<String> lista = colegioObj.listarNombresPersoneros();
		
		if(lista!=null) {
			for(int t=0;t<lista.size();t++) {
				// El metodo get saca un elemento
				// del arraylist. Es como usar el 
				// [i] de un arreglo.
				String nombres = lista.get(t);
				if(!nombres.equals("Yarlin Mercedes")) {
					cmbPersoneros.getItems().add(nombres);
				}
			}
		}
		
		
		// Porcion de codigo si no quiero filtrar elementos
		// cmbPersoneros.getItems().addAll(lista);
		
		
//		ArrayList<Personero> listaPersoneros = colegioObj.listarPersoneros();
//		
//		if(listaPersoneros!=null) {
//			for(int t=0;t<listaPersoneros.size();t++) {
//				Personero p = listaPersoneros.get(t);
//				
//				if(p.getNumeroTarjeton()!=2) {
//					cmbPersoneros.getItems().add(p.getNombre() + " " + p.getApellido());
//				}
//				
//				
//			}
//		}
		
		
		// PORCION DE CODIGO PARA EL LISTVIEW
		
		// Lista es retornada desde el Negocio
		ArrayList<String> listaPers1 = colegioObj.listarNombresPersoneros();
		
		// Esta lista controlara la informacion del ListView, 
		// y por eso se transforma el ArrayList que viene del negocio
		listaPersoneros = FXCollections.observableArrayList();
		listaPersoneros.addAll(listaPers1);
		
		// Asocio al ListView la ObservableList.
		lvPersoneros.setItems(listaPersoneros);
		
		
	}
	
	public void agregarPersoneroAListView(ActionEvent e) {
		String nombres = txtNombrePersonero.getText();
		
		listaPersoneros.add(nombres);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

