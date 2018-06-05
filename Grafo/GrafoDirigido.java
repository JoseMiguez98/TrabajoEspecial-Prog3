package Grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrafoDirigido extends Grafo {

	@Override
	public boolean existArista(String _v1, String _v2) {
		for(Arista a  : this.aristas) {
			if(a.getVertice1().getEtiqueta().equals(_v1) && a.getVertice2().getEtiqueta().equals(_v2)){
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
		}
		return null;
	}

	@Override
	public boolean addArista(String _v1, String _v2, Integer _p) {
		//		System.out.println(_v1+" "+_v2);
		//Compruebo que existan los vertices en el grafo
		if(this.containsVertice(_v1) && this.containsVertice(_v2)) {
			//Compruebo que no exista una arista que una estos 2 vertices
			if(!this.existArista(_v1, _v2)) {
				//Obtengo los vertices
				Vertice v1 = this.getVertice(_v1);
				Vertice v2 = this.getVertice(_v2);
				Arista nueva_arista = v1.addAdyacente(v2);
				this.aristas.add(nueva_arista);
				numA++;
				return true;
			}
			return false;
		}
		return false;
	}

	//Comienza el rercorrido DFS desde el inicio dado para determinar
	public boolean tieneCiclo(String _e) {
		Vertice inicio = this.getVertice(_e);
		if(inicio==null) {
			return false;
		}
		Integer[]visitados = new Integer[this.vertices.size()];
		for(int i=0 ; i<visitados.length ; i++) {
			visitados[i] = 0;
		}
		visitados[this.vertices.indexOf(inicio)] = 1;

		return tieneCiclo(inicio, visitados);
	}

	private boolean tieneCiclo(Vertice _v, Integer[] _vi){
		//Obtengo los vertices adyacentes al actual
		List<Vertice> adyacentes = _v.getAdyacentes();
		//Recorro la lista de adyacentes
		for(Vertice v : adyacentes) {
			if(_vi[this.vertices.indexOf(v)].equals(0)) {
				_vi[this.vertices.indexOf(v)] = 1;
				if (tieneCiclo(v, _vi)) {
					return true;
				}
			}
			else if (_vi[this.vertices.indexOf(v)].equals(1)) {
				return true;
			}
		}

		_vi[this.vertices.indexOf(_v)] = 2;

		return false;
	}

	public String[] generosMasBuscados(String _g, Integer _n) {
		String[]solucion = new String[_n];
		Vertice genero;
		List<Arista>adyacentes;
		Arista[]NAristasMayorPeso = new Arista[_n];
		Vertice[]NVerticesMayorPeso = new Vertice[_n];

		if(this.containsVertice(_g)) {
			genero = this.getVertice(_g);
			adyacentes = genero.getAristas();
			if(adyacentes.size() < _n) {
				_n = adyacentes.size();
				solucion = new String[_n];
				NAristasMayorPeso = new Arista[_n];
				NVerticesMayorPeso = new Vertice[_n];
			}
		}

		else {
			String[]error = new String[1];
			error[0] = "No existe el genero ingresado";
			return error;
		}

		Collections.sort(adyacentes, new ComparatorCostoArista());

		//		for(Arista a : adyacentes) {
		//			System.out.println(a.getVertice2().getEtiqueta());
		//		}
		//		
		for(int i = 0; i<_n ; i++) {
			NAristasMayorPeso[i] = adyacentes.get(i);
		}

		for(int i = 0 ; i<_n ; i++) {
			NVerticesMayorPeso[i] = NAristasMayorPeso[i].getVertice2();
		}

		for(int i = 0 ; i<_n ; i++) {
			solucion[i] = NVerticesMayorPeso[i].getEtiqueta();
		}

		return solucion;


	}
}
