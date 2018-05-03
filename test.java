import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class test {

	public static void main(String[] args) {
		CSVReader reader = new CSVReader("/home/turbio/programacion3/TrabajoPractico-Programacion3/csvfiles/dataset2.csv", ",");
		LinkedList<Libro> libros = reader.listaDeLibros();
		ArbolBusquedaBinaria abb= new ArbolBusquedaBinaria();
		Set<String> generos = reader.getGeneros(libros);

		for(String genero : generos) {
			abb.insert(genero, reader.getLibrosPorGenero(genero, libros));
		}
		List<String> gen=abb.inOrder();
		for(String g : gen){
			System.out.println(g);
		}
	}
}
