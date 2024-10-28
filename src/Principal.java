import java.util.Scanner;

public class Principal {

	public static final String BLUE = "\033[0;34m"; // Azul
	public static final String CYAN = "\033[0;36m"; // Cian
	public static final String RED = "\033[0;31m"; // Rojo
	public static final String RESET = "\033[0m"; // Restablecer el color por defecto

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("ESTE ESPACIO HA SIDO MODIFICADO");
		// Declaracion de variables

		int id = 0;
		String nombre;
		float precio = 0;
		int existencia = 0;

		Refacciones refaccion = null;

		int menup, submenu, indice;

		// Instancia de clase para acceso a los metodos generados

		Implementacion imp = new Implementacion();

		do {
			System.out.println(BLUE + "//////BIENVENIDO AL SISTEMA DE REFACCIONES////// ");
			System.out.println(CYAN + "1... ALTA DE REFACCION");
			System.out.println(CYAN + "2... MOSTRAR PRODUCTOS EXISTENTES");
			System.out.println(CYAN + "3... BUSCAR PRODUCTO");
			System.out.println(CYAN + "4... EDITAR PRODUCTO");
			System.out.println(CYAN + "5... ELIMINAR PRODUCTO");
			System.out.println(CYAN + "6... SALIR" + RESET);

			Scanner lectura = new Scanner(System.in);
			menup = lectura.nextInt();

			switch (menup) {
			case 1:

				// Ingreso de ID del producto (int)
				boolean idValido = false;
				while (!idValido) {
					System.out.println("Ingrese ID del producto (número entero):");
					try {
						lectura = new Scanner(System.in);
						id = lectura.nextInt();
						idValido = true; // Si se ingresa un entero válido, salimos del bucle
					} catch (Exception e) {
						System.out.println(RED
								+ "Entrada inválida. Debes introducir un número entero. Inténtalo de nuevo." + RESET);
					}
				}

				// Ingreso de nombre del producto (String)
				System.out.println("Ingrese nombre del producto:");
				lectura = new Scanner(System.in);
				nombre = lectura.nextLine(); // No se requiere validación especial para strings

				// Ingreso de precio del producto (double)
				boolean precioValido = false;
				while (!precioValido) {
					System.out.println("Ingrese precio del producto :");
					try {
						lectura = new Scanner(System.in);
						precio = lectura.nextFloat();
						precioValido = true; // Si se ingresa un valor float válido, salimos del ciclo
					} catch (Exception e) {
						System.out.println(RED
								+ "Entrada inválida. Debes introducir un número decimal. Inténtalo de nuevo." + RESET);
					}
				}

				// Ingreso de existencia del producto (int)
				boolean existenciaValida = false;
				while (!existenciaValida) {
					System.out.println("Ingrese número de existencia del producto (número entero):");
					try {
						lectura = new Scanner(System.in);
						existencia = lectura.nextInt();
						existenciaValida = true; // Si se ingresa un entero válido, salimos del ciclo

					} catch (Exception e) {
						System.out.println(RED
								+ "Entrada inválida. Debes introducir un número entero. Inténtalo de nuevo." + RESET);
					}

					refaccion = new Refacciones(id, nombre, precio, existencia);
					if (imp.guardar(refaccion) == false)
						System.out.println("Se guardo correctamente");

					else
						System.out.println("Ese registro ya existe");
				}

				break;

			case 2:
				if (imp.listar().size() > 0)
					System.out.println(imp.listar());
				else
					System.out.println(RED + "No hay contenido que mostrar agregue nueva informacion" + RESET);

				break;
			case 3:
				imp.indiceNombre();
				boolean bandera = false;
				if (imp.listar().size() > 0)
					System.out.println(imp.listar());
				else
					System.out.println(RED + "No hay contenido que mostrar agregue nueva informacion" + RESET);
				try {
					System.out.println("Ingrese el indice a buscar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();
					bandera = true;

					// Busqueda
					refaccion = imp.buscar(indice);
					System.out.println("Se encontro " + refaccion);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Ingreso un valor invalido intente de nuevo. Ejmp (0,1,2...)");
				}

				break;
			case 4:
				imp.indiceNombre();

				try {
					System.out.println("Ingresa el indice a editar ");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// Busqueda
					refaccion = imp.buscar(indice);
					System.out.println("Se encontro " + refaccion);
					// Submenu--- mombre y precio
					do {
						System.out.println("SUBMENU PARA EDITAR");
						System.out.println(CYAN + "1...ID");
						System.out.println(CYAN + "2...NOMBRE");
						System.out.println(CYAN + "3...PRECIO");
						System.out.println(CYAN + "4...EXISTENCIA");
						System.out.println(CYAN + "5...REGRESAR" + RESET);
						lectura = new Scanner(System.in);
						submenu = lectura.nextInt();

						switch (submenu) {
						case 1:
							System.out.println("Ingrese nuevo id");
							lectura = new Scanner(System.in);
							id = lectura.nextInt();
							// actualizacion
							refaccion.setId(id);
							imp.editar(indice, refaccion);
							System.out.println("Se edito con exito " + refaccion);

							break;
						case 2:
							System.out.println("Ingrese nuevo nombre");
							lectura = new Scanner(System.in);
							nombre = lectura.nextLine();
							// Actualizacion
							refaccion.setNombre(nombre);

							imp.editar(indice, refaccion);
							System.out.println("Se edito con exito" + refaccion);

							break;
						case 3:
							System.out.println("Ingrese nuevo precio");
							lectura = new Scanner(System.in);
							precio = lectura.nextFloat();
							// Actualizacion
							refaccion.setPrecio(precio);

							imp.editar(indice, refaccion);
							System.out.println("Se edito con exito" + refaccion);
							break;
						case 4:
							System.out.println("Ingrese nueva existencia");
							lectura = new Scanner(System.in);
							existencia = lectura.nextInt();
							// Actualizacion
							refaccion.setExistencia(existencia);

							imp.editar(indice, refaccion);
							System.out.println("Se edito con exito" + refaccion);
							break;
						case 5:

							break;

						default:
							System.out.println(RED + "OPCION NO DISPONIBLE INTENTE DE NUEVO" + RESET);

							break;
						}
					} while (submenu != 5);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(RED + "NO SE ENCONTRO LA INFORMACION");
				}

				break;
			case 5:

				imp.indiceNombre();

				try {

					System.out.println("Ingresa el indice a eliminar ");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// eliminacion
					imp.eliminar(indice);
					System.out.println("Se elimino");
				} catch (Exception e) {
					// TODO: handle exception

					System.err.println(RED + "Ese registro no existe intente de nuevo " + RESET);
				}
				break;
			case 6:

				break;

			default:
				System.out.println(RED + "OPCION NO DISPONIBLE INTENTE DE NUEVO" + RESET);
				break;
			}

		} while (menup != 6);

	}

}
