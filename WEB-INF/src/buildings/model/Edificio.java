package buildings.model;

public class Edificio {
	private int idedificio;
	private String nombre;
	private String direccion;
	private String ciudad;
	private int region;
	
	public Edificio() {}	
	
	public Edificio(int idedificio, String nombre, String direccion,
	String ciudad, int region) {
		super();
		this.idedificio = idedificio;
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.region = region;
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
}
