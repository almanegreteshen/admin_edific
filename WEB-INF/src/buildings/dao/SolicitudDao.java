package buildings.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import buildings.connection.Pool;
import buildings.model.Solicitud;

public class SolicitudDao {
	private static final Logger log = Logger.getLogger(SolicitudDao.class);
	
	public ArrayList<Solicitud> getAllSolicitudesNo(){

		ArrayList<Solicitud> listaSolicitudes = new ArrayList<Solicitud>();
		
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
			sb.append("select TICKET,IDUSUARIO,ASUNTO,DETALLE,FECHASOLICITUD,FECHARESOLUCION,RESPUESTA,ISOK from Solicitud where ISOK = 0 order by TICKET");
			stmt = conn.prepareStatement(sb.toString());
			
			rs = stmt.executeQuery();
			
			System.out.println("Se executo query");
			
			while (rs.next()) {
				Solicitud soli = new Solicitud();
				soli.setTicket(rs.getInt("TICKET"));
				soli.setIdusuario(rs.getInt("IDUSUARIO"));
				soli.setAsunto(rs.getString("ASUNTO"));
				soli.setDetalle(rs.getString("DETALLE"));
				soli.setFechaSolicitud(rs.getString("FECHASOLICITUD"));
				soli.setFechaResolucion(rs.getString("FECHARESOLUCION"));
				soli.setRespuesta(rs.getString("RESPUESTA"));
				soli.setIsOk(rs.getInt("ISOK"));

				listaSolicitudes.add(soli); 
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
    	return listaSolicitudes;
	}		
	
	public ArrayList<Solicitud> getAllSolicitudesOk(){

		ArrayList<Solicitud> listaSolicitudes = new ArrayList<Solicitud>();
		
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
			sb.append("select TICKET,IDUSUARIO,ASUNTO,DETALLE,FECHASOLICITUD,FECHARESOLUCION,RESPUESTA,ISOK from Solicitud where ISOK = 1 order by TICKET");
			stmt = conn.prepareStatement(sb.toString());
			
			rs = stmt.executeQuery();
			
			System.out.println("Se executo query");
			
			while (rs.next()) {
				Solicitud soli = new Solicitud();
				soli.setTicket(rs.getInt("TICKET"));
				soli.setIdusuario(rs.getInt("IDUSUARIO"));
				soli.setAsunto(rs.getString("ASUNTO"));
				soli.setDetalle(rs.getString("DETALLE"));
				soli.setFechaSolicitud(rs.getString("FECHASOLICITUD"));
				soli.setFechaResolucion(rs.getString("FECHARESOLUCION"));
				soli.setRespuesta(rs.getString("RESPUESTA"));
				soli.setIsOk(rs.getInt("ISOK"));

				listaSolicitudes.add(soli); 
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
    	return listaSolicitudes;
	}		
	
	public ArrayList<Solicitud> getAllAdminSolicitudes(){

		ArrayList<Solicitud> listaSolicitudes = new ArrayList<Solicitud>();
		
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
			sb.append("select TICKET,IDUSUARIO,ASUNTO,DETALLE,FECHASOLICITUD,FECHARESOLUCION,RESPUESTA,ISOK from Solicitud order by TICKET");
			stmt = conn.prepareStatement(sb.toString());
			
			rs = stmt.executeQuery();
			
			System.out.println("Se executo query");
			
			while (rs.next()) {
				Solicitud soli = new Solicitud();
				soli.setTicket(rs.getInt("TICKET"));
				soli.setIdusuario(rs.getInt("IDUSUARIO"));
				soli.setAsunto(rs.getString("ASUNTO"));
				soli.setDetalle(rs.getString("DETALLE"));
				soli.setFechaSolicitud(rs.getString("FECHASOLICITUD"));
				soli.setFechaResolucion(rs.getString("FECHARESOLUCION"));
				soli.setRespuesta(rs.getString("RESPUESTA"));
				soli.setIsOk(rs.getInt("ISOK"));

				listaSolicitudes.add(soli); 
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
    	return listaSolicitudes;
	}		
	
	public boolean insertSolicitud(Solicitud soli){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder sb = new StringBuilder();
		ResultSet rs = null;
		int lastTicket = 0; 
		
		try {
			conn = Pool.getConnection();
		} catch (SQLException e) {
			log.info(e.getMessage());
			return false;
		}

		try {
			StringBuilder sbTicket = new StringBuilder();
			sbTicket.append("select max(TICKET) as TICKET from solicitud");
			PreparedStatement stmtTicket = null;
			stmtTicket = conn.prepareStatement(sbTicket.toString());
			ResultSet rsTicket = null;
			rsTicket = stmtTicket.executeQuery();
			
			if (rsTicket.next()) {
				lastTicket = rsTicket.getInt("TICKET") + 1;
	        }				
			
		} catch (SQLException e) {
			log.info(e.getMessage());
			return false;
		}		
		
		try {
			sb.append("insert into solicitud (TICKET,IDUSUARIO,ASUNTO,DETALLE,FECHASOLICITUD,FECHARESOLUCION,RESPUESTA,ISOK) values (?,?,?,?,sysdate,null,'',0)");
			stmt = conn.prepareStatement(sb.toString());
			stmt.setInt(1, lastTicket);
			stmt.setInt(2, soli.getIdusuario());
			stmt.setString(3, soli.getAsunto());
			stmt.setString(4, soli.getDetalle());
			
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
	
	public ArrayList<Solicitud> getAllSolicitudes(int idUsuario){

		ArrayList<Solicitud> listaSolicitudes = new ArrayList<Solicitud>();
		
		log.info("Id User: " + idUsuario);
		
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
			sb.append("select TICKET,IDUSUARIO,ASUNTO,DETALLE,FECHASOLICITUD,FECHARESOLUCION,RESPUESTA,ISOK from Solicitud where IDUSUARIO = ? order by TICKET");
			stmt = conn.prepareStatement(sb.toString());
			stmt.setInt(1, idUsuario);
			
			rs = stmt.executeQuery();
			
			System.out.println("Se executo query soli");
			
			while (rs.next()) {
				Solicitud soli = new Solicitud();
				soli.setTicket(rs.getInt("TICKET"));
				soli.setIdusuario(rs.getInt("IDUSUARIO"));
				soli.setAsunto(rs.getString("ASUNTO"));
				soli.setDetalle(rs.getString("DETALLE"));
				soli.setFechaSolicitud(rs.getString("FECHASOLICITUD"));
				soli.setFechaResolucion(rs.getString("FECHARESOLUCION"));
				soli.setRespuesta(rs.getString("RESPUESTA"));
				soli.setIsOk(rs.getInt("ISOK"));

				listaSolicitudes.add(soli); 
	        }
		
		} catch (SQLException e) {
			log.info(e.getMessage());
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
		log.info(listaSolicitudes.toString());
    	return listaSolicitudes;
	}	
}
