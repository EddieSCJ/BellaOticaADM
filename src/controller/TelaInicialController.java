package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.dao.ClienteDAOJDBC;
import model.dao.OsDAOJDBC;

public class TelaInicialController implements Initializable{

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
		TelaCadastrarVendaController tcv = new TelaCadastrarVendaController();
		tcv.openGUI();
	
		Stage stage = (Stage) cadastrarClientes.getScene().getWindow();
		stage.close();
		}
	
	public void onAbrirListaDeClientes() {
		
		TelaListaClientesController tlc = new TelaListaClientesController();
		tlc.openGUI();
	
		Stage stage = (Stage) cadastrarClientes.getScene().getWindow();
		stage.close();
	}
	
	public  void onAbrirListaDeVendas() {
		TelaListarVendaController tlvc = new TelaListarVendaController();
		tlvc.openGUI();
		
		Stage stage = (Stage) cadastrarClientes.getScene().getWindow();
		stage.close();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ClienteDAOJDBC clienteDAOJDBC = new ClienteDAOJDBC();	
		OsDAOJDBC osDAOJDBC = new OsDAOJDBC();

		Main.os = osDAOJDBC.findAll();
		Main.clientes = clienteDAOJDBC.findAll();
	}
	
}
