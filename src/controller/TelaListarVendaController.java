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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import model.entities.Cliente;
import model.entities.OS;

public class TelaListarVendaController implements Initializable {

	@FXML
	Pane cadastrarClientes;
	
	@FXML
	private Pane TelaListarVendaPane;
	
	@FXML
	private TextField nosSearch;
	
	@FXML
	private TextField dataSearch;
	
	@FXML
	private TextField vendedorSearch;
	
	@FXML
	private TextField clienteSearch;
	
	@FXML
	private TextField cpfSearch;
	
	@FXML
	private TableView<OS> tbviewOS;
	
	@FXML
	private TableColumn<OS, Integer> nosColumn;;
	
	@FXML
	private TableColumn<OS, String> vendedorColumn;
	
	@FXML
	private TableColumn<OS, String> dataColumn;
	
	@FXML
	private TableColumn<OS, String> clienteColumn;
	
	@FXML
	private TableColumn<OS, String> cpfColumn;
	
	
	@FXML
	private Button cancelButton;
	
	private Stage primaryStage = new Stage();

	private Scene myScene;
	
	public static Integer id;
	
	public void openGUI() {
		try {
				
		URL mainViewerURL = this.getClass().getClassLoader().getResource("view/TelaListarVendas.fxml");
		
		FXMLLoader loader = new FXMLLoader(mainViewerURL);
		
		TelaListarVendaPane = loader.load();
		
		myScene = new Scene(TelaListarVendaPane);
		
		primaryStage.setScene(myScene);
		
		primaryStage.setTitle("Listar vendas");
		primaryStage.setResizable(false);
		
		primaryStage.show();
	}catch(Exception e) {
		e.printStackTrace();
	}

	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		tbviewOS.setRowFactory( tv -> {
		    TableRow<OS> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		            OS rowData = row.getItem();
		            TelaVisualizarVendaController tvvc = new TelaVisualizarVendaController();
		            this.id = rowData.getCodos();
		            
		            Stage stage = (Stage) tbviewOS.getScene().getWindow();
		    		stage.close();
//		            System.out.println(rowData.getCodos());
		            tvvc.openGUI(rowData.getCodos());
		        }
		    });
		    return row ;
		});
		
		System.out.println("AAAAAAAAa");
		nosColumn.setCellValueFactory(new PropertyValueFactory<>("codos"));
		vendedorColumn.setCellValueFactory(new PropertyValueFactory<>("nomeVendedor"));
		dataColumn.setCellValueFactory(new PropertyValueFactory<>("dataAtual"));
		clienteColumn.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
		cpfColumn.setCellValueFactory(new PropertyValueFactory<>("cpfCliente"));
		
		tbviewOS.setItems(OSList());	
		
		if(tbviewOS.getItems().isEmpty()) {
			tbviewOS.setEditable(false);
		}else {
			tbviewOS.setEditable(true);
		}
	}
	
	public ObservableList<OS> OSList(){
		ObservableList<OS> osList = FXCollections.observableArrayList();
		
			for (OS os : Main.os) {
				osList.add(os);
			}

		return osList;
		
	}
	
	public ObservableList<OS> specificDataOSList(String content){
		ObservableList<OS> osList = FXCollections.observableArrayList();
		
			for (OS os1 : Main.os) {
				if(os1.getDataAtual().contains(content)) {
					osList.add(os1);
				}
			}

		return osList;
		
	}

	public ObservableList<OS> specificNOSList(String content){
		ObservableList<OS> osList = FXCollections.observableArrayList();
		
			for (OS os1 : Main.os) {
				if(os1.getCodos().toString().contains(content)) {
					osList.add(os1);
				}
			}

		return osList;
		
	}
	
	public ObservableList<OS> specificVendedorOSList(String content){
		ObservableList<OS> osList = FXCollections.observableArrayList();
		
			for (OS os1 : Main.os) {
				if(os1.getNomeVendedor().contains(content)) {
					osList.add(os1);
				}
			}

		return osList;
		
	}
	
	public ObservableList<OS> specificClienteOSList(String content){
		ObservableList<OS> osList = FXCollections.observableArrayList();
		
			for (OS os1 : Main.os) {
				if(os1.getNomeCliente().contains(content)) {
					osList.add(os1);
				}
			}

		return osList;
		
	}
	
	public ObservableList<OS> specificCPFOSList(String content){
		ObservableList<OS> osList = FXCollections.observableArrayList();
		
			for (OS os1 : Main.os) {
				if(os1.getCpfCliente().contains(content)) {
					osList.add(os1);
				}
			}

		return osList;
		
	}
	
	public void onSearchNOS() {

		tbviewOS.setItems(specificNOSList(nosSearch.getText()));
	}
	
	public void onSearchData() {

		tbviewOS.setItems(specificDataOSList(dataSearch.getText()));
	}
	
	
	public void onSearchVendedor() {

		tbviewOS.setItems(specificVendedorOSList(vendedorSearch.getText()));
	}
	
	public void onSearchCliente() {

		tbviewOS.setItems(specificClienteOSList(clienteSearch.getText()));
	}

	public void onSearchCPF() {

		tbviewOS.setItems(specificCPFOSList(cpfSearch.getText()));
	}
	
	
	public void onCancel() {
		String AUDIO_URL = this.getClass().getClassLoader().getResource("resources/click.wav").toString();
		AudioClip clip = clip = new AudioClip(AUDIO_URL);
		clip.play();
		
		TelaInicialController tic = new TelaInicialController();
		tic.openGUI();
	
		Stage stage = (Stage) tbviewOS.getScene().getWindow();
		stage.close();
	}
}
