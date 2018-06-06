

import java.util.List;
import java.util.ArrayList;

public class Vertice {
	private List<Arista>adyacentes;
	private String etiqueta;

	public Vertice(String _e) {
		this.adyacentes = new ArrayList<Arista>();
		this.etiqueta = _e;
	}

	//Retorna la etiqueta del vertice
	public String getEtiqueta() {
		return this.etiqueta;
	}

	//Retorna si es adyacente con otro vertice
	public boolean esAdyacente(Vertice _v) {
		for(Arista a: this.adyacentes) {
			if(a.getVertice2().equals(_v)) {
				return true;
			}
		}
		return false;
	}

	//Retorna una lista con la etiqueta de todos los adyacentes
	public Object getEtiquetaAdyacentes() {
		List<String>retorno = new ArrayList<String>();

		for(Arista a: this.adyacentes) {
			if(a.getVertice1().equals(this)) {
				retorno.add(a.getVertice2().getEtiqueta());
			}
			else {
				retorno.add(a.getVertice1().getEtiqueta());
			}
		}

		return retorno;
	}
	
	//Agrega un adyacente a la lista
	public Arista addAdyacente(Vertice _v) {
		for(Arista a: this.adyacentes) {
			//Checkea que no se quiera conectar con un repetido
			if(a.getVertice2().getEtiqueta().equals(_v.getEtiqueta())) {
				return null;
			}
		}
		Arista a = new Arista(this, _v, 1);
		this.adyacentes.add(a);
		return a;
	}

	//Retorna TRUE si coinciden en etiqueta , para evitar redundancia de datos
//	public boolean equals(Vertice _v) {
//		if(this.etiqueta.equals(_v.getEtiqueta())){
//			return true;
//		}
//		return false;
//	}

	//Retorna un hashCode del vertice
	public int hashCode() {
		return this.etiqueta.hashCode();
	}

	//Retorna una lista con los vertices adyacentes
	public List<Vertice> getAdyacentes(){
		List<Vertice>retorno = new ArrayList<Vertice>();
		for(Arista a : this.adyacentes) {
			if(a.getVertice1().equals(this)) {
				retorno.add(a.getVertice2());
			}
			else {
				retorno.add(a.getVertice1());
			}
		}

		return retorno;
	}
	
	public List<Arista>getAristas(){
		List<Arista>solucion = new ArrayList<Arista>(this.adyacentes);
		return solucion;
	}
}
