package buildings.dao;

public class DaoFactory {
	public static EdificioDao getEdificioDao(){
		return new EdificioDao();
	}
	
	public static LoginDao getLoginDao(){
		return new LoginDao();
	}
	
	public static UsuarioDao getUsuarioDao(){
		return new UsuarioDao();
	}
	
	public static SolicitudDao getSolicitudDao(){
		return new SolicitudDao();
	}
}
