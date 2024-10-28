
public class Refacciones {

	
	private  int id;
	private String nombre;
	private float precio;
	private int existencia;
	
	
	public Refacciones() {
	}


	public Refacciones(int id, String nombre, float precio, int existencia) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.existencia = existencia;
	}


	@Override
	public String toString() {
		return "Refacciones [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", existencia=" + existencia
				+ "]\n";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getExistencia() {
		return existencia;
	}


	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}
	
	
	
	
}
