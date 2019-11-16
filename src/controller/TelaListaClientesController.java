package controller;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaListaClientesController {

	@FXML
	private Pane TelaListaClientesPane;
	
	private Stage primaryStage = new Stage();
	
	private Scene myScene;
	
	
	public void openGUI() {
		try {
				
		URL mainViewerURL = this.getClass().getClassLoader().getResource("view/TelaListaClientes.fxml");
		
		FXMLLoader loader = new FXMLLoader(mainViewerURL);
		
		TelaListaClientesPane = loader.load();
		
		myScene = new Scene(TelaListaClientesPane);
		
		primaryStage.setScene(myScene);
		primaryStage.setResizable(false);
		
		
		primaryStage.setTitle("Cadastro de Clientes");
	
		primaryStage.show();
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}

	
	
}
