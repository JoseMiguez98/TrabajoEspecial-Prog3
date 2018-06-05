package Grafo;
import java.util.Comparator;

public class ComparatorCostoArista implements Comparator<Arista> {

	@Override
	public int compare(Arista a1, Arista a2) {
//		System.out.println(a1.getVertice2().getEtiqueta()+": "+a1.getPeso());
//		System.out.println(a2.getVertice2().getEtiqueta()+": "+a2.getPeso());
		
		return a2.getPeso().compareTo(a1.getPeso());
	}
	
}
