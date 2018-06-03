package Grafo;

public class GrafoNoDirigido extends Grafo {
	
	//Dadas 2 etiquetas conecta los vertices que se correspondan y le asigna el peso dado
	public boolean addArista(String _v1, String _v2, Integer _p) {
		//Compruebo que existan los vertices en el grafo
		if(this.containsVertice(_v1) && this.containsVertice(_v2)) {
			//Compruebo que no exista una arista que una estos 2 vertices
			if(!this.existArista(_v1, _v2)) {
				//Obtengo los vertices
				Vertice v1 = this.getVertice(_v1);
				Vertice v2 = this.getVertice(_v2);
				v1.addAdyacente(v2);
				v2.addAdyacente(v1);
				this.aristas.add(new Arista(v1, v2, _p));
				numA++;
				return true;
			}
			return false;
		}
		return false;
	}
	
	//Retorna TRUE si ya existe una arista que conecte los vertices que se correspondan con (_v1, _v2);
	public boolean existArista(String _v1, String _v2) {
		for(Arista a  : this.aristas) {
			if(a.getVertice1().getEtiqueta().equals(_v1) && a.getVertice2().getEtiqueta().equals(_v2)){
				return true;
			}
			else if (a.getVertice2().getEtiqueta().equals(_v1) && a.getVertice1().getEtiqueta().equals(_v2)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Arista getArista(String _v1, String _v2) {
		for(Arista a  : this.aristas) {
			if(a.getVertice1().getEtiqueta().equals(_v1) && a.getVertice2().getEtiqueta().equals(_v2)){
				return a;
			}
			else if (a.getVertice2().getEtiqueta().equals(_v1) && a.getVertice1().getEtiqueta().equals(_v2)) {
				return a;
			}
		}
		return null;
	}
}
