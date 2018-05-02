import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class test {

	public static void main(String[] args) {
		CSVReader reader = new CSVReader("/home/jose/eclipse-workspace/TrabajoEspecial-Parte1[Programacion3]/src/csvfiles/dataset2.csv", ",");

		List<HashMap<String, String>> libros = reader.getLibros();
		Set<String>keys = libros.get(0).keySet();

//		for(int i = 0; i<libros.size() ; i++) {
//			HashMap<String, String>libro_actual = new HashMap<>(libros.get(i));
//			System.out.println("============================================");
//			for(String key : keys) {
//				System.out.println(key + ":" + libro_actual.get(key) +"\n");
//			}
//			System.out.println("============================================");
//		}
		
		Set<String>generos = reader.getAtributo(libros, "Titulo");
		
		for(String genero : generos) {
			System.out.println(genero);
		}
	}
}
