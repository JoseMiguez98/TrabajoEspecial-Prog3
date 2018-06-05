import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import Grafo.Grafo;

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
	//Crea aristas entre los generos las cuales determinan el comportamiento de usuario
	//contando cuantas veces se busco un genero inmediatamente despues de otro
	public void setComportamiento(Grafo _g) {
//		int contador = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
//				contador++;
//				System.out.println("\n");
				//Obtengo el orden de busqueda de la linea actual
				String[] items = line.split(csvSplitBy);
//				
//				for(String i : items) {
//					System.out.print(i + "\t");
//				}
				
//				System.out.println(contador);
				
				//Creo las aristas
				for(int i = 0 ; i<items.length-1 ; i++) {
//					System.out.println("\n");
//					System.out.println(contador);
					//Si existe la arista le sumo 1 a esta
					if(_g.existArista(items[i], items[i+1])) {
//						System.out.println("Ya existentes:=================");
//					    System.out.print(items[i]+" "+items[i+1]);
//					    System.out.println("\n");
						_g.aumentarPesoArista(items[i], items[i+1]);
					}
					//Si no creo una nueva con peso 1
					else {
						System.out.println("No existentes:");
						System.out.print(items[i]+" "+items[i+1]);
						System.out.println("\n");
						System.out.println(_g.addArista(items[i], items[i+1]));
					}
				}
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Obtengo todos los generos del dataset sin repetidos
	public Set<String>listaDeGeneros(){
//		System.out.println("====LinkedList=====");
//		Timer timer = new Timer();
		//Conjunto solucion vacio
		Set <String>generos=new HashSet<String>();
//		int contador = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
//				contador++;
//				System.out.println(contador);
				//Spliteo todos los generos y los voy agregando al conjunto
				String[] items = line.split(csvSplitBy);
				
//				for(String i : items) {
//					System.out.println(i);
//				}
//					
				for(String g : items) {
					generos.add(g);
				}
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return generos;
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
		LinkedList<Libro> libros=new LinkedList<Libro>();
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