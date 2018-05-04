import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
	
	//Retorno una lista con los libros (LinkedList)
	public LinkedList<Libro>listaDeLibros(){
//		System.out.println("====LinkedList=====");
//		Timer timer = new Timer();
		LinkedList <Libro>biblioteca=new LinkedList<Libro>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				
				String[] items = line.split(csvSplitBy);
				Libro l= new Libro(items[0],items[1],items[2]);
				String[] generos = items[3].split(" ");
				for(int i=0;i<generos.length;i++){
					l.addGenero(generos[i]);
				}
				
//				timer.start(); //Mido el tiempo que tarda en insertar un elemento en la LinkedList
				biblioteca.add(l);
//				System.out.println(timer.stop());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return biblioteca;
	}
	
//	//Retorno una lista con los libros
//		public ArrayList<Libro>listaDeLibrosArrayList(){
//			ArrayList <Libro>biblioteca=new ArrayList<Libro>();
//			
//			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//				while ((line = br.readLine()) != null) {
//					
//					String[] items = line.split(csvSplitBy);
//					Libro l= new Libro(items[0],items[1],items[2]);
//					String[] generos = items[3].split(" ");
//					for(int i=0;i<generos.length;i++){
//						l.addGenero(generos[i]);
//					}
//					biblioteca.add(l);
//									}
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//			return biblioteca;
//		}
//	
	
	public Set<String> getGeneros(LinkedList<Libro> _l){
		Set<String> generos = new HashSet<String>();
		
		for (Libro libro : _l) {
			List<String>generosActuales = libro.getGeneros();
			for(String genero : generosActuales) {
				generos.add(genero);
			}
		}
		
		return generos;
	}
	public LinkedList<Libro> getLibrosPorGenero(String i,LinkedList<Libro>l){
		LinkedList<Libro> libros=new LinkedList();
		for(Libro libro : l){
			if(libro.containsGenero(i)){
				libros.add(libro);
			}
			
		}
		return libros;
	}
	
	
	
	
	
	
//	//Retorno todos los atributos X de una colecci�n dada de libros
//	public Set<String> getAtributo(List<HashMap<String, String>> _libros, String _atr){
//		Set<String> atributos = new HashSet<String>();
//		//Si la lista de libros esta vacia o no contienen el atributo pedido retorno un conjunto vacio
//		if(_libros.isEmpty() || !_libros.get(0).containsKey(_atr)) {
//			return atributos;
//		}
//		
//		//Recorro la lista de libros
//		for(int i=0 ; i<_libros.size() ; i++) {
//			//Le pido todos sus generos
//			String str = _libros.get(i).get(_atr);
//			//Creo un array con los generos del libro en cuestion para manipularlo mas facil
//			String[]str_array = str.split(" ");
//			//Agrego todos los generos (SIN REPETIDOS) a un SET
//			for(String key : str_array) {
//				atributos.add(key);
//			}
//		}
//		//Retorno un SET de todos los generos existentes en la lista de libros (SIN REPETIDOS)
//		return atributos;
//	}
	
	
}