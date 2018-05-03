import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class test {

	public static void main(String[] args) {
		CSVReader reader = new CSVReader("/home/jose/eclipse-workspace/TrabajoEspecial-Parte1[Programacion3]/src/csvfiles/dataset2.csv", ",");
		LinkedList<Libro> libros = reader.listaDeLibros();

		Set<String> generos = reader.getGeneros(libros);

		for(String genero : generos) {
			System.out.println(genero);
		}
	}
}
