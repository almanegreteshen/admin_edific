package buildings.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import buildings.connection.Pool;
import buildings.model.Usuario;

public class UsuarioDao {
	private static final Logger log = Logger.getLogger(UsuarioDao.class);
	
	public Usuario getUsuarioById(int idusuario){

		Usuario cli = new Usuario();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder sb = new StringBuilder();
		ResultSet rs = null;
		
		try {
			conn = Pool.getConnection();
			System.out.println("Coneccion OK: ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sb.append("select IDUSU,PASSWORDUSU,IDEDIFICIO,NOMBRE,APEPAT,APEMAT,DEPARTAMENTO,TIPOUSU from usuario where IDUSU = ?");
			stmt = conn.prepareStatement(sb.toString());
			stmt.setInt(1, idusuario);
			
			rs = stmt.executeQuery();
			
			System.out.println("Se executo query");
			
			while (rs.next()) {
				cli.setIdusu(rs.getInt("idusu"));
				cli.setPasswordusu(rs.getString("PASSWORDUSU"));
				cli.setIdedificio(rs.getInt("idedificio"));
				cli.setNombre(rs.getString("nombre"));
				cli.setApepat(rs.getString("apepat"));
				cli.setApemat(rs.getString("apemat"));
				cli.setDepartamento(rs.getString("departamento"));
				cli.setTipousu(rs.getInt("tipousu"));
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
		
    	return cli;
	}		
	
	public ArrayList<Usuario> getAllUsuarios(){

		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder sb = new StringBuilder();
		ResultSet rs = null;
		
		try {
			conn = Pool.getConnection();
			System.out.println("Coneccion OK: ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sb.append("select idusu,PASSWORDUSU,idedificio,nombre,apepat,apemat,departamento,tipousu from usuario where tipousu in (2,3) order by idusu");
			stmt = conn.prepareStatement(sb.toString());
			
			rs = stmt.executeQuery();
			
			System.out.println("Se executo query");
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdusu(rs.getInt("idusu"));
				usuario.setPasswordusu(rs.getString("PASSWORDUSU"));
				usuario.setIdedificio(rs.getInt("idedificio"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApepat(rs.getString("apepat"));
				usuario.setApemat(rs.getString("apemat"));
				usuario.setDepartamento(rs.getString("departamento"));
				usuario.setTipousu(rs.getInt("tipousu"));
				listaUsuarios.add(usuario); 
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
		
    	return listaUsuarios;
	}		
}
