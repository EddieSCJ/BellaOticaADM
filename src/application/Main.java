package application;
	
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

import controller.TelaInicialController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.dao.ClienteDAOJDBC;
import model.dao.OsDAOJDBC;
import model.entities.Cliente;
import model.entities.OS;


public class Main extends Application {
	
	public static List<Cliente> clientes = new ArrayList<Cliente>();
	public static List<OS> os = new ArrayList<OS>();
	
	ClienteDAOJDBC clienteDAOJDBC = new ClienteDAOJDBC();	
	OsDAOJDBC osDAOJDBC = new OsDAOJDBC();

	@Override
	public void start(Stage primaryStage) {
		try {
			clientes = clienteDAOJDBC.findAll();
			os = osDAOJDBC.findAll();
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
