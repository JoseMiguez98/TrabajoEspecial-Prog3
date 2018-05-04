import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class test {

	public static void main(String[] args) {
		CSVReader reader = new CSVReader("/home/jose/eclipse-workspace/TrabajoEspecial-Parte1[Programacion3]/src/csvfiles/dataset2.csv", ",");
		LinkedList<Libro> libros = reader.listaDeLibros();
		ArbolBusquedaBinaria abb= new ArbolBusquedaBinaria();
		Set<String> generos = reader.getGeneros(libros);
		CSVWritter writter = new CSVWritter("/home/jose/eclipse-workspace/TrabajoEspecial-Parte1[Programacion3]/src/csvfiles/prueba.csv");
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		for(String genero : generos) {
			abb.insert(genero, reader.getLibrosPorGenero(genero, libros));
		}
		
		try {
			String genero = entrada.readLine();

			
			LinkedList<Libro>retorno = abb.getLibrosGenero(genero);
			
			writter.escribirSalida(retorno);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
