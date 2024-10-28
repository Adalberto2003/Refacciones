import java.util.ArrayList;
import java.util.List;

public class Implementacion implements Metodos {

	private List<Refacciones> listaAgr = new ArrayList<Refacciones>();

	@Override
	public boolean guardar(Refacciones refaccion) {
		// TODO Auto-generated method stub

		Boolean bandera = false;

		// Codicion
		for (Refacciones r : listaAgr) {
			if (r.getId() == refaccion.getId()) {
				bandera = true;
				break;
			}
		}
		if (bandera == false)
			listaAgr.add(refaccion);
		return bandera;
	}

	@Override
	public List<Refacciones> listar() {
		// TODO Auto-generated method stub
		return listaAgr;
	}

	@Override
	public Refacciones buscar(int indice) {
		// TODO Auto-generated method stub

		return listaAgr.get(indice);

	}

	@Override
	public void editar(int indice, Refacciones refaccion) {
		// TODO Auto-generated method stub
		listaAgr.set(indice, refaccion);
	}

	@Override
	public void eliminar(int indice) {
		// TODO Auto-generated method stub
		listaAgr.remove(indice);

	}
	
	public void indiceNombre(){
		System.out.println("Registros en la lista por indice");
		for(int i = 0; i <listaAgr.size(); i++) {
			System.out.println("[" + i + "] " + listaAgr.get(i).getNombre());
		}
	
}
}