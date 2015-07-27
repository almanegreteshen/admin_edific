package buildings.model;

public class Usuario {
	private int idusu;
	private String passwordusu;
	private int idedificio;
	private String nombre;
	private String apepat;
	private String apemat;
	private String departamento;
	private int tipousu;	
	
	public Usuario() {}
	
	public Usuario(int idusu, String passwordusu, int idedificio,
			String nombre, String apepat, String apemat, String departamento,
			int tipousu) 
	{
		super();
		this.idusu = idusu;
		this.passwordusu = passwordusu;
		this.idedificio = idedificio;
		this.nombre = nombre;
		this.apepat = apepat;
		this.apemat = apemat;
		this.departamento = departamento;
		this.tipousu = tipousu;
	}	
	
	public int getIdusu() {
		return idusu;
	}

	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}

	public String getPasswordusu() {
		return passwordusu;
	}

	public void setPasswordusu(String passwordusu) {
		this.passwordusu = passwordusu;
	}

	public int getIdedificio() {
		return idedificio;
	}

	public void setIdedificio(int idedificio) {
		this.idedificio = idedificio;
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

	public int getTipousu() {
		return tipousu;
	}

	public void setTipousu(int tipousu) {
		this.tipousu = tipousu;
	}
}
