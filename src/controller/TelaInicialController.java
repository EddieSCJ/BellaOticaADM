package controller;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaInicialController {

	@FXML
	Pane cadastrarClientes;
	
	@FXML
	private AnchorPane TelaInicialAnchorPane;
	
	private Stage primaryStage = new Stage();

	private Scene myScene;
	
	
	public void openGUI() {
		try {
				
		URL mainViewerURL = this.getClass().getClassLoader().getResource("view/TelaInicial.fxml");
		
		FXMLLoader loader = new FXMLLoader(mainViewerURL);
		
		TelaInicialAnchorPane = loader.load();
		
		myScene = new Scene(TelaInicialAnchorPane);
		
		primaryStage.setScene(myScene);
		
		primaryStage.setTitle("Bella Ótica inicial");
		primaryStage.setResizable(false);
		
		primaryStage.show();
	}catch(Exception e) {
		e.printStackTrace();
	}

	}
	
	
	public  void onAbrirTelaDeCadastro() {
		
		TelaCadastroClientesController tcc = new TelaCadastroClientesController();
		tcc.openGUI();
	
		Stage stage = (Stage) cadastrarClientes.getScene().getWindow();
		stage.close();

		
	}
	
	public  void onAbrirTelaDeVenda() {
		System.out.println("Abrir");
		}
	
	public void onAbrirListaDeClientes() {
		
		TelaListaClientesController tlc = new TelaListaClientesController();
		tlc.openGUI();
	
		Stage stage = (Stage) cadastrarClientes.getScene().getWindow();
		stage.close();
	}
	
	public  void onAbrirListaDeVendas() {
		System.out.println("Abrir");
	}
	
}
