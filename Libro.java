import java.util.ArrayList;


public class Libro {
	private String titulo;
	private String autor;
	private String paginas;
	private ArrayList<String>generos;
	
	private int cantGen;
	public Libro(){
		titulo=null;
		autor=null;
		paginas=null;
		generos=new ArrayList() ;
		cantGen=0;

	}
	public Libro (String t,String a,String p){
		titulo=t;
		autor=a;
		paginas=p;
		generos=new ArrayList() ;
		cantGen=0;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getPaginas() {
		return paginas;
	}
	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}
	public ArrayList<String> getGeneros() {
		return generos;
	}
	public void setGeneros(ArrayList<String> generos) {
		this.generos = generos;
	}
	public void addGenero(String a){
		generos.add(a);
		cantGen++;
	}
	public boolean containsGenero(String a){
		for(int i=0;i<cantGen;i++){
			if(generos.get(i).equals(a)){
				return true;
			}
		}
		return false;
	}
	public void print(){
		System.out.println("Titulo "+ this.titulo);
	}

}
