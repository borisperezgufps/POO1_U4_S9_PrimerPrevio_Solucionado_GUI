package poo1.elecciones.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrincipalController {

	public void registrarPersonero(ActionEvent e){
		
		Stage stage = obtenerStage(e);
		stage.close();
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().
					getResource("/poo1/elecciones/views/RegistrarPersoneroView.fxml"));
			
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

