package buildings.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import buildings.connection.Pool;

public class LoginDao {
	
	private static final Logger log = Logger.getLogger(LoginDao.class);
	
	public String getPasswordUser(int idusuario){
		log.info("Buscando password de rut: " + idusuario);
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder sb = new StringBuilder();
		ResultSet rs = null;
		
		try {
			conn = Pool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sb.append("select passwordusu from usuario where idusu = ?");
			stmt = conn.prepareStatement(sb.toString());
			stmt.setInt(1, idusuario);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				log.info("Password: " + rs.getString("passwordusu"));
				return rs.getString("passwordusu");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				log.error("Error al cerrar conexiones" + e.getMessage());
			}
		}
		return "";
	}		
	
	public int getCategoriaUser(int idusuario){
		log.info("getCategoriaUser: " + idusuario);
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder sb = new StringBuilder();
		ResultSet rs = null;
		
		try {
			conn = Pool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sb.append("select tipousu from usuario where idusu = ?");
			stmt = conn.prepareStatement(sb.toString());
			stmt.setInt(1, idusuario);
			
			log.info(sb.toString());
			
			rs = stmt.executeQuery();

			if(rs.next()) {
				log.info("has next Categoria: " + rs.getInt("tipousu"));
				return rs.getInt("tipousu");
	        }else{
	        	return 0;
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				log.error("Error al cerrar conexiones" + e.getMessage());
			}
		}
		return 0;
	}
}
