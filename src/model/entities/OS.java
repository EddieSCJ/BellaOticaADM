package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OS {

	private Cliente cliente;
	
	private Integer codos;
	private String tipoArmacao;
	private String tipoLente;
	private double longeODESF;
	private double longeOEESF;
	private double longeODEIX;
	private double longeOEEIX;
	private double longeODCIL;
	private double longeOECIL;
	private double longeODDP;
	private double longeOEDP;
	private double pertoODESF;
	private double pertoOEESF;
	private double pertoODEIX;
	private double pertoOEEIX;
	private double pertoODCIL;
	private double pertoOECIL;
	private double pertoODDP;
	private double pertoOEDP;
	private String nomeVendedor;
	private double totalDaVenda;
	private double sinalDaVenda;
	private double restoDaVenda;
	private String dataEntrega;
	private String dataAtual;
	private boolean cartao;
	private boolean dinheiro;
	private boolean entregue;
	private boolean pronto;
	
	
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getTipoArmacao() {
		return tipoArmacao;
	}
	public void setTipoArmacao(String tipoArmacao) {
		this.tipoArmacao = tipoArmacao;
	}
	public String getTipoLente() {
		return tipoLente;
	}
	public void setTipoLente(String tipoLente) {
		this.tipoLente = tipoLente;
	}
	public double getLongeODESF() {
		return longeODESF;
	}
	public void setLongeODESF(double longeODESF) {
		this.longeODESF = longeODESF;
	}
	public double getLongeOEESF() {
		return longeOEESF;
	}
	public void setLongeOEESF(double longeOEESF) {
		this.longeOEESF = longeOEESF;
	}
	public double getLongeODEIX() {
		return longeODEIX;
	}
	public void setLongeODEIX(double longeODEIX) {
		this.longeODEIX = longeODEIX;
	}
	public double getLongeOEEIX() {
		return longeOEEIX;
	}
	public void setLongeOEEIX(double longeOEEIX) {
		this.longeOEEIX = longeOEEIX;
	}
	public double getLongeODCIL() {
		return longeODCIL;
	}
	public void setLongeODCIL(double longeODCIL) {
		this.longeODCIL = longeODCIL;
	}
	public double getLongeOECIL() {
		return longeOECIL;
	}
	public void setLongeOECIL(double longeOECIL) {
		this.longeOECIL = longeOECIL;
	}
	public double getLongeODDP() {
		return longeODDP;
	}
	public void setLongeODDP(double longeODDP) {
		this.longeODDP = longeODDP;
	}
	public double getLongeOEDP() {
		return longeOEDP;
	}
	public void setLongeOEDP(double longeOEDP) {
		this.longeOEDP = longeOEDP;
	}
	public double getPertoODESF() {
		return pertoODESF;
	}
	public void setPertoODESF(double pertoODESF) {
		this.pertoODESF = pertoODESF;
	}
	public double getPertoOEESF() {
		return pertoOEESF;
	}
	public void setPertoOEESF(double pertoOEESF) {
		this.pertoOEESF = pertoOEESF;
	}
	public double getPertoODEIX() {
		return pertoODEIX;
	}
	public void setPertoODEIX(double pertoODEIX) {
		this.pertoODEIX = pertoODEIX;
	}
	public double getPertoOEEIX() {
		return pertoOEEIX;
	}
	public void setPertoOEEIX(double pertoOEEIX) {
		this.pertoOEEIX = pertoOEEIX;
	}
	public double getPertoODCIL() {
		return pertoODCIL;
	}
	public void setPertoODCIL(double pertoODCIL) {
		this.pertoODCIL = pertoODCIL;
	}
	public double getPertoOECIL() {
		return pertoOECIL;
	}
	public void setPertoOECIL(double pertoOECIL) {
		this.pertoOECIL = pertoOECIL;
	}
	public double getPertoODDP() {
		return pertoODDP;
	}
	public void setPertoODDP(double pertoODDP) {
		this.pertoODDP = pertoODDP;
	}
	public double getPertoOEDP() {
		return pertoOEDP;
	}
	public void setPertoOEDP(double pertoOEDP) {
		this.pertoOEDP = pertoOEDP;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	public double getTotalDaVenda() {
		return totalDaVenda;
	}
	public void setTotalDaVenda(double totalDaVenda) {
		this.totalDaVenda = totalDaVenda;
	}
	public double getSinalDaVenda() {
		return sinalDaVenda;
	}
	public void setSinalDaVenda(double sinalDaVenda) {
		this.sinalDaVenda = sinalDaVenda;
	}
	public double getRestoDaVenda() {
		return restoDaVenda;
	}
	public void setRestoDaVenda(double restoDaVenda) {
		this.restoDaVenda = restoDaVenda;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) throws ParseException {
		this.dataEntrega = dataEntrega;
	}
	public String getDataAtual() {
		return dataAtual;
	}
	public void setDataAtual(String dataAtual) throws ParseException {
		this.dataAtual = dataAtual;
		
	}
	public boolean isCartao() {
		return cartao;
	}
	public void setCartao(boolean cartao) {
		this.cartao = cartao;
	}
	public boolean isDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(boolean dinheiro) {
		this.dinheiro = dinheiro;
	}
	public boolean isEntregue() {
		return entregue;
	}
	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}
	public boolean isPronto() {
		return pronto;
	}
	public void setPronto(boolean pronto) {
		this.pronto = pronto;
	}
	public Integer getCodos() {
		return codos;
	}
	public void setCodos(Integer codos) {
		this.codos = codos;
	}
	
	
	
	
}
