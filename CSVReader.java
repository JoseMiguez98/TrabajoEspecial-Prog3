import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSVReader {

	private String csvFile;
	private String line;
	private String csvSplitBy;
	

	public CSVReader(String _path, String _split) {
		this.csvFile = _path;
		this.csvSplitBy = _split;
	}
	
	//Retorno una lista con los libros
	public List<HashMap<String, String>> getLibros(){
		
		List<HashMap<String, String>> libros = new ArrayList<HashMap<String, String>>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				HashMap<String, String> libro_actual = new HashMap<String, String>();
				String[] items = line.split(csvSplitBy);
				//Cargo los datos del libro actual en un mapa
				libro_actual.put("Generos", items[3]);
				libro_actual.put("Paginas", items[2]);
				libro_actual.put("Autor", items[1]);
				libro_actual.put("Titulo", items[0]);
				//Agrego el libro a la lista de retorno
				libros.add(libro_actual);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return libros;
	}
	
	//Retorno todos los atributos X de una colección dada de libros
	public Set<String> getAtributo(List<HashMap<String, String>> _libros, String _atr){
		Set<String> atributos = new HashSet<String>();
		//Si la lista de libros esta vacia o no contienen el atributo pedido retorno un conjunto vacio
		if(_libros.isEmpty() || !_libros.get(0).containsKey(_atr)) {
			return atributos;
		}
		
		//Recorro la lista de libros
		for(int i=0 ; i<_libros.size() ; i++) {
			//Le pido todos sus generos
			String str = _libros.get(i).get(_atr);
			//Creo un array con los generos del libro en cuestion para manipularlo mas facil
			String[]str_array = str.split(" ");
			//Agrego todos los generos (SIN REPETIDOS) a un SET
			for(String key : str_array) {
				atributos.add(key);
			}
		}
		//Retorno un SET de todos los generos existentes en la lista de libros (SIN REPETIDOS)
		return atributos;
	}
}