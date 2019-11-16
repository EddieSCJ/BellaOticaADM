package model.dao;

import java.awt.print.Book;
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
import model.utils.Alerts;

public class ClienteDAOJDBC implements DAO<Cliente>{

	public List<Cliente> findByName(String name) {

		Connection conn=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Cliente obj=null;
		List<Cliente> list = new ArrayList<Cliente>();
		
		try {
			if(conn==null) {
				DB DB = new DB();
				conn = DB.getConnection();
			}
			
			st = conn.prepareStatement(
				"SELECT * FROM cliente WHERE Name = ?");
		
			st.setString(1, name);
			
			
			rs = st.executeQuery();
			
			while(rs.next()) {
			obj = new Cliente();
			
			obj.setCodCliente(rs.getInt("codCliente"));
			obj.setBairro(rs.getString("bairro"));
			obj.setBirthDate(rs.getString("birthDate"));
			obj.setEmail(rs.getString("email"));
			obj.setCEP(rs.getString("cep"));
			obj.setComplemento(rs.getString("complemento"));
			obj.setCPF(rs.getString("cpf"));
			obj.setName(rs.getString("nome"));
			obj.setRua(rs.getString("rua"));
			obj.setTelefone(rs.getString("telefone"));
			obj.setCidade(rs.getString("cidade"));
			obj.setEstado(rs.getString("estado"));
			
			list.add(obj);
			}
			
		}
			catch(Exception e) {
				Alerts.showAlert("Não encontrado", "Cliente não encontrado", AlertType.ERROR);
			}
		finally {
		return list;
		}
	}
	
	@Override
	public Cliente findByID(Integer id) {

		Connection conn=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Cliente obj=null;
		
		try {
			if(conn==null) {
				DB DB = new DB();
				conn = DB.getConnection();
			}
	
			st = conn.prepareStatement(
				"SELECT * FROM cliente WHERE codCliente = ?");
		
			st.setInt(1, id);
			
			rs = st.executeQuery();
			rs.next();
			obj = new Cliente();
			
			obj.setCodCliente(rs.getInt("codCliente"));
			obj.setBairro(rs.getString("bairro"));
			obj.setBirthDate(rs.getString("birthDate"));
			obj.setEmail(rs.getString("email"));
			obj.setCEP(rs.getString("cep"));
			obj.setComplemento(rs.getString("complemento"));
			obj.setCPF(rs.getString("cpf"));
			obj.setName(rs.getString("nome"));
			obj.setRua(rs.getString("rua"));
			obj.setTelefone(rs.getString("telefone"));

			obj.setCidade(rs.getString("cidade"));
			obj.setEstado(rs.getString("estado"));
			
		}
			catch(Exception e) {
				Alerts.showAlert("Não encontrado", "Cliente não encontrado", AlertType.ERROR);			}
		finally {
		return obj;
		}
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Cliente> list = new ArrayList<>();

		try {
			if(conn==null) {
				DB DB = new DB();
				conn = DB.getConnection();
			}
			st = conn.prepareStatement(
				"SELECT * FROM cliente ORDER BY codCliente");
			rs = st.executeQuery();

			
			while (rs.next()) {
				Cliente obj = new Cliente();
				
				obj.setCodCliente(rs.getInt("codCliente"));
				obj.setBairro(rs.getString("bairro"));
				obj.setBirthDate(rs.getString("birthDate"));
				obj.setEmail(rs.getString("email"));
				obj.setCEP(rs.getString("cep"));
				obj.setComplemento(rs.getString("complemento"));
				obj.setCPF(rs.getString("cpf"));
				obj.setName(rs.getString("nome"));
				obj.setRua(rs.getString("rua"));
				obj.setTelefone(rs.getString("telefone"));

				obj.setCidade(rs.getString("cidade"));
				obj.setEstado(rs.getString("estado"));
				
				list.add(obj);
			}
			return list;
		}
		catch (Exception e) {
			Alerts.showAlert("Não encontrado", e.getMessage(), AlertType.ERROR);	
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
			
			preparedStatement = conn.prepareStatement("DELETE FROM cliente WHERE codCliente = ?"
					) ;
			
			preparedStatement.setInt(1, id);
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			Alerts.showAlert("Cliente deketado", "Numero de linhas afetadas: "+rowsAffected, AlertType.INFORMATION);
		
		} catch(Exception e) {
			Alerts.showAlert("Erro em deletar cliente", e.getMessage(), AlertType.ERROR);
		}
		
	}

	@Override
	public void update(Cliente client) {
		// TODO Auto-generated method stub
		try {
			Connection conn;
			PreparedStatement preparedStatement;
			DB DB = new DB();
			conn = DB.getConnection();
			
			if(client.getCodCliente() != 0) {
			preparedStatement = conn.prepareStatement("UPDATE cliente "
					+ "SET nome = ?, "
					+ "SET cpf = ?, "
					+ "SET birthDate = ?, "
					+ "SET email = ?, "
					+ "SET rua = ?, "
					+ "SET cep = ?, "
					+ "SET bairro = ?, "
					+ "SET complemento = ?, "
					+ "SET telefone = ?, "
					+ "SET estado = ?"
					+ "SET cidade = ?"
					) ;
			
			preparedStatement.setString(1, client.getName());
			preparedStatement.setString(2, client.getCPF());
			preparedStatement.setString(3, client.getBirthDate().toString());
			preparedStatement.setString(4, client.getEmail());
			preparedStatement.setString(5, client.getRua());
			preparedStatement.setString(6, client.getCEP());
			preparedStatement.setString(7, client.getBairro());
			preparedStatement.setString(8, client.getComplemento());
			preparedStatement.setString(9, client.getTelefone());
			preparedStatement.setString(10, client.getEstado());
			preparedStatement.setString(11, client.getCidade());
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			}
			
			//conn.close();
			//preparedStatement.close();
			
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
			Alerts.showAlert("Error ao atualizar dados do cliente", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public int save(Cliente cliente) {
		// TODO Auto-generated method sbookub
		
		try {
			Connection conn;
			PreparedStatement preparedStatement;
			DB DB = new DB();
			conn = DB.getConnection();

			preparedStatement = conn.prepareStatement("INSERT INTO cliente"
						+ "(cpf,birthDate,email,rua,cep,bairro,complemento, telefone, nome, estado, cidade)"
						+ "VALUES"
						+ "(?,?, ?,?,?,?,?,?,?, ?, ?)", Statement.RETURN_GENERATED_KEYS
						) ;
				
				preparedStatement.setString(1, cliente.getCPF());
				preparedStatement.setString(2, new SimpleDateFormat("dd/MM/yyyy").format(cliente.getBirthDate()));
				preparedStatement.setString(3, cliente.getEmail());
				preparedStatement.setString(4, cliente.getRua());
				preparedStatement.setString(5, cliente.getCEP());
				preparedStatement.setString(6, cliente.getBairro());
				preparedStatement.setString(7, cliente.getComplemento());
				preparedStatement.setString(8, cliente.getTelefone());
				preparedStatement.setString(9, cliente.getName());				
				preparedStatement.setString(10, cliente.getEstado());
				preparedStatement.setString(11, cliente.getCidade());
				
			int rowsAffected = preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
		
			//conn.close();
			//preparedStatement.close();
			
			resultSet.next();
			
		
			return resultSet.getInt(1);
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			Alerts.showAlert("Erro ao salvar dados", e.getMessage(), AlertType.ERROR);
		}
		return -1111;
		}

		
		
	}
