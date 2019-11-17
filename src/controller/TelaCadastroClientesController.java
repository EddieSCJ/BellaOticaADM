package controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.dao.ClienteDAOJDBC;
import model.dao.DaoFactory;
import model.entities.Cliente;
import model.utils.Alerts;
import model.utils.ConferirDados;
import model.utils.Constraints;
import model.utils.MaskFieldUtil;

public class TelaCadastroClientesController implements Initializable {
	@FXML
	private Pane TelaCadastroPane;

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

	ClienteDAOJDBC clienteDAOJDBC = DaoFactory.createClienteDaojdbc();
	
	private Stage primaryStage = new Stage();

	private Scene myScene;

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

	}

	public void openGUI() {
		try {

			URL mainViewerURL = this.getClass().getClassLoader().getResource("view/TelaCadastroClientes.fxml");

			FXMLLoader loader = new FXMLLoader(mainViewerURL);

			TelaCadastroPane = loader.load();

			myScene = new Scene(TelaCadastroPane);

			primaryStage.setScene(myScene);
			primaryStage.setResizable(false);

			primaryStage.setTitle("Cadastro de Clientes");

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onSave(){
		boolean achou = false;
		for (int i = 0; i < Main.clientes.size(); i++) {
			if(Main.clientes.get(i).getCPF().equalsIgnoreCase(cpfDoCliente.getText())) {
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
				
				Cliente cliente = new Cliente(nome, cPF, new SimpleDateFormat("dd/MM/yyyy").format(new Date()), email, rua, cep, bairro, complemento, cidade, estado, telefone);
				System.out.println(cliente.toString());
				
				clienteDAOJDBC.save(cliente);
				Main.clientes.add(cliente);
				
				onCancel();
				
				Alerts.showAlert("Sucesso", "Cadastro efetuado com sucesso", AlertType.INFORMATION);
				
			
				
			} catch (Exception e) {
				Alerts.showAlert("Ocorreu um erro inesperado", e.getMessage(), AlertType.ERROR);
				
			}
			
		}
	}
	
	public void onCancel() {
		TelaInicialController tic = new TelaInicialController();
		tic.openGUI();
	
		Stage stage = (Stage) nascimentoTF.getScene().getWindow();
		stage.close();
	}
	
}
