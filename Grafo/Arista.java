package Grafo;

 class Arista {
	Vertice vertice1;
	Vertice vertice2;
	Integer peso;
	
	public Arista(Vertice _v1, Vertice _v2) {
		this.vertice1 = _v1;
		this.vertice2 = _v2;
		this.peso = 1;
	}
	
	public Arista(Vertice _v1, Vertice _v2, Integer _p) {
		this.vertice1 = _v1;
		this.vertice2 = _v2;
		this.peso = _p;
	}
	
	public Vertice getVertice1() {
		return this.vertice1;
	}
	
	public Vertice getVertice2() {
		return this.vertice2;
	}
	
	public Integer getPeso() {
		return this.peso;
	}
	
	public void setPeso(Integer _p) {
		this.peso = _p;
	}
	
	public int hashCode() {
		return (this.vertice1.getEtiqueta() + this.vertice2.getEtiqueta()).hashCode();
	}
	
	public boolean equals (Arista _a) {
		if(_a.getVertice1().equals(this.getVertice1()) && _a.getVertice2().equals(this.getVertice2())) {
			return true;
		}
		return false;
	}
}
