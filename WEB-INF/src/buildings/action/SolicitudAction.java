package buildings.action;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import buildings.model.Edificio;
import buildings.model.Solicitud;
import buildings.model.Usuario;
import buildings.dao.DaoFactory;

public class SolicitudAction extends ActionSupport {
	private static final Logger log = Logger.getLogger(SolicitudAction.class);
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Solicitud> listaSolicitudes;
	private String idusuario;
	private String nombre;
	private String apepat;
	private String apemat;
	private String departamento;
	private String nombreEdificio;
	private String direccion;
	private String asunto;
	private String detalle;
	
	@Override
    public String execute() throws Exception {
		log.info("execute()");
		
		buscaClienteYEdif(Integer.parseInt(idusuario));
		
		listaSolicitudes = DaoFactory.getSolicitudDao().getAllSolicitudes(Integer.parseInt(idusuario));
		
		log.info("lista ok");
		
		return SUCCESS;
	}
	
    public String adminSolicitudesOk() throws Exception {
    	
    	log.info("adminsolicitudes()");
    	
		buscaClienteYEdif(Integer.parseInt(idusuario));
		
		listaSolicitudes = DaoFactory.getSolicitudDao().getAllSolicitudesOk();
		
		return SUCCESS;
	}
    
    public String adminSolicitudesNo() throws Exception {
    	
    	log.info("adminsolicitudes()");
    	
		buscaClienteYEdif(Integer.parseInt(idusuario));
		
		listaSolicitudes = DaoFactory.getSolicitudDao().getAllSolicitudesNo();
		
		return SUCCESS;
	}    
	
    public String agregarsolicitud() throws Exception {	
		log.info("agregarsolicitud()");
		buscaClienteYEdif(Integer.parseInt(idusuario));
		return SUCCESS;
	}
    
    public String aceptanuevasolicitud() throws Exception {	
		log.info("Acepta Nueva solicitud");
		buscaClienteYEdif(Integer.parseInt(idusuario));
		
		Solicitud solic = new Solicitud();
		solic.setTicket(0);
		solic.setIdusuario(Integer.parseInt(idusuario));
		solic.setAsunto(asunto);
		solic.setDetalle(detalle);
		solic.setFechaSolicitud("");
		solic.setFechaSolicitud("");
		solic.setRespuesta("");
		
		if(DaoFactory.getSolicitudDao().insertSolicitud(solic)){
			asunto = "";
			detalle = "";
			return SUCCESS;
		}else{
			return ERROR;
		}
	}		    
	
	private void buscaClienteYEdif(int idusuario){
		Usuario clientelogueado;
		Edificio edifusuario;
		
		try{
			clientelogueado = DaoFactory.getUsuarioDao().getUsuarioById(idusuario);
			
			log.info("Id: " + idusuario);
			nombre = clientelogueado.getNombre();
			apepat = clientelogueado.getApepat();
			apemat = clientelogueado.getApemat();
			departamento = clientelogueado.getDepartamento();
			
			edifusuario = DaoFactory.getEdificioDao().getEdificioById(clientelogueado.getIdedificio());
			
			nombreEdificio = edifusuario.getNombre();
			direccion = edifusuario.getDireccion();			
		}catch (Exception e){
			log.error(e.getMessage());
		}				
	}

	public ArrayList<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}
	public void setListaSolicitudes(ArrayList<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}

	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApepat() {
		return apepat;
	}
	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getApemat() {
		return apemat;
	}
	public void setApemat(String apemat) {
		this.apemat = apemat;
	}

	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getNombreEdificio() {
		return nombreEdificio;
	}
	public void setNombreEdificio(String nombreEdificio) {
		this.nombreEdificio = nombreEdificio;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
}
