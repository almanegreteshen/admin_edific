package buildings.action;

import org.apache.log4j.Logger;

import buildings.dao.UsuarioDao;
import buildings.model.Usuario;

import com.opensymphony.xwork2.ActionSupport;

public class ClienteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ClienteAction.class);
	
	private String rut;
	private Usuario usuarioEditar;
	
	@Override
    public String execute() throws Exception {
		UsuarioDao usuDao = new UsuarioDao();
		
		log.info("RutCli: " + rut);
    	return SUCCESS;
    }
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
}
