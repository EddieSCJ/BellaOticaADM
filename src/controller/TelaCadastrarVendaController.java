package controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.dao.ClienteDAOJDBC;
import model.dao.OSDAOJDBC;
import model.entities.Cliente;
import model.entities.OS;
import model.utils.Alerts;
import model.utils.MaskFieldUtil;

public class TelaCadastrarVendaController implements Initializable {

	Cliente cliente = new Cliente();
	
	@FXML
	Pane TelaCadastrarVendaPane;

	@FXML
	private TableView<Cliente> tbViewCliente;
	
	@FXML
	private TableColumn<Cliente, String> nameColumn;
	
	@FXML
	private TableColumn<Cliente, String> cpfColumn;
	
	@FXML 
	private TextField searchFieldTF;
	
	@FXML 
	private TextField nomeDoCliente;
	
	@FXML 
	private TextField cpfDoCliente;
	
	@FXML 
	private TextField telefoneDoCliente;
	
	@FXML 
	private TextField nomeVendedor;
	
	@FXML 
	private TextField total;
	
	@FXML 
	private TextField sinal;

	@FXML 
	private TextField restoDaVenda;
	
	@FXML 
	private DatePicker dpDataAtual;
	
	@FXML 
	private DatePicker dpDataEntrega;
	
	@FXML 
	private TextField dataAtual;
	
	@FXML 
	private TextField dataEntrega;
	
	@FXML 
	private TextField enderecoDoCliente;
	
	@FXML 
	private TextField tipoArmacao;
	
	@FXML 
	private TextField tipoLente;
	
	@FXML 
	private TextField longeODCIL;
	
	@FXML
	private TextField longeODEIX;
	
	@FXML
	private TextField longeODESF;
	
	@FXML
	private TextField longeOECIL;
	
	@FXML
	private TextField longeOEDP;
	
	@FXML
	private TextField longeODEEX;
	
	@FXML
	private TextField longeODDP;
	
	@FXML
	private TextField longeOEEIX;
	
	@FXML
	private TextField longeOEESF;
	
	
	@FXML 
	private TextField pertoODCIL;
	
	@FXML
	private TextField pertoODEIX;
	
	@FXML
	private TextField pertoODESF;
	
	@FXML
	private TextField pertoOECIL;
	
	@FXML
	private TextField pertoOEDP;
	
	@FXML
	private TextField pertoODEEX;
	
	@FXML
	private TextField pertoODDP;
	
	@FXML
	private TextField pertoOEEIX;
	
	@FXML
	private TextField pertoOEESF;
	
	
	@FXML
	private CheckBox cartao;

	@FXML
	private CheckBox dinheiro;

	@FXML
	private CheckBox entregue;

	@FXML
	private CheckBox pronto;
	
	ClienteDAOJDBC clienteDAOJDBC = new ClienteDAOJDBC();
	

	OSDAOJDBC osDAOJDBC = new OSDAOJDBC();
	
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

	public void onDataEntregaSelecionada() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
		String dataEntregaString = dpDataEntrega.getValue().toString();	
		Date date1 = sdf1.parse(dataEntregaString);
		
		dataEntrega.setText(sdf.format(date1));
	}
	
	public void onDataAtualSelecionada() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
		String dataEntregaString = dpDataAtual.getValue().toString();	
		Date date1 = sdf1.parse(dataEntregaString);
		
		dataAtual.setText(sdf.format(date1));
	}
	
	
	public void onSave() throws ParseException {
		if(cpfDoCliente.getText().isEmpty() || nomeDoCliente.getText().isEmpty() || tipoArmacao.getText().isEmpty()
			|| tipoLente.getText().isEmpty() || nomeVendedor.getText().isEmpty() || total.getText().isEmpty()
			|| sinal.getText().isEmpty()) {
			Alerts.showAlert("Preencha todos campos corretamente", "Selecione um cliente e preencha todos os campos com asterisco", AlertType.INFORMATION);
		} else {
			OS os = new OS();
			os.setCartao(cartao.isSelected());
			os.setCliente(cliente);
			os.setDataAtual(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			
			String dataEntregaString = dpDataEntrega.getValue().toString();	
			Date date1 = sdf1.parse(dataEntregaString);
			
			dataEntrega.setText(sdf.format(date1));
			
			os.setDataEntrega(sdf.format(date1));
			os.setDinheiro(dinheiro.isSelected());
			os.setEntregue(entregue.isSelected());
			os.setLongeODCIL(Double.parseDouble(longeODCIL.getText()));
			os.setLongeODDP(Double.parseDouble(longeODDP.getText()));
			os.setLongeODEIX(Double.parseDouble(longeODEIX.getText()));
			os.setLongeODESF(Double.parseDouble(longeODESF.getText()));
			os.setLongeOECIL(Double.parseDouble(longeOECIL.getText()));
			os.setLongeOEDP(Double.parseDouble(longeOEDP.getText()));
			os.setLongeOEEIX(Double.parseDouble(longeOEEIX.getText()));
			os.setLongeOEESF(Double.parseDouble(longeOEESF.getText()));

			os.setPertoODCIL(Double.parseDouble(pertoODCIL.getText()));
			os.setPertoODDP(Double.parseDouble(pertoODDP.getText()));
			os.setPertoODEIX(Double.parseDouble(pertoODEIX.getText()));
			os.setPertoODESF(Double.parseDouble(pertoODESF.getText()));
			os.setPertoOECIL(Double.parseDouble(pertoOECIL.getText()));
			os.setPertoOEDP(Double.parseDouble(pertoOEDP.getText()));
			os.setPertoOEEIX(Double.parseDouble(pertoOEEIX.getText()));
			os.setPertoOEESF(Double.parseDouble(pertoOEESF.getText()));
			
			
			os.setPronto(pronto.isSelected());
			os.setRestoDaVenda(Double.parseDouble(restoDaVenda.getText()));
			os.setSinalDaVenda(Double.parseDouble(sinal.getText()));
			os.setTipoArmacao(tipoArmacao.getText());
			os.setTipoLente(tipoLente.getText());
			os.setTotalDaVenda(Double.parseDouble(total.getText()));
			
			osDAOJDBC.save(os);
			
			Main.os.add(os);
			
			onCancel();
			
			Alerts.showAlert("Sucesso", "Cadastro efetuado com sucesso", AlertType.INFORMATION);
			
		}
		
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//Main.clientes = clienteDAOJDBC.findAll();
		longeODCIL.setText("0");
		longeODDP.setText("0");
		longeODEIX.setText("0");
		longeODESF.setText("0");
		longeOECIL.setText("0");
		longeOEDP.setText("0");
		longeOEEIX.setText("0");
		longeOEESF.setText("0");
		
		pertoODCIL.setText("0");;
		pertoODDP.setText("0");;
		pertoODEIX.setText("0");;
		pertoODESF.setText("0");;
		pertoOECIL.setText("0");;
		pertoOEDP.setText("0");;
		pertoOEEIX.setText("0");;
		pertoOEESF.setText("0");;
		
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
		tbViewCliente.setItems(specificClientList(searchFieldTF.getText()));
	}

	public void onMouseClicked() {
		cliente = tbViewCliente.getSelectionModel().getSelectedItem();
		cpfDoCliente.setText(cliente.getCPF());
		nomeDoCliente.setText(cliente.getName());
		if(!cliente.getRua().isEmpty() && !cliente.getRua().equalsIgnoreCase("") && !cliente.getRua().equalsIgnoreCase(null) && cliente.getRua() != null) {
			enderecoDoCliente.setText( cliente.getRua()+", "+cliente.getBairro()+" - "+cliente.getCidade()+"/"+cliente.getEstado()+" "+cliente.getCEP());
		}
		if(!cliente.getTelefone().isEmpty() && !cliente.getTelefone().equalsIgnoreCase("") && !cliente.getTelefone().equalsIgnoreCase(null) && cliente.getTelefone() != null)
			System.out.println(cliente.getTelefone());
			telefoneDoCliente.setText(cliente.getTelefone());
		
	}
	
}
