package application;
	
import java.util.ArrayList;
import java.util.List;

import controller.TelaInicialController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.dao.ClienteDAOJDBC;
import model.entities.Cliente;
import model.entities.OS;


public class Main extends Application {
	
	public static List<Cliente> clientes = new ArrayList<Cliente>();
	public static List<OS> os = new ArrayList<OS>();
	
	
	ClienteDAOJDBC clienteDAOJDBC = new ClienteDAOJDBC();	
	@Override
	public void start(Stage primaryStage) {
		try {
			clientes = clienteDAOJDBC.findAll();

			TelaInicialController tlc = new TelaInicialController();	
			tlc.openGUI();	
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
