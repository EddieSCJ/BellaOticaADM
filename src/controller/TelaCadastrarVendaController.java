package controller;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaCadastrarVendaController {

	@FXML
	Pane TelaCadastrarVendaPane;

	private Stage primaryStage = new Stage();

	private Scene myScene;
	
	public void openGUI() {
		try {

			URL mainViewerURL = this.getClass().getClassLoader().getResource("view/TelaCadastrarVenda.fxml");

			FXMLLoader loader = new FXMLLoader(mainViewerURL);

			TelaCadastrarVendaPane = loader.load();

			myScene = new Scene(TelaCadastrarVendaPane);

			primaryStage.setScene(myScene);
			primaryStage.setResizable(false);

			primaryStage.setTitle("Cadastro de Clientes");

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onSave() {
		
	}
	
	public void onCancel() {
		
	}
	
	
}
