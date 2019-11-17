package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert.AlertType;
import model.db.DB;
import model.entities.Cliente;
import model.entities.OS;
import model.utils.Alerts;

public class OsDAOJDBC implements DAO<OS>{
	
	public List<OS> findByClientID(Integer clientID) {
		Connection conn=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ResultSet rsClient = null;
		List<OS> list = new ArrayList<>();

		try {
			if(conn==null) {
				DB DB = new DB();
				conn = DB.getConnection();
			}
			st = conn.prepareStatement(
				"SELECT * FROM os WHERE codCliente = ?");
			
			st.setInt(1, clientID);
			
			rs = st.executeQuery();

			
			while (rs.next()) {
				OS obj = new OS();
				obj.setCodos(rs.getInt("codos"));
				obj.setCartao(rs.getBoolean("cartao"));
		
				obj.setDataAtual(rs.getString("dataAtual"));
				obj.setDataEntrega(rs.getString("dataEntrega"));
				obj.setDinheiro(rs.getBoolean("dinheiro"));
				obj.setEntregue(rs.getBoolean("entregue"));
				obj.setLongeODCIL(rs.getDouble("longeODCIL"));
				obj.setLongeODDP(rs.getDouble("longeODDP"));
				obj.setLongeODEIX(rs.getDouble("longeODDP"));
				obj.setLongeODESF(rs.getDouble("longeODESF"));
				obj.setLongeOECIL(rs.getDouble("longeOECIL"));
				obj.setLongeOEDP(rs.getDouble("longeOEDP"));
				obj.setLongeOEEIX(rs.getDouble("longeOEEIX"));
				obj.setLongeOEESF(rs.getDouble("longeOEESF"));
				
				obj.setPertoODCIL(rs.getDouble("pertoODCIL"));
				obj.setPertoODDP(rs.getDouble("pertoODDP"));
				obj.setPertoODEIX(rs.getDouble("pertoODEIX"));
				obj.setPertoODESF(rs.getDouble("pertoODEIX"));
				obj.setPertoOECIL(rs.getDouble("pertoODEIX"));
				obj.setPertoOEDP(rs.getDouble("pertoODEIX"));
				obj.setPertoOEEIX(rs.getDouble("pertoODEIX"));
				obj.setPertoOEESF(rs.getDouble("pertoOEESF"));
				
				obj.setPronto(rs.getBoolean("pronto"));
				obj.setRestoDaVenda(rs.getDouble("restodavenda"));
				obj.setSinalDaVenda(rs.getDouble("sinaldavenda"));
				obj.setTipoArmacao(rs.getString("tipoarmacao"));
				obj.setTipoLente(rs.getString("tipolente"));
				obj.setTotalDaVenda(rs.getDouble("totaldavenda"));
				obj.setNomeVendedor(rs.getString("nomeVendedor"));
				
				int n = rs.getInt("codCliente");
				
				st = conn.prepareStatement(
						"SELECT * FROM cliente where codCliente = ? ORDER BY codCliente");
					
				st.setInt(1, n);
				
				rsClient = st.executeQuery();
				
				rsClient.next();
				
				Cliente cliente = new Cliente();
				
				cliente.setCodCliente(rsClient.getInt("codcliente"));
				cliente.setBairro(rsClient.getString("bairro"));
				cliente.setBirthDate(rsClient.getString("birthDate"));
				cliente.setEmail(rsClient.getString("email"));
				cliente.setCEP(rsClient.getString("cep"));
				cliente.setComplemento(rsClient.getString("complemento"));
				cliente.setCPF(rsClient.getString("cpf"));
				cliente.setName(rsClient.getString("nome"));
				cliente.setRua(rsClient.getString("rua"));
				cliente.setTelefone(rsClient.getString("telefone"));
				cliente.setCidade(rsClient.getString("cidade"));
				cliente.setEstado(rsClient.getString("estado"));
				
				obj.setCliente(cliente);
				
				list.add(obj);
			}
			return list;
		}
		catch (Exception e) {
			Alerts.showAlert("Not found", e.getMessage(), AlertType.ERROR);
			}
		return list;
	}
	
	@Override
	public OS findByID(Integer id) {

		Connection conn=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ResultSet rsClient = null;
		OS obj=null;
		
		try {
			if(conn==null) {
				DB DB = new DB();
				conn = DB.getConnection();
			}
	
			st = conn.prepareStatement(
				"SELECT * FROM os WHERE codos = ?");
		
			st.setInt(1, id);
			
			rs = st.executeQuery();
			rs.next();
			obj = new OS();
			
			obj.setCodos(rs.getInt("codos"));
			obj.setCartao(rs.getBoolean("cartao"));
	
			System.out.println("A");
			
			obj.setDataAtual(rs.getString("dataAtual"));
			obj.setDataEntrega(rs.getString("dataEntrega"));
			obj.setDinheiro(rs.getBoolean("dinheiro"));
			obj.setEntregue(rs.getBoolean("entregue"));
			obj.setLongeODCIL(rs.getDouble("longeODCIL"));
			obj.setLongeODDP(rs.getDouble("longeODDP"));
			obj.setLongeODEIX(rs.getDouble("longeODDP"));
			obj.setLongeODESF(rs.getDouble("longeODESF"));
			obj.setLongeOECIL(rs.getDouble("longeOECIL"));
			obj.setLongeOEDP(rs.getDouble("longeOEDP"));
			obj.setLongeOEEIX(rs.getDouble("longeOEEIX"));
			obj.setLongeOEESF(rs.getDouble("longeOEESF"));
			
			obj.setPertoODCIL(rs.getDouble("pertoODCIL"));
			obj.setPertoODDP(rs.getDouble("pertoODDP"));
			obj.setPertoODEIX(rs.getDouble("pertoODEIX"));
			obj.setPertoODESF(rs.getDouble("pertoODEIX"));
			obj.setPertoOECIL(rs.getDouble("pertoODEIX"));
			obj.setPertoOEDP(rs.getDouble("pertoODEIX"));
			obj.setPertoOEEIX(rs.getDouble("pertoODEIX"));
			
			obj.setPronto(rs.getBoolean("pronto"));
			obj.setRestoDaVenda(rs.getDouble("restodavenda"));
			obj.setSinalDaVenda(rs.getDouble("sinaldavenda"));
			obj.setTipoArmacao(rs.getString("tipoarmacao"));
			obj.setTipoLente(rs.getString("tipolente"));
			obj.setTotalDaVenda(rs.getDouble("totaldavenda"));
			obj.setNomeVendedor(rs.getString("nomeVendedor"));
			
			int n = rs.getInt("codCliente");
			
			st = conn.prepareStatement(
					"SELECT * FROM cliente where codCliente = ? ORDER BY codCliente");
				
			st.setInt(1, n);
			
			rsClient = st.executeQuery();
			
			rsClient.next();
			
			Cliente cliente = new Cliente();
			
			cliente.setCodCliente(rsClient.getInt("codcliente"));
			cliente.setBairro(rsClient.getString("bairro"));
			cliente.setBirthDate(rsClient.getString("birthDate"));
			cliente.setEmail(rsClient.getString("email"));
			cliente.setCEP(rsClient.getString("cep"));
			cliente.setComplemento(rsClient.getString("complemento"));
			cliente.setCPF(rsClient.getString("cpf"));
			cliente.setName(rsClient.getString("nome"));
			cliente.setRua(rsClient.getString("rua"));
			cliente.setTelefone(rsClient.getString("telefone"));
			cliente.setCidade(rsClient.getString("cidade"));
			cliente.setEstado(rsClient.getString("estado"));
			
			obj.setCliente(cliente);
		}
			catch(Exception e) {
				Alerts.showAlert("Not found", e.getMessage(), AlertType.ERROR);
			}
		finally {
		return obj;
		}
	}

	@Override
	public List<OS> findAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ResultSet rsClient = null;
		List<OS> list = new ArrayList<>();

		try {
			if(conn==null) {
				DB DB = new DB();
				conn = DB.getConnection();
			}
			st = conn.prepareStatement(
				"SELECT * FROM os ORDER BY codos");
			rs = st.executeQuery();

			
			while (rs.next()) {
				OS obj = new OS();
				obj.setCodos(rs.getInt("codos"));
				obj.setCartao(rs.getBoolean("cartao"));
		
				obj.setDataAtual(rs.getString("dataAtual"));
				obj.setDataEntrega(rs.getString("dataEntrega"));
				obj.setDinheiro(rs.getBoolean("dinheiro"));
				obj.setEntregue(rs.getBoolean("entregue"));
				obj.setLongeODCIL(rs.getDouble("longeODCIL"));
				obj.setLongeODDP(rs.getDouble("longeODDP"));
				obj.setLongeODEIX(rs.getDouble("longeODDP"));
				obj.setLongeODESF(rs.getDouble("longeODESF"));
				obj.setLongeOECIL(rs.getDouble("longeOECIL"));
				obj.setLongeOEDP(rs.getDouble("longeOEDP"));
				obj.setLongeOEEIX(rs.getDouble("longeOEEIX"));
				obj.setLongeOEESF(rs.getDouble("longeOEESF"));
				
				obj.setPertoODCIL(rs.getDouble("pertoODCIL"));
				obj.setPertoODDP(rs.getDouble("pertoODDP"));
				obj.setPertoODEIX(rs.getDouble("pertoODEIX"));
				obj.setPertoODESF(rs.getDouble("pertoODEIX"));
				obj.setPertoOECIL(rs.getDouble("pertoODEIX"));
				obj.setPertoOEDP(rs.getDouble("pertoODEIX"));
				obj.setPertoOEEIX(rs.getDouble("pertoODEIX"));
				obj.setPertoOEESF(rs.getDouble("pertoOEESF"));
				
				obj.setPronto(rs.getBoolean("pronto"));
				obj.setRestoDaVenda(rs.getDouble("restodavenda"));
				obj.setSinalDaVenda(rs.getDouble("sinaldavenda"));
				obj.setTipoArmacao(rs.getString("tipoarmacao"));
				obj.setTipoLente(rs.getString("tipolente"));
				obj.setTotalDaVenda(rs.getDouble("totaldavenda"));
				obj.setNomeVendedor(rs.getString("nomeVendedor"));
				
				int n = rs.getInt("codCliente");
				
				st = conn.prepareStatement(
						"SELECT * FROM cliente where codCliente = ? ORDER BY codCliente");
					
				st.setInt(1, n);
				
				rsClient = st.executeQuery();
				
				rsClient.next();
				
				Cliente cliente = new Cliente();
				
				cliente.setCodCliente(rsClient.getInt("codcliente"));
				cliente.setBairro(rsClient.getString("bairro"));
				cliente.setBirthDate(rsClient.getString("birthDate"));
				cliente.setEmail(rsClient.getString("email"));
				cliente.setCEP(rsClient.getString("cep"));
				cliente.setComplemento(rsClient.getString("complemento"));
				cliente.setCPF(rsClient.getString("cpf"));
				cliente.setName(rsClient.getString("nome"));
				cliente.setRua(rsClient.getString("rua"));
				cliente.setTelefone(rsClient.getString("telefone"));
				cliente.setCidade(rsClient.getString("cidade"));
				cliente.setEstado(rsClient.getString("estado"));
				
				obj.setCliente(cliente);
				
				list.add(obj);
			}
			return list;
		}
		catch (Exception e) {
			Alerts.showAlert("Not found", e.getMessage(), AlertType.ERROR);
			}
		
		return list;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		try {
			Connection conn;
			PreparedStatement preparedStatement;
			DB DB = new DB();
			conn = DB.getConnection();
			
			preparedStatement = conn.prepareStatement("DELETE FROM OS WHERE codos = ?"
					) ;
			
			preparedStatement.setInt(1, id);
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			Alerts.showAlert("Deleting OS", "Numero de linhas afetadas: "+rowsAffected, AlertType.INFORMATION);
		
		} catch(Exception e) {
			Alerts.showAlert("Error in delete data", e.getMessage(), AlertType.ERROR);
		}
		
	}

	@Override
	public void update(OS OS) {
		// TODO Auto-generated method stub
		try {
			Connection conn;
			PreparedStatement preparedStatement;
			DB DB = new DB();
			conn = DB.getConnection();
			
			preparedStatement = conn.prepareStatement("UPDATE OS "
					+ "SET cartao = ?, "
					+ " DataAtual = ?, "
					+ " DataEntrega = ?, "
					+ " Dinheiro = ?, "
					+ " Entregue = ?, "
					+ " LongeODCIL = ?, "
					+ " LongeODDP = ?, "
					+ " LongeODEIX = ?, "
					+ " LongeODESF = ?, "
					+ " LongeOECIL = ?, "
					+ " LongeOEDP = ?, "
					+ " LongeOEEIX = ?, "
					+ " LongeOEESF = ?, "
					
					+ " PertoODCIL = ?, "
					+ " PertoODDP = ?, "
					+ " PertoODEIX = ?, "
					+ " PertoODESF = ?, "
					+ " PertoOECIL = ?, "
					+ " PertoOEDP = ?, "
					+ " PertoOEEIX = ?, "
					+ " PertoOEESF = ?, "
					
					+ " Pronto = ?, "
					+ " RestoDaVenda = ?, "
					+ " SinalDaVenda = ?, "
					+ " TipoArmacao = ?, "
					+ " TipoLente = ?, "
					+ " TotalDaVenda = ?, "
					+ " nomeVendedor = ?"
					+ "WHERE codos = ?"
					) ;
			
			
			preparedStatement.setBoolean(1, OS.isCartao());
	
			preparedStatement.setString(2, OS.getDataAtual());
			preparedStatement.setString(3, OS.getDataEntrega());
			preparedStatement.setBoolean(4, OS.isDinheiro());
			preparedStatement.setBoolean(5, OS.isEntregue());
			preparedStatement.setDouble(6, OS.getLongeODCIL());
			preparedStatement.setDouble(7, OS.getLongeODEIX());
			preparedStatement.setDouble(8, OS.getLongeODDP());
			preparedStatement.setDouble(9, OS.getLongeODESF());
			preparedStatement.setDouble(10, OS.getLongeOECIL());
			preparedStatement.setDouble(11, OS.getLongeOEDP());
			preparedStatement.setDouble(12, OS.getLongeOEEIX());
			preparedStatement.setDouble(13 , OS.getLongeOEESF());
			
			preparedStatement.setDouble(14,OS.getPertoODCIL());
			preparedStatement.setDouble(15,OS.getPertoODDP());
			preparedStatement.setDouble(16,OS.getPertoODEIX());
			preparedStatement.setDouble(17,OS.getPertoODESF());
			preparedStatement.setDouble(18,OS.getPertoOECIL());
			preparedStatement.setDouble(19,OS.getPertoOEDP());
			preparedStatement.setDouble(20,OS.getPertoOEEIX());
			preparedStatement.setDouble(21,OS.getPertoOEESF());
			
			preparedStatement.setBoolean(22, OS.isPronto());
			preparedStatement.setDouble(23, OS.getRestoDaVenda());
			preparedStatement.setDouble(24, OS.getSinalDaVenda());
			preparedStatement.setString(25, OS.getTipoArmacao());
			preparedStatement.setString(26, OS.getTipoLente());
			preparedStatement.setDouble(27, OS.getTotalDaVenda());
			preparedStatement.setString(28, OS.getNomeVendedor());
			preparedStatement.setInt(29, OS.getCodos());
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			//conn.close();
			//preparedStatement.close();
			
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			Alerts.showAlert("Error in UPDATE data", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public int save(OS OS) {
		// TODO Auto-generated method sOSub
		
		try {
			Connection conn;
			PreparedStatement preparedStatement;
			DB DB = new DB();
			conn = DB.getConnection();
			if(OS.getCliente().getCodCliente() != 0) {
			preparedStatement = conn.prepareStatement("INSERT INTO OS"
					+ "(cartao, DataAtual,DataEntrega,Dinheiro,Entregue,LongeODCIL,LongeODDP,LongeODEIX,"
					+ "LongeODESF,LongeOECIL,LongeOEDP, LongeOEEIX,LongeOEESF,PertoODCIL,PertoODDP,PertoODEIX, "
					+ "PertoODESF,PertoOECIL,PertoOEDP,PertoOEEIX,	PertoOEESF,Pronto,RestoDaVenda,"
					+ "SinalDaVenda,TipoArmacao,TipoLente, TotalDaVenda, codCliente, nomeVendedor)"
					+ "VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?)", Statement.RETURN_GENERATED_KEYS
					) ;
			
			preparedStatement.setBoolean(1, OS.isCartao());
			
			preparedStatement.setString(2, OS.getDataAtual());
			preparedStatement.setString(3, OS.getDataEntrega());
			preparedStatement.setBoolean(4, OS.isDinheiro());
			preparedStatement.setBoolean(5, OS.isEntregue());
			preparedStatement.setDouble(6, OS.getLongeODCIL());
			preparedStatement.setDouble(7, OS.getLongeODEIX());
			preparedStatement.setDouble(8, OS.getLongeODDP());
			preparedStatement.setDouble(9, OS.getLongeODESF());
			preparedStatement.setDouble(10, OS.getLongeOECIL());
			preparedStatement.setDouble(11, OS.getLongeOEDP());
			preparedStatement.setDouble(12, OS.getLongeOEEIX());
			preparedStatement.setDouble(13 , OS.getLongeOEESF());
			
			preparedStatement.setDouble(14,OS.getPertoODCIL());
			preparedStatement.setDouble(15,OS.getPertoODDP());
			preparedStatement.setDouble(16,OS.getPertoODEIX());
			preparedStatement.setDouble(17,OS.getPertoODESF());
			preparedStatement.setDouble(18,OS.getPertoOECIL());
			preparedStatement.setDouble(19,OS.getPertoOEDP());
			preparedStatement.setDouble(20,OS.getPertoOEEIX());
			preparedStatement.setDouble(21,OS.getPertoOEESF());
			
			preparedStatement.setBoolean(22, OS.isPronto());
			preparedStatement.setDouble(23, OS.getRestoDaVenda());
			preparedStatement.setDouble(24, OS.getSinalDaVenda());
			preparedStatement.setString(25, OS.getTipoArmacao());
			preparedStatement.setString(26, OS.getTipoLente());
			preparedStatement.setDouble(27, OS.getTotalDaVenda());
			preparedStatement.setDouble(28, OS.getCliente().getCodCliente());
			preparedStatement.setString(29, OS.getNomeVendedor());
			
			
			}else {
				preparedStatement = conn.prepareStatement("INSERT INTO OS"
						+ "(cartao, DataAtual,DataEntrega,Dinheiro,Entregue,LongeODCIL,LongeODDP,LongeODEIX,"
						+ "LongeODESF,LongeOECIL,LongeOEDP, LongeOEEIX,LongeOEESF,PertoODCIL,PertoODDP,PertoODEIX, "
						+ "PertoODESF,PertoOECIL,PertoOEDP,PertoOEEIX,PertoOEESF,Pronto,restodavenda,"
						+ "SinalDaVenda,TipoArmacao,TipoLente, TotalDaVenda)"
						+ "VALUES"
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
						) ;
				
				preparedStatement.setBoolean(1, OS.isCartao());
				
				preparedStatement.setString(2, OS.getDataAtual());
				preparedStatement.setString(3, OS.getDataEntrega());
				preparedStatement.setBoolean(4, OS.isDinheiro());
				preparedStatement.setBoolean(5, OS.isEntregue());
				preparedStatement.setDouble(6, OS.getLongeODCIL());
				preparedStatement.setDouble(7, OS.getLongeODEIX());
				preparedStatement.setDouble(8, OS.getLongeODDP());
				preparedStatement.setDouble(9, OS.getLongeODESF());
				preparedStatement.setDouble(10, OS.getLongeOECIL());
				preparedStatement.setDouble(11, OS.getLongeOEDP());
				preparedStatement.setDouble(12, OS.getLongeOEEIX());
				preparedStatement.setDouble(13 , OS.getLongeOEESF());
				
				preparedStatement.setDouble(14,OS.getPertoODCIL());
				preparedStatement.setDouble(15,OS.getPertoODDP());
				preparedStatement.setDouble(16,OS.getPertoODEIX());
				preparedStatement.setDouble(17,OS.getPertoODESF());
				preparedStatement.setDouble(18,OS.getPertoOECIL());
				preparedStatement.setDouble(19,OS.getPertoOEDP());
				preparedStatement.setDouble(20,OS.getPertoOEEIX());
				preparedStatement.setDouble(21,OS.getPertoOEESF());
				
				preparedStatement.setBoolean(22, OS.isPronto());
				preparedStatement.setDouble(23, OS.getRestoDaVenda());
				preparedStatement.setDouble(24, OS.getSinalDaVenda());
				preparedStatement.setString(25, OS.getTipoArmacao());
				preparedStatement.setString(26, OS.getTipoLente());
				preparedStatement.setDouble(27, OS.getTotalDaVenda());
				preparedStatement.setString(28, OS.getNomeVendedor());
				
					
			}
			int rowsAffected = preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
		
			//conn.close();
			//preparedStatement.close();
			
			resultSet.next();
			
		
			return resultSet.getInt(1);
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			Alerts.showAlert("Error in write data", e.getMessage(), AlertType.ERROR);
		}
		return -1111;
		}
		
		
	}
