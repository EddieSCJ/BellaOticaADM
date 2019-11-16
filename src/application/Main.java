package application;
	
import java.util.ArrayList;
import java.util.List;

import controller.TelaInicialController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.entities.Cliente;


public class Main extends Application {
	
	public static List<Cliente> clientes = new ArrayList<Cliente>();
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
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
