import java.util.List;

public interface Metodos {
	
	public boolean guardar (Refacciones refaccion);
	
	public List<Refacciones> listar();
	
	public Refacciones buscar(int indice);

	public void editar(int indice, Refacciones refaccion);

	public void eliminar(int indice);
	
	

}
