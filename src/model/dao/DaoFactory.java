package model.dao;

public class DaoFactory {

	public static ClienteDAOJDBC createClienteDaojdbc() {
		return new ClienteDAOJDBC();
	}
	
	public static OsDAOJDBC createOSDAOJDBC() {
		return new OsDAOJDBC();
	}
	
}
