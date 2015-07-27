package buildings.action;

import java.util.ArrayList;

import buildings.model.Usuario;
import buildings.model.Edificio;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import buildings.dao.DaoFactory;

public class LoginAction extends ActionSupport {
	
	private static final Logger log = Logger.getLogger(LoginAction.class);
	public static final String ADMIN = "admin";
	public static final String RETORNA = "retorna";
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Edificio> listaEdificios;
	private String idusuario = "";
	private String passwordusuario = "";
	private String nombre;
	private String apepat;
	private String apemat;
	private String departamento;
	private String nombreEdificio;
	private String direccion;
	private String datosOk;
	
	@Override
    public String execute() throws Exception {
		int categoriaUsuario = 0;
		String passwordUsuario = "";
		Usuario usuariologueado;
		Edificio edifusuario;
		log.info("execute()");
    	
    	try{
    		categoriaUsuario = DaoFactory.getLoginDao().getCategoriaUser(Integer.parseInt(idusuario));
    		passwordUsuario = DaoFactory.getLoginDao().getPasswordUser(Integer.parseInt(idusuario));
    	}catch (Exception e){
    		log.error(e.getMessage());
    	}
    	
    	if(idusuario.equals("") || passwordusuario.equals("")){
    		datosOk = "error";
    		return RETORNA;
    	}else{
    		if(passwordusuario.equals(passwordUsuario)){
    			
    			//setea cookies
    			
    			if(categoriaUsuario == 2 || categoriaUsuario == 3){
    				//buscar datos usuario
    				
    				try{
    					usuariologueado = DaoFactory.getUsuarioDao().getUsuarioById(Integer.parseInt(idusuario));
    					//clientelogueado = usuDao.getUsuarioById(Integer.parseInt(idusuario));
    					
    					log.info("Id: " + idusuario);
        				nombre = usuariologueado.getNombre();
        				apepat = usuariologueado.getApepat();
        				apemat = usuariologueado.getApemat();
        				departamento = usuariologueado.getDepartamento();
        				
        				edifusuario = DaoFactory.getEdificioDao().getEdificioById(usuariologueado.getIdedificio());
        				//Edificio edifusuario = ediDao.getEdificioById(clientelogueado.getIdedificio());  
        				
        				nombreEdificio = edifusuario.getNombre();
        				direccion = edifusuario.getDireccion();        				
    				}catch (Exception e){
    					log.error(e.getMessage());
    				}
    				
    				return SUCCESS;
    			}else{
    				log.info("Es Admin");
    				
					usuariologueado = DaoFactory.getUsuarioDao().getUsuarioById(Integer.parseInt(idusuario));
					//clientelogueado = usuDao.getUsuarioById(Integer.parseInt(idusuario));
					
					log.info("Id: " + idusuario);
    				nombre = usuariologueado.getNombre();
    				apepat = usuariologueado.getApepat();
    				apemat = usuariologueado.getApemat();
    				
    				listaEdificios = DaoFactory.getEdificioDao().getAllEdificio();
    				
    				listaUsuarios = new ArrayList<Usuario>();
    				
    				try{
    					listaUsuarios = DaoFactory.getUsuarioDao().getAllUsuarios();
    					//listaUsuarios = usuDao.getAllUsuarios();
    				}catch (Exception e){
    					log.error(e.getMessage());
    				}
    				
    				return ADMIN;
    			}
    		}else{
    			datosOk = "error";
    			return RETORNA;
    		}
    	}
    }

	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}	
	
	public String getPasswordusuario() {
		return passwordusuario;
	}
	public void setPasswordusuario(String passwordusuario) {
		this.passwordusuario = passwordusuario;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}	
	
	public ArrayList<Edificio> getListaEdificios() {
		return listaEdificios;
	}

	public void setListaEdificios(ArrayList<Edificio> listaEdificios) {
		this.listaEdificios = listaEdificios;
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

	public String getDatosOk() {
		return datosOk;
	}
	public void setDatosOk(String datosOk) {
		this.datosOk = datosOk;
	}		
}
