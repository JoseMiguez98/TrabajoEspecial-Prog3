import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Grafo.Arista;
import Grafo.Grafo;
import Grafo.GrafoDirigido;
import Grafo.Vertice;


public class test {

	public static void main(String[] args) {
//		CSVReader reader = new CSVReader("/home/jose/eclipse-workspace/TrabajoEspecial-Parte1[Programacion3]/src/csvfiles/dataset2.csv", ",");
//		LinkedList<Libro>libros = reader.listaDeLibros();
//		ArbolBusquedaBinaria abb= new ArbolBusquedaBinaria();
//		Set<String> generos = reader.getGeneros(libros);
//		CSVWritter writter = new CSVWritter("/home/jose/eclipse-workspace/TrabajoEspecial-Parte1[Programacion3]/src/csvfiles/prueba.csv");
//		Timer timer = new Timer();
//		
//		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//		
////		timer.start();
//		for(String genero : generos) {
//			abb.insert(genero, reader.getLibrosPorGenero(genero, libros));
//		}
////		System.out.println(timer.stop());
//		
//		try {
//			String genero = entrada.readLine();
//
//			
//			LinkedList<Libro>retorno = abb.getLibrosGenero(genero);
//			
//			writter.escribirSalida(retorno);
//			
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		CSVReader reader = new CSVReader("/home/jose/eclipse-workspace/TrabajoEspecial-Parte1[Programacion3]/src/csvfiles/2daEntrega/testDataset.csv", ",");
		Set<String> generos = reader.listaDeGeneros();
		GrafoDirigido grafo_generos = new GrafoDirigido();
		
		for(String g : generos) {
			grafo_generos.addVertice(g);
		}
		
//		grafo_generos.addVertice("a");
//		grafo_generos.addVertice("b");
//		grafo_generos.addVertice("c");
//		grafo_generos.addVertice("d");
//		grafo_generos.addVertice("e");
//		grafo_generos.addVertice("f");
//		grafo_generos.addVertice("g");
//		grafo_generos.addVertice("h");
//		grafo_generos.addVertice("i");
//		grafo_generos.addVertice("j");
//		grafo_generos.addVertice("k");
//		grafo_generos.addVertice("l");
//		
//		
//		grafo_generos.addArista("a", "b");
//		grafo_generos.addArista("b", "c");
//		grafo_generos.addArista("c", "d");
//		grafo_generos.addArista("d", "e");
//		grafo_generos.addArista("e", "b");
//		grafo_generos.addArista("d", "f");
//		grafo_generos.addArista("f", "g");
//		grafo_generos.addArista("g", "h");
//		grafo_generos.addArista("h", "i");
//		grafo_generos.addArista("i", "j");
//		grafo_generos.addArista("j", "f");
//		grafo_generos.addArista("h", "k");
//		grafo_generos.addArista("k", "l");
		
		reader.setComportamiento(grafo_generos);

		System.out.println(grafo_generos.tieneCiclo("b"));
		
		List<Vertice> vertices = grafo_generos.getVertices();
		
		for(Vertice v : vertices) {
			System.out.print(v.getEtiqueta()+ "\t");
		}
		
		System.out.print("\n");
		
		
		grafo_generos.getAfines();
		vertices = grafo_generos.getVertices();
		
		for(Vertice v : vertices) {
			System.out.print(v.getEtiqueta()+ "\t");
		}
		
//		String[]generosMasBuscados = grafo_generos.generosMasBuscados("terrasdasdsaddsaaor");
	
//		for(String g : generosMasBuscados) {
//			System.out.print(g + "\t");
//		}
//		
		
//		System.out.println(grafo_generos.containsVertice("terror"));
//		
//		grafo_generos.removeVertice("terror");
//		
//		System.out.println(grafo_generos.containsVertice("terror"));
		
		
		//No funciona obtener los N mas buscados, obtiene cualquiera y los manda;
		//Checkear el metodo setComportamiento() que su funcionamiento sea correcto;
	
//		System.out.println(grafo_generos.existArista("juegos", "política"));
	}
}
