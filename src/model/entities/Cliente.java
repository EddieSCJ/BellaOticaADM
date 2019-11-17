package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.Alert.AlertType;
import model.utils.Alerts;

/***
 * 
 * @author EddieSCJ
 *
 */

public class Cliente {

	private int codCliente;
	private String name;
	private String CPF;
	private Date birthDate;
	private String email;
	private String rua;
	private String CEP;
	private String bairro;
	private String complemento;
	private String telefone;
	private String cidade;
	private String estado;
	
	public Cliente() {
		
	}
	
	public Cliente(String name, String cPF, String birthDate, String email, String rua, String cEP, String bairro,
			String complemento, String cidade, String Estado, String telefone) {
			this.setName(name);
			this.setBairro(bairro);
			this.setBirthDate(birthDate);
			this.setCEP(cEP);
			this.setComplemento(complemento);
			this.setCPF(cPF);
			this.setEmail(email);
			this.setRua(rua);
			this.setTelefone(telefone);
			this.setCidade(cidade);
			this.setEstado(Estado);
	}
	
	
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		try {
			this.birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Alerts.showAlert("Nascimento inválido", "Data de nascimento inválida", AlertType.ERROR);	
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email.equals(null)) {
			this.email = "";
		}else {
			this.email = email;
		}
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		if(rua.equals(null)) {
			this.rua = "";
		}else {
			this.rua = rua;
		}}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		if(cEP.equals(null)) {
			this.CEP = "";
		}else {
			this.CEP = cEP;
		}}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		if(bairro.equals(null)) {
			this.bairro = "";
		}else {
			this.bairro = bairro;
		}}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		if(complemento.equals(null)) {
			this.complemento = "";
		}else {
			this.complemento = complemento;
		}	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone.equals(null)) {
			this.email = "";
		}else {
			this.telefone = telefone;
		}	}

	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", name=" + name + ", CPF=" + CPF + ", birthDate=" + birthDate
				+ ", email=" + email + ", rua=" + rua + ", CEP=" + CEP + ", bairro=" + bairro + ", complemento="
				+ complemento + ", telefone=" + telefone + ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	
	
	
	
	
	
}
