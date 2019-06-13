package prim;

public class Arista implements Comparable<Arista> {
	
	private int nodo1;
	private int nodo2;
	private int costo;
	
	public Arista(int nodo1, int nodo2, int costo) {
		this.nodo1 = nodo1;
		this.nodo2 = nodo2;
		this.costo = costo;
	}

	@Override
	public int compareTo(Arista arista) {
		return this.costo - arista.costo;
	}
	
	
	
}
