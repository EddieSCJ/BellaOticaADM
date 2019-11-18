package application;
	
import java.awt.TrayIcon.MessageType;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.TelaInicialController;
import javafx.application.Application;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import model.dao.ClienteDAOJDBC;
import model.dao.OsDAOJDBC;
import model.entities.Cliente;
import model.entities.OS;
import model.utils.Alerts;


public class Main extends Application {
	
	boolean firstTime = true;
	
	public static List<Cliente> clientes = new ArrayList<Cliente>();
	public static List<OS> os = new ArrayList<OS>();

	AudioClip clip;
	ClienteDAOJDBC clienteDAOJDBC = new ClienteDAOJDBC();	
	OsDAOJDBC osDAOJDBC = new OsDAOJDBC();

	@Override
	public void start(Stage primaryStage) {
	
		Thread thread = new Thread(() -> {
			try {
				String message = "Olá, estamos sincrononizando seus \n dados, por favor aguarde até o fim \n da música";
				JOptionPane.showMessageDialog(null, message);
			} catch (Exception e) {
				e.printStackTrace(); //Print the exception ( we want to know , not hide below our finger , like many developers do...)
			}
		});
		
		thread.setDaemon(false);
		
		thread.start();
	
		try {
		
		String AUDIO_URL = this.getClass().getClassLoader().getResource("resources/musica_relaxante.wav").toString();
		clip = new AudioClip(AUDIO_URL);
		clip.play();
		
	
		
		if(firstTime) {
		System.out.println("Oi primeira vez");
		
		
		clientes = clienteDAOJDBC.findAll();
		os = osDAOJDBC.findAll();
		
		firstTime = false;
		
		}
		
		TelaInicialController tlc = new TelaInicialController();	
		tlc.openGUI();	
		
		Alerts.showAlert("Dados sincronizados com sucesso", "Ebaaa!! conseguimos sincronizar, sem erros", AlertType.INFORMATION);
		
		clip.stop();
	} catch(Exception e) {

		Alerts.showAlert("Erro na sincronização", "Verifique sua conexão com a internet, \n caso não funcione ligue para \n (79) 9998968393 para reportar o erro", AlertType.INFORMATION);
	}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
