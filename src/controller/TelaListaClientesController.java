package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.dao.ClienteDAOJDBC;
import model.dao.DaoFactory;
import model.entities.Cliente;
import model.entities.OS;

public class TelaListaClientesController implements Initializable {

	@FXML
	private Pane TelaListaClientesPane;
	
	@FXML
	private TableView<Cliente> tbViewCliente;
	
	@FXML
	private TableColumn<Cliente, String> nameColumn;
	
	@FXML
	private TableColumn<Cliente, String> cpfColumn;
	
	@FXML
	private TextField searchField;
	
	private Stage primaryStage = new Stage();
	
	private Scene myScene;
	
	public static int id;
	
	ClienteDAOJDBC clienteDAOJDBC = DaoFactory.createClienteDaojdbc();
	
	public void openGUI() {
		try {
				
		URL mainViewerURL = this.getClass().getClassLoader().getResource("view/TelaListaClientes.fxml");
		
		FXMLLoader loader = new FXMLLoader(mainViewerURL);
		
		TelaListaClientesPane = loader.load();
		
		myScene = new Scene(TelaListaClientesPane);
		
		primaryStage.setScene(myScene);
		primaryStage.setResizable(false);
		
		
		primaryStage.setTitle("Lista de Clientes");
	
		primaryStage.show();
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}


	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//Main.clientes = clienteDAOJDBC.findAll();
		
		tbViewCliente.setRowFactory( tv -> {
		    TableRow<Cliente> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		            Cliente rowData = row.getItem();
		            TelaVerClienteController tvcc = new TelaVerClienteController();
		            this.id = rowData.getCodCliente();
		            
		            Stage stage = (Stage) tbViewCliente.getScene().getWindow();
		    		stage.close();
//		            System.out.println(rowData.getCodos());
		            tvcc.openGUI(rowData.getCodCliente());
		        }
		    });
		    return row ;
		});
		
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));		
		cpfColumn.setCellValueFactory(new PropertyValueFactory<>("CPF"));
	
		tbViewCliente.setItems(clientList());
		
	}
	
	public ObservableList<Cliente> clientList(){
		ObservableList<Cliente> clientList = FXCollections.observableArrayList();
		
			for (Cliente cliente : Main.clientes) {
				clientList.add(cliente);
			}

		return clientList;
		
	}
	
	public ObservableList<Cliente> specificClientList(String content){
		ObservableList<Cliente> clientList = FXCollections.observableArrayList();
		
			for (Cliente cliente : Main.clientes) {
				if(cliente.getName().contains(content)) {
					clientList.add(cliente);
				}
			}

		return clientList;
		
	}
	
	public void onCancel() {
		TelaInicialController tic = new TelaInicialController();
		tic.openGUI();
	
		Stage stage = (Stage) tbViewCliente.getScene().getWindow();
		stage.close();
	}
	
	public void onSearch() {

		tbViewCliente.setItems(specificClientList(searchField.getText()));
	}

	
	
}
