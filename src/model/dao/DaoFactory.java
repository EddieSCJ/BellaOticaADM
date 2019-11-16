package model.dao;

public class DaoFactory {

	public static ClienteDAOJDBC createClienteDaojdbc() {
		return new ClienteDAOJDBC();
	}
	
	public static OSDAOJDBC createOSDAOJDBC() {
		return new OSDAOJDBC();
	}
	
}
