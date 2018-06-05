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
		
		reader.setComportamiento(grafo_generos);
		
		String[]generosMasBuscados = grafo_generos.generosMasBuscados("terror", 3);
	
		for(String g : generosMasBuscados) {
			System.out.print(g + "\t");
		}
		
		//No funciona obtener los N mas buscados, obtiene cualquiera y los manda;
		//Checkear el metodo setComportamiento() que su funcionamiento sea correcto;
	
//		System.out.println(grafo_generos.existArista("juegos", "política"));
	}
}
