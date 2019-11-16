package model.entities;

import java.util.Date;

/***
 * 
 * @author EddieSCJ
 *
 */

public class Cliente {

	private String name;
	private String CPF;
	private Date birthDate;
	private String email;
	private String rua;
	private String CEP;
	private String bairro;
	private String complemento;
	private String telefone;
	
	
	
	public Cliente(String name, String cPF, Date birthDate, String email, String rua, String cEP, String bairro,
			String complemento, String telefone) {
		super();
		this.name = name;
		CPF = cPF;
		this.birthDate = birthDate;
		this.email = email;
		this.rua = rua;
		CEP = cEP;
		this.bairro = bairro;
		this.complemento = complemento;
		this.telefone = telefone;
	
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
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	
	
}
