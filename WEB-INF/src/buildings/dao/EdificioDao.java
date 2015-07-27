package buildings.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import buildings.connection.Pool;
import buildings.model.Edificio;

public class EdificioDao {
	private static final Logger log = Logger.getLogger(EdificioDao.class);
	
	public boolean deleteEdificioById(int idedificio){
		
		log.info("Id: " + idedificio);
		
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			conn = Pool.getConnection();
			System.out.println("Coneccion OK: ");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			sb.append("delete from Edificio where IDEDIFICIO = ?");
			stmt = conn.prepareStatement(sb.toString());
			stmt.setInt(1, idedificio);
			
			rs = stmt.executeQuery();
			
			System.out.println("Se executo query update");		
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				log.error("Error al cerrar conexiones" + e.getMessage());
				return false;
			}
		}
		
    	return true;
	}		
	
	public Edificio updateEdificioById(int idedificio, Edificio edif){
		
		log.info("Id: " + idedificio);
		
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			conn = Pool.getConnection();
			System.out.println("Coneccion OK: ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sb.append("Update edificio set NOMBRE=?,DIRECCION=?,CIUDAD=?,REGION=? where IDEDIFICIO = ?");
			stmt = conn.prepareStatement(sb.toString());
			stmt.setString(1, edif.getNombre());
			stmt.setString(2, edif.getDireccion());
			stmt.setString(3, edif.getCiudad());
			stmt.setInt(4, edif.getRegion());
			stmt.setInt(5, idedificio);
			
			rs = stmt.executeQuery();
			
			System.out.println("Se executo query update");		
			
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
		
    	return edif;
	}	
	
	public boolean insertEdificio(Edificio edif){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder sb = new StringBuilder();
		ResultSet rs = null;
		int lastId = 0; 
		
		try {
			conn = Pool.getConnection();
		} catch (SQLException e) {
			log.info(e.getMessage());
			return false;
		}

		try {
			StringBuilder sbId = new StringBuilder();
			sbId.append("select max(IDEDIFICIO) as IDEDIFICIO from edificio");
			PreparedStatement stmtTicket = null;
			stmtTicket = conn.prepareStatement(sbId.toString());
			ResultSet rsId = null;
			rsId = stmtTicket.executeQuery();
			
			if (rsId.next()) {
				lastId = rsId.getInt("IDEDIFICIO") + 1;
	        }				
			
		} catch (SQLException e) {
			log.info(e.getMessage());
			return false;
		}		
		
		try {
			sb.append("insert into edificio (IDEDIFICIO,NOMBRE,DIRECCION,CIUDAD,REGION) values (?,?,?,?,?)");
			stmt = conn.prepareStatement(sb.toString());
			stmt.setInt(1, lastId);
			stmt.setString(2, edif.getNombre());
			stmt.setString(3, edif.getDireccion());
			stmt.setString(4, edif.getCiudad());
			stmt.setInt(5, edif.getRegion());
			
			rs = stmt.executeQuery();
			
			log.info("Se executo query insert");
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
    	return true;
	}			
	
	public Edificio getEdificioById(int idedificio){

		Edificio edif = new Edificio();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			conn = Pool.getConnection();
			System.out.println("Coneccion OK: ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sb.append("select NOMBRE,DIRECCION,CIUDAD,REGION from Edificio where IDEDIFICIO = ?");
			stmt = conn.prepareStatement(sb.toString());
			stmt.setInt(1, idedificio);
			
			rs = stmt.executeQuery();
			
			System.out.println("Se executo query");
			
			while (rs.next()) {
				edif.setIdedificio(idedificio);
				edif.setNombre(rs.getString("NOMBRE"));
				edif.setDireccion(rs.getString("DIRECCION"));
				edif.setCiudad(rs.getString("CIUDAD"));
				edif.setRegion(rs.getInt("REGION"));
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
		
    	return edif;
	}
	
	public ArrayList<Edificio> getAllEdificio(){

		ArrayList<Edificio> listaEdificios = new ArrayList<Edificio>();
		
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			conn = Pool.getConnection();
			System.out.println("Coneccion OK: ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sb.append("select IDEDIFICIO,NOMBRE,DIRECCION,CIUDAD,REGION from edificio order by IDEDIFICIO");
			stmt = conn.prepareStatement(sb.toString());
			
			rs = stmt.executeQuery();
			
			System.out.println("Se executo query");
			
			while (rs.next()) {
				Edificio edif = new Edificio();
				
				edif.setIdedificio(rs.getInt("IDEDIFICIO"));
				edif.setNombre(rs.getString("NOMBRE"));
				edif.setDireccion(rs.getString("DIRECCION"));
				edif.setCiudad(rs.getString("CIUDAD"));
				edif.setRegion(rs.getInt("REGION"));
				listaEdificios.add(edif);
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
		
    	return listaEdificios;
	}			
}
