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

		CSVReader reader = new CSVReader("/home/jose/eclipse-workspace/TrabajoEspecial-Parte1[Programacion3]/src/csvfiles/2daEntrega/dataset4.csv", ",");
		Timer timer = new Timer();
		GrafoDirigido grafo_generos = new GrafoDirigido();
		timer.start();
		Set<String> generos = reader.listaDeGeneros();
		
		
		for(String g : generos) {
			grafo_generos.addVertice(g);
		}
		
		reader.setComportamiento(grafo_generos);
		System.out.print(timer.stop());
//		System.out.println(grafo_generos.tieneCiclo("b"));
//		
//		List<Vertice> vertices = grafo_generos.getVertices();
//		
//		for(Vertice v : vertices) {
//			System.out.print(v.getEtiqueta()+ "\t");
//		}
//		
//		System.out.print("\n");
//		
//		
//		grafo_generos.getAfines();
//		vertices = grafo_generos.getVertices();
//		
//		for(Vertice v : vertices) {
//			System.out.print(v.getEtiqueta()+ "\t");
//		}
//		
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
