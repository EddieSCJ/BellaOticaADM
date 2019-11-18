package controller;


import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import model.dao.ClienteDAOJDBC;
import model.dao.DaoFactory;
import model.dao.OsDAOJDBC;
import model.entities.Cliente;
import model.entities.OS;
import model.utils.Alerts;
import model.utils.ConferirDados;
import model.utils.Constraints;
import model.utils.MaskFieldUtil;

public class TelaVerClienteController implements Initializable {

	
	
		@FXML
		private Pane TelaCadastroPane;

		@FXML
		private TextField nosSearch;
		
		@FXML
		private TextField vendedorSearch;
		
		@FXML
		private TextField dataSearch;
		
		@FXML
		private TextField nomeDoCliente;

		@FXML
		private TextField cpfDoCliente;

		@FXML
		private TextField telefoneDoCliente;

		@FXML
		private TextField emailDoCliente;

		@FXML
		private DatePicker nascimentoDoCliente;

		@FXML
		private TextField ruaDoCliente;

		@FXML
		private TextField bairroDoCliente;

		@FXML
		private TextField cepDoCliente;

		@FXML
		private TextField complementoDoCliente;

		@FXML
		private TextField cidadeDoCliente;

		@FXML
		private TextField estadoDoCliente;

		@FXML
		private TextField nascimentoTF;

		@FXML
		private TableView<OS> tbviewOS;
		
		@FXML
		private TableColumn<OS, Integer> nosColumn;
		
		@FXML
		private TableColumn<OS, Integer> vendedorColumn;
		
		@FXML
		private TableColumn<OS, Integer> dataColumn;
		
		ClienteDAOJDBC clienteDAOJDBC = DaoFactory.createClienteDaojdbc();
		
		private Stage primaryStage = new Stage();

		private Scene myScene;

		private String cpfValido;
		
		public void onDataSelecionada() throws ParseException {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			
			String nasc = nascimentoDoCliente.getValue().toString();	
			Date date1 = sdf1.parse(nasc);
			
			nascimentoTF.setText(sdf.format(date1));
		}
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			MaskFieldUtil.cpfField(cpfDoCliente);
			MaskFieldUtil.cepField(cepDoCliente);
			MaskFieldUtil.foneField(telefoneDoCliente);
			
			
			tbviewOS.setRowFactory( tv -> {
			    TableRow<OS> row = new TableRow<>();
			    row.setOnMouseClicked(event -> {
			        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
			        	String AUDIO_URL = this.getClass().getClassLoader().getResource("resources/click.wav").toString();
			    		AudioClip clip = clip = new AudioClip(AUDIO_URL);
			    		clip.play();
			    		
			            OS rowData = row.getItem();
			            TelaVisualizarVendaController tvvc = new TelaVisualizarVendaController();
			            TelaListarVendaController.id = rowData.getCodos();
			            
			          
			            tvvc.openGUI(rowData.getCodos());
			        }
			    });
			    return row ;
			});
			
			nascimentoDoCliente.setValue(LocalDate.now());
		
			Constraints.setTextFieldMaxLength(nomeDoCliente, 50);
			Constraints.setTextFieldMaxLength(cpfDoCliente, 14);
			Constraints.setTextFieldMaxLength(telefoneDoCliente, 15);
			Constraints.setTextFieldMaxLength(ruaDoCliente, 40);
			Constraints.setTextFieldMaxLength(bairroDoCliente, 40);
			Constraints.setTextFieldMaxLength(cepDoCliente, 9);
			Constraints.setTextFieldMaxLength(complementoDoCliente, 40);
			Constraints.setTextFieldMaxLength(cidadeDoCliente, 40);
			Constraints.setTextFieldMaxLength(estadoDoCliente, 2);

			Cliente cliente = clienteDAOJDBC.findByID(TelaListaClientesController.id);
			
			bairroDoCliente.setText(cliente.getBairro());
			cepDoCliente.setText(cliente.getCEP());
			cidadeDoCliente.setText(cliente.getCidade());
			complementoDoCliente.setText(cliente.getComplemento());
			cpfDoCliente.setText(cliente.getCPF());
			emailDoCliente.setText(cliente.getEmail());
			nascimentoTF.setText(new SimpleDateFormat("dd/MM/yyyy").format(cliente.getBirthDate()));
			nomeDoCliente.setText(cliente.getName());
			ruaDoCliente.setText(cliente.getRua());
			telefoneDoCliente.setText(cliente.getTelefone());
	
			nosColumn.setCellValueFactory(new PropertyValueFactory<>("codos"));

			vendedorColumn.setCellValueFactory(new PropertyValueFactory<>("nomeVendedor"));
			dataColumn.setCellValueFactory(new PropertyValueFactory<>("dataAtual"));
			
			tbviewOS.setItems(OSList());	
			
			if(tbviewOS.getItems().isEmpty()) {
				tbviewOS.setEditable(false);
			}else {
				tbviewOS.setEditable(true);
			}
		}

		
		public ObservableList<OS> OSList(){
			ObservableList<OS> osList = FXCollections.observableArrayList();
			
			List<OS> oessis = new OsDAOJDBC().findByClientID(TelaListaClientesController.id);
			
				for (OS os : oessis) {
					osList.add(os);
				}

			return osList;
			
		}
		
		

		public ObservableList<OS> specificOSList(String content){
			ObservableList<OS> osList = FXCollections.observableArrayList();
			
			List<OS> oessis = new OsDAOJDBC().findByClientID(TelaListaClientesController.id);
			
			
				for (OS os1 : oessis) {
					if(os1.getDataAtual().contains(content)) {
						osList.add(os1);
					}
				}

			return osList;
			
		}
		
		
		public void openGUI(int aidi) {
			try {

				URL mainViewerURL = this.getClass().getClassLoader().getResource("view/TelaVerCliente.fxml");

				FXMLLoader loader = new FXMLLoader(mainViewerURL);

				TelaCadastroPane = loader.load();

				myScene = new Scene(TelaCadastroPane);

				primaryStage.setScene(myScene);
				primaryStage.setResizable(false);

				primaryStage.setTitle("Ficha do Cliente");

				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void onAtualizar(){
			String AUDIO_URL = this.getClass().getClassLoader().getResource("resources/click.wav").toString();
			AudioClip clip = clip = new AudioClip(AUDIO_URL);
			clip.play();
			
			try {
			boolean achou = false;
			for (int i = 0; i < Main.clientes.size(); i++) {
				if(Main.clientes.get(i).getCPF().equalsIgnoreCase(cpfDoCliente.getText()) && Main.clientes.get(i).getCPF().equalsIgnoreCase(cpfValido)) {
					achou = true;
				}
			}
			
			if(nomeDoCliente.getText().equals(null) || nomeDoCliente.getText().equals("")) {
				Alerts.showAlert("Nome do cliente", "Preencha o nome do cliente para continuar", AlertType.INFORMATION);
			}else if(cpfDoCliente.getText().equals(null) || cpfDoCliente.getText().equals("")) {
				Alerts.showAlert("CPF vazio", "Preencha o campo cpf para continuar", AlertType.INFORMATION);
			}else if(!ConferirDados.conferirCPF(cpfDoCliente.getText())) {
				Alerts.showAlert("CPF inválido", "Digite um CPF válido para continuar", AlertType.INFORMATION);
			}else if(nascimentoTF.getText().equalsIgnoreCase(new SimpleDateFormat("dd/MM/yyyy").format(new Date()))) {
				Alerts.showAlert("Data de Nascimento", "Selecione uma data de Nascimento", AlertType.INFORMATION);
			}else if (achou) {
				Alerts.showAlert("CPF já cadastrado", "CPF já está cadastrado, digite um CPF válido", AlertType.INFORMATION);
			}
			else {
				try {
					String nome = nomeDoCliente.getText();
					String cPF = cpfDoCliente.getText();
					String telefone = telefoneDoCliente.getText();
					String email = emailDoCliente.getText();
					String nascimento = nascimentoTF.getText();
					String rua = ruaDoCliente.getText();
					String bairro = bairroDoCliente.getText();
					String cep = cepDoCliente.getText();
					String cidade = cidadeDoCliente.getText();
					String estado = estadoDoCliente.getText();
					String complemento = complementoDoCliente.getText();
					
					Cliente cliente = new Cliente(nome, cPF, nascimento, email, rua, cep, bairro, complemento, cidade, estado, telefone);
					System.out.println(cliente.toString());
					
					cliente.setCodCliente(TelaListaClientesController.id);
					
					clienteDAOJDBC.update(cliente);
					

					for (int i = 0; i < Main.clientes.size(); i++) {
						if(Main.clientes.get(i).getCodCliente() == cliente.getCodCliente()) {
							Main.os.remove(i);
						}
					}
					
					Main.clientes.add(cliente);
					
					
					TelaVerClienteController tvcc = new TelaVerClienteController();
					tvcc.openGUI(cliente.getCodCliente());
					
					Stage stage = (Stage) nascimentoTF.getScene().getWindow();
					stage.close();
					
					Alerts.showAlert("Sucesso", "Cadastro atualizado com sucesso", AlertType.INFORMATION);
					
				
					
				} catch (Exception e) {
					Alerts.showAlert("Deu ruim", "Ligue para (79) 998968393 \n para reportar o erro", AlertType.INFORMATION);

				}
				
			}
			}catch (Exception e) {
				Alerts.showAlert("Valores errados", "Há valores errados, \n confira se você não digitou letras \n no lugar de números e vice versa", AlertType.INFORMATION);

			}
				
		}
		
		public void onSair() {
			String AUDIO_URL = this.getClass().getClassLoader().getResource("resources/click.wav").toString();
			AudioClip clip = clip = new AudioClip(AUDIO_URL);
			clip.play();
			
			TelaListaClientesController tlcc = new TelaListaClientesController();
			tlcc.openGUI();
			
			Stage stage = (Stage) nascimentoTF.getScene().getWindow();
			stage.close();
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
		
		public void onSearchNOS() {

			tbviewOS.setItems(specificNOSList(nosSearch.getText()));
		}
		
		public void onSearchData() {

			tbviewOS.setItems(specificDataOSList(dataSearch.getText()));
		}
		
		
		public void onSearchVendedor() {

			tbviewOS.setItems(specificVendedorOSList(vendedorSearch.getText()));
		}
		
		
		public void onDelete() {
			String AUDIO_URL = this.getClass().getClassLoader().getResource("resources/click.wav").toString();
			AudioClip clip = clip = new AudioClip(AUDIO_URL);
			clip.play();
			
			String clienteNome = " Ninguém";
			clienteDAOJDBC.delete(TelaListaClientesController.id);
			for (int i = 0; i < Main.clientes.size(); i++) {
				if(Main.clientes.get(i).getCodCliente() == TelaListaClientesController.id) {
					clienteNome = Main.clientes.get(i).getName();
					Main.os.remove(i);
				}
			}
			
			onSair();
			
			Alerts.showAlert("Cliente deletado", "VOCÊ DELETOU "+clienteNome
					, AlertType.INFORMATION);
			
		}
		
}
