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

public class OSDAOJDBC implements DAO<OS>{
	
	@Override
	public OS findByID(Integer id) {

		Connection conn=null;
		PreparedStatement st = null;
		ResultSet rs = null;
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
			obj.setPertoOEESF(rs.getDouble("OEESF"));
			
			obj.setPronto(rs.getBoolean("pronto"));
			obj.setRestoDaVenda(rs.getDouble("restodavenda"));
			obj.setSinalDaVenda(rs.getDouble("sinaldavenda"));
			obj.setTipoArmacao(rs.getString("tipoarmacao"));
			obj.setTipoLente(rs.getString("tipolente"));
			obj.setTotalDaVenda(rs.getDouble("totaldavenda"));
			
			Cliente cliente = new Cliente();
			
			cliente.setCodCliente(rs.getInt("codcliente"));
			cliente.setBairro(rs.getString("bairro"));
			cliente.setBirthDate(rs.getString("birthDate"));
			cliente.setEmail(rs.getString("email"));
			cliente.setCEP(rs.getString("cep"));
			cliente.setComplemento(rs.getString("complemento"));
			cliente.setCPF(rs.getString("cpf"));
			cliente.setName(rs.getString("nome"));
			cliente.setRua(rs.getString("rua"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCidade(rs.getString("cidade"));
			cliente.setEstado(rs.getString("estado"));
			
			obj.setCliente(cliente);
			
		}
			catch(Exception e) {
				Alerts.showAlert("Not found", "Data not found", AlertType.ERROR);
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
				obj.setPertoOEESF(rs.getDouble("OEESF"));
				
				obj.setPronto(rs.getBoolean("pronto"));
				obj.setRestoDaVenda(rs.getDouble("restodavenda"));
				obj.setSinalDaVenda(rs.getDouble("sinaldavenda"));
				obj.setTipoArmacao(rs.getString("tipoarmacao"));
				obj.setTipoLente(rs.getString("tipolente"));
				obj.setTotalDaVenda(rs.getDouble("totaldavenda"));
				
				Cliente cliente = new Cliente();
				
				cliente.setCodCliente(rs.getInt("codcliente"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setBirthDate(rs.getString("birthDate"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCEP(rs.getString("cep"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setName(rs.getString("nome"));
				cliente.setRua(rs.getString("rua"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				
				obj.setCliente(cliente);
				list.add(obj);
			}
			return list;
		}
		catch (Exception e) {
			Alerts.showAlert("Not found", "Data not found", AlertType.ERROR);
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
					+ "DataAtual = ?, "
					+ "DataEntrega = ? "
					+ "Dinheiro = ? "
					+ "Entregue = ? "
					+ "LongeODCIL = ? "
					+ "LongeODDP = ? "
					+ "LongeODEIX = ? "
					+ "LongeODESF = ? "
					+ "LongeOECIL = ? "
					+ "LongeOEDP = ? "
					+ "LongeOEEIX = ? "
					+ "LongeOEESF = ? "
					
					+ "PertoODCIL = ? "
					+ "PertoODDP = ? "
					+ "PertoODEIX = ? "
					+ "PertoODESF = ? "
					+ "PertoOECIL = ? "
					+ "PertoOEDP = ? "
					+ "PertoOEEIX = ? "
					+ "PertoOEESF = ? "
					
					+ "Pronto = ? "
					+ "RestoDaVenda = ? "
					+ "SinalDaVenda = ? "
					+ "TipoArmacao = ? "
					+ "TipoLente = ? "
					+ "TotalDaVenda = ? "
					+ "WHERE ID = ?"
					) ;
			
			
			preparedStatement.setBoolean(1, OS.isCartao());
	
			preparedStatement.setString(2, new SimpleDateFormat("dd/MM/yyyy").format(OS.getDataAtual()));
			preparedStatement.setString(3, new SimpleDateFormat("dd/MM/yyyy").format(OS.getDataEntrega()));
			preparedStatement.setBoolean(4, OS.isDinheiro());
			preparedStatement.setBoolean(4, OS.isEntregue());
			preparedStatement.setDouble(5, OS.getLongeODCIL());
			preparedStatement.setDouble(6, OS.getLongeODEIX());
			preparedStatement.setDouble(7, OS.getLongeODDP());
			preparedStatement.setDouble(8, OS.getLongeODESF());
			preparedStatement.setDouble(9, OS.getLongeOECIL());
			preparedStatement.setDouble(1, OS.getLongeOEDP());
			preparedStatement.setDouble(11, OS.getLongeOEEIX());
			preparedStatement.setDouble(12 , OS.getLongeOEESF());
			
			preparedStatement.setDouble(13,OS.getPertoODCIL());
			preparedStatement.setDouble(14,OS.getPertoODDP());
			preparedStatement.setDouble(15,OS.getPertoODEIX());
			preparedStatement.setDouble(16,OS.getPertoODESF());
			preparedStatement.setDouble(17,OS.getPertoOECIL());
			preparedStatement.setDouble(18,OS.getPertoOEDP());
			preparedStatement.setDouble(19,OS.getPertoOEEIX());
			preparedStatement.setDouble(20,OS.getPertoOEESF());
			
			preparedStatement.setBoolean(21, OS.isPronto());
			preparedStatement.setDouble(22, OS.getRestoDaVenda());
			preparedStatement.setDouble(24, OS.getSinalDaVenda());
			preparedStatement.setString(25, OS.getTipoArmacao());
			preparedStatement.setString(26, OS.getTipoLente());
			preparedStatement.setDouble(27, OS.getTotalDaVenda());
		
			int rowsAffected = preparedStatement.executeUpdate();
			
			//conn.close();
			//preparedStatement.close();
			
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
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
					+ "SinalDaVenda,TipoArmacao,TipoLente, TotalDaVenda, codCliente)"
					+ "VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
					) ;
			
			preparedStatement.setBoolean(1, OS.isCartao());
			
			preparedStatement.setString(2, new SimpleDateFormat("dd/MM/yyyy").format(OS.getDataAtual()));
			preparedStatement.setString(3, new SimpleDateFormat("dd/MM/yyyy").format(OS.getDataEntrega()));
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
			
			preparedStatement.setBoolean(21, OS.isPronto());
			preparedStatement.setDouble(22, OS.getRestoDaVenda());
			preparedStatement.setDouble(24, OS.getSinalDaVenda());
			preparedStatement.setString(25, OS.getTipoArmacao());
			preparedStatement.setString(26, OS.getTipoLente());
			preparedStatement.setDouble(27, OS.getTotalDaVenda());
			preparedStatement.setDouble(28, OS.getCliente().getCodCliente());
			
			
			}else {
				preparedStatement = conn.prepareStatement("INSERT INTO OS"
						+ "(cartao, DataAtual,DataEntrega,Dinheiro,Entregue,LongeODCIL,LongeODDP,LongeODEIX,"
						+ "LongeODESF,LongeOECIL,LongeOEDP, LongeOEEIX,LongeOEESF,PertoODCIL,PertoODDP,PertoODEIX, "
						+ "PertoODESF,PertoOECIL,PertoOEDP,PertoOEEIX,	PertoOEESF,Pronto,RestoDaVenda,"
						+ "SinalDaVenda,TipoArmacao,TipoLente, TotalDaVenda)"
						+ "VALUES"
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
						) ;
				
				preparedStatement.setBoolean(1, OS.isCartao());
				
				preparedStatement.setString(2, new SimpleDateFormat("dd/MM/yyyy").format(OS.getDataAtual()));
				preparedStatement.setString(3, new SimpleDateFormat("dd/MM/yyyy").format(OS.getDataEntrega()));
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
