package buildings.action;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import buildings.dao.DaoFactory;
import buildings.model.Edificio;
import buildings.model.Usuario;

import com.opensymphony.xwork2.ActionSupport;

public class EdificioAction extends ActionSupport {
	private static final Logger log = Logger.getLogger(EdificioAction.class);
	private static final long serialVersionUID = 1L;	
	
	private Edificio edif;
	private ArrayList<Edificio> listaEdificios; 
	private int idEdificio;
	private String nombreEdif;
	private String direccion;
	private String ciudad;
	private int region;
	
	private int idusuario;
	private String nombre;
	private String apepat;
	
	@Override
    public String execute() throws Exception {
		
		log.info("execute()");
		
		edif = DaoFactory.getEdificioDao().getEdificioById(idEdificio);
		idEdificio = edif.getIdedificio();
		nombreEdif = edif.getNombre();
		direccion = edif.getDireccion();
		ciudad = edif.getCiudad();
		region = edif.getRegion();
		
		Usuario usu = new Usuario();
		usu = DaoFactory.getUsuarioDao().getUsuarioById(idusuario);
		nombre = usu.getNombre();
		apepat = usu.getApepat();
		
		return SUCCESS;
	}
	
    public String listarEdificios() throws Exception {
		
    	log.info("listarEdificios()");
    	
    	listaEdificios = DaoFactory.getEdificioDao().getAllEdificio();
		
		Usuario usu = new Usuario();
		usu = DaoFactory.getUsuarioDao().getUsuarioById(idusuario);
		nombre = usu.getNombre();
		apepat = usu.getApepat();
		
		return SUCCESS;
	}
    
    public String eliminarEdificio() throws Exception {
		
    	log.info("eliminarEdificio()");
    	
    	log.info("se eliminara el cliente con Id" + idEdificio);
    	
    	DaoFactory.getEdificioDao().deleteEdificioById(idEdificio);
    	
    	listaEdificios = DaoFactory.getEdificioDao().getAllEdificio();
		
		Usuario usu = new Usuario();
		usu = DaoFactory.getUsuarioDao().getUsuarioById(idusuario);
		nombre = usu.getNombre();
		apepat = usu.getApepat();
		
		return SUCCESS;
	}    
    
    public String nuevoEdificio() throws Exception {

    	log.info("nuevoEdificio()");
    	
		Usuario usu = new Usuario();
		usu = DaoFactory.getUsuarioDao().getUsuarioById(idusuario);
		nombre = usu.getNombre();
		apepat = usu.getApepat();
		
		return SUCCESS;
	}
    
    public String aceptaEditarEdificio() throws Exception {

    	log.info("aceptaEditarEdificio()");
    	
    	log.info(nombreEdif);
    	log.info(direccion);
    	log.info(ciudad);
    	log.info(region);
    	
		Usuario usu = new Usuario();
		usu = DaoFactory.getUsuarioDao().getUsuarioById(idusuario);
		nombre = usu.getNombre();
		apepat = usu.getApepat();
		
		Edificio edif = new Edificio();
		edif.setIdedificio(0);
		edif.setNombre(nombreEdif);
		edif.setDireccion(direccion);
		edif.setCiudad(ciudad);
		edif.setRegion(region);
		
		try{
			DaoFactory.getEdificioDao().updateEdificioById(idEdificio, edif);
		}catch(Exception e){
			log.info(e.getMessage());
		}
		
		return SUCCESS;
	}         
    
    public String aceptaNuevoEdificio() throws Exception {

    	log.info("aceptaNuevoEdificio()");
    	
    	log.info(nombreEdif);
    	log.info(direccion);
    	log.info(ciudad);
    	log.info(region);
    	
		Usuario usu = new Usuario();
		usu = DaoFactory.getUsuarioDao().getUsuarioById(idusuario);
		nombre = usu.getNombre();
		apepat = usu.getApepat();
		
		Edificio edif = new Edificio();
		edif.setIdedificio(0);
		edif.setNombre(nombreEdif);
		edif.setDireccion(direccion);
		edif.setCiudad(ciudad);
		edif.setRegion(region);
		
		try{
			DaoFactory.getEdificioDao().insertEdificio(edif);
		}catch(Exception e){
			log.info(e.getMessage());
		}
		
		return SUCCESS;
	}        
	
	public int getIdEdificio() {
		return idEdificio;
	}
	public void setIdEdificio(int idEdificio) {
		this.idEdificio = idEdificio;
	}

	public String getNombreEdif() {
		return nombreEdif;
	}
	public void setNombreEdif(String nombreEdif) {
		this.nombreEdif = nombreEdif;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}

	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
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

	public ArrayList<Edificio> getListaEdificios() {
		return listaEdificios;
	}

	public void setListaEdificios(ArrayList<Edificio> listaEdificios) {
		this.listaEdificios = listaEdificios;
	}	
}
