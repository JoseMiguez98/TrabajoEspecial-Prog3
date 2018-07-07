import java.util.List;
import Grafo.GrafoDirigido;


public class test {

	public static void main(String[] args) {

		CSVReader reader = new CSVReader("/home/jose/eclipse-workspace/TrabajoEspecial-Parte1[Programacion3]/src/csvfiles/2daEntrega/dataset4.csv", ",");
		GrafoDirigido grafo = new GrafoDirigido();

		grafo.addVertice("1");
		grafo.addVertice("2");
		grafo.addVertice("3");
		grafo.addVertice("4");
		grafo.addVertice("5");
		grafo.addVertice("6");
		grafo.addVertice("7");

		grafo.addArista("1", "2");
		grafo.addArista("2", "4");
		grafo.addArista("4", "3");
		grafo.addArista("3", "2");
		grafo.addArista("4", "5");
		grafo.addArista("5", "6");
		grafo.addArista("6", "7");
		grafo.addArista("7", "2");

		List<String>afines = grafo.getAfines("4");

		if(afines!=null) {

			for(String g: afines) {
				System.out.print(g+"\t");	
			}
		}
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
