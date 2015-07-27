package buildings.model;

import java.util.Date;

public class Solicitud {
	private int ticket;
	private int idusuario;
	private String asunto;
	private String detalle;
	private String fechaSolicitud;
	private String fechaResolucion;
	private String Respuesta;
	private int isOk;
	
	public Solicitud(){}
	
	public Solicitud(int ticket, int idusuario, String asunto, String detalle,
			String fechaSolicitud, String fechaResolucion, String respuesta,
			int isOk) {
		super();
		this.ticket = ticket;
		this.idusuario = idusuario;
		this.asunto = asunto;
		this.detalle = detalle;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaResolucion = fechaResolucion;
		Respuesta = respuesta;
		this.isOk = isOk;
	}
	
	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getRespuesta() {
		return Respuesta;
	}

	public void setRespuesta(String respuesta) {
		Respuesta = respuesta;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(String fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public int getIsOk() {
		return isOk;
	}
	public void setIsOk(int isOk) {
		this.isOk = isOk;
	}
}
