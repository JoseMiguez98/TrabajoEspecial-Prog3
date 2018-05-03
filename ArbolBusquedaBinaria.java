import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


//Nodo es una clase auxiliar al arbol binario por eso va dentro del mismo archivo

class Nodo {
	private String indice;
	private Nodo der;
	private Nodo izq;
	private List<Libro> libros;

	protected Nodo() {
		indice = null;
		der = null;
		izq = null;
		libros = new LinkedList<Libro>();
	}

	protected Nodo(String _i) {
		setIndice(_i);
		izq = null;
		der = null;
		libros = new LinkedList<Libro>();
	}
	protected void setIndice(String _i) {
		indice = _i;
	}

	protected void setIzq(Nodo n) {
		this.izq = n;
	}

	protected void setDer(Nodo n) {
		this.der = n;
	}
	protected String getInfo() {
		return indice;
	}
	protected Nodo getDer() {
		return der;
	}
	protected Nodo getIzq() {
		return izq;
	}
	protected void setLista(LinkedList<Libro>l){
		libros=l;
	}
	protected LinkedList<Libro> getLibros(){
		return new LinkedList<Libro>(this.libros);
	}
	protected boolean insertLibro(Libro _l) {
		if (!this.libros.contains(_l)) {
			this.libros.add(_l);
			return true;
		}
		return false;
	}
}

///////////////////////////
public class ArbolBusquedaBinaria {
	private Nodo raiz;

	public ArbolBusquedaBinaria() {
		this.raiz = new Nodo();
	}

	public ArbolBusquedaBinaria(String _i) {
		this.raiz.setIndice(_i);
	} 

	public Object getRoot() {
		return this.raiz.getInfo();
	}

	//Auxiliar para comenzar el recorrido recursivo antes de insertar
	public boolean insert(String _i,LinkedList<Libro> l) {
		return this.insert(this.raiz, _i,l);
	}

	//Inserta un elemento en el ABB, retorna TRUE si la operacion fue exitosa
	private boolean insert(Nodo _n, String _i, LinkedList<Libro> l) {
		//Si el nodo es desigual a nulo comienzo a recorrer el arbol para determinar donde insertar el elemento
		if(_n != null) {
			//Si _n.info es desigual a nulo comienzo a preguntar para ver donde inserto el elemento
			if(_n.getInfo() != null) {
				//Si el elemento ya existe en el ABB retorno FALSE
				if(_n.getInfo().equals(_i)) {
					return false;
				}
				//Si el elemento que quiero insertar es menor al actual entro recursivamente con el sub-arbol izquierdo
				else if(_i.compareTo(_n.getInfo()) < 0) {
					//Si mi izquierdo es nulo inserto el elemento
					if(_n.getIzq() == null) {
						_n.setIzq(new Nodo(_i));
						_n.getIzq().setLista(l);
						
						return true;
					}
					//Si no llamo recursivamente a la función con el sub-arbol derecho
					else {
						return insert(_n.getIzq(), _i ,l);
					}
				}
				//Si el elemento que quiero insertar es mayor al actual entro recursivamente con el sub-arbol derecho
				else {
					//Si el nodo derecho es nulo inserto el elemento
					if(_n.getDer() == null) {
						_n.setDer(new Nodo(_i));
						_n.getDer().setLista(l);
						return true;
					}
					//Si no llamo recursivamente a la funcion
					else {
						return insert(_n.getDer(), _i,l);
					}
				}
			}
			//Si el nodo no tiene info inserto el elemento en esta posición  
			else {
				_n.setIndice(_i);
				_n.setLista(l);
				return true;
			}
		}
		//Si llegue a un nodo nulo lo instancio con la info pasada por parametro
		else {
			_n = new Nodo(_i);
			_n.setLista(l);
			return true;
		}
		
	}

	//Auxiliar para comenzar la busqueda recursiva
	public boolean hasElement(String _i) {
		return this.hasElement(this.raiz, _i);
	}

	//Retorna TRUE si un elemento dado existe en el ABB
	public boolean hasElement(Nodo _n, String _i) {
		//Si _n es desigual a nulo comienzo a preguntar
		if (_n != null) {
			//Si encontre el elemento que estoy buscando retorno true
			if(_n.getInfo().equals(_i)) {
				return true;
			}
			//Si el elemento que estoy buscando es mayor al actual entro recursivamente con el sub-arbol izquierdo
			else if (_i.compareTo(_n.getInfo()) < 0) {
				return hasElement(_n.getIzq(), _i);
			}
			//Si el elemento que estoy buscando es menor que el actual entro recursivamente con el sub-arbol derecho
			else {
				return hasElement(_n.getDer(), _i);
			}
		}

		//Si _n es nulo retorno false
		return false;
	}

	//Metodo auxiliar para comenzar la busqueda en pre-orden
	public List<String> preOrder() {
		return preOrder(this.raiz);
	}

	//Retorna una lista con el recorrido de los elementos en pre-orden
	private List<String> preOrder(Nodo _n) {
		List <String> retorno = new ArrayList<String>();

		//Checkeo que el arbol no este vacio
		if(_n.getInfo() != null) {
			//Agrego la raiz a la lista de retorno
			retorno.add(_n.getInfo());
			//Si tengo nodo izquierdo agrego su info a la lista
			if(_n.getIzq() != null) {
				retorno.addAll(preOrder(_n.getIzq()));
			}
			//Si tengo nodo derecho agrego su info a la lista
			if(_n.getDer() != null) {
				retorno.addAll(preOrder(_n.getDer()));
			}
			//Retorno la lista de elementos en pre-orden
			return retorno;
		}
		return null;
	}

	public List<String> posOrder(){
		return posOrder(this.raiz);
	}

	private List<String> posOrder(Nodo _n){
		List<String> retorno = new ArrayList<String>();

		if(_n.getInfo() != null) {
			if(_n.getIzq() != null) {
				retorno.addAll(posOrder(_n.getIzq()));
			}
			if(_n.getDer() != null) {
				retorno.addAll(posOrder(_n.getDer()));
			}
			retorno.add(_n.getInfo());

			return retorno;
		}

		return null;
	}

	public List<String> inOrder(){
		return inOrder(this.raiz);
	}

	private List<String> inOrder(Nodo _n){
		List<String> retorno = new ArrayList<String>();

		if(_n.getInfo() != null) {
			if(_n.getIzq() != null) {
				retorno.addAll(inOrder(_n.getIzq()));
			}

			retorno.add(_n.getInfo());

			if(_n.getDer() != null) {
				retorno.addAll(inOrder(_n.getDer()));
			}

			return retorno;
		}

		return null;
	}
	
	public LinkedList<Libro> getLibrosGenero(String _g){
		return getLibrosGenero(this.raiz, _g);
	}
	
	private LinkedList<Libro> getLibrosGenero(Nodo _n, String _g){
		if(_n != null) {
			if(_n.getInfo().equals(_g)) {
				return _n.getLibros();
			}
			if(_g.compareTo(_n.getInfo()) < 0) {
				return getLibrosGenero(_n.getIzq(), _g);
			}
			else {
				return getLibrosGenero(_n.getDer(), _g);
			}
		}
		return new LinkedList<Libro>();
	}
}