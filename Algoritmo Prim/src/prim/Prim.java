package prim;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Prim {
	
	private int cantidadNodos;
	private int cantidadAristasTotal;
	private int cantidadAristasUsadas;
	private int costo;
	private ArrayList<Integer> visitados = new ArrayList<Integer>();
	private ArrayList<Integer> noVisitados = new ArrayList<Integer>();
	private ArrayList<Arista> aristas = new ArrayList<Arista>();
	private ArrayList<Arista> grafo = new ArrayList<Arista>();
	private Arista[] aristasTotal;
	
	public Prim(Scanner entrada) {
		int nodo1, nodo2, costo;
		this.costo = 0;
		this.cantidadAristasUsadas = 0;
		this.cantidadNodos = entrada.nextInt();
		this.cantidadAristasTotal = entrada.nextInt();
		this.aristasTotal = new Arista[this.cantidadAristasTotal];
		for(int i = 0; i < this.cantidadAristasTotal; i++) {
			nodo1 = entrada.nextInt() - 1;
			nodo2 = entrada.nextInt() - 1;
			costo = entrada.nextInt();
			this.aristasTotal[i] = new Arista(nodo1,nodo2,costo);
		}
		Arrays.sort(aristasTotal);
		for(int i = 0; i < this.cantidadAristasTotal; i++) {
			aristas.add(this.aristasTotal[i]);
		}
		aristasTotal = null;
	}
	
	private void inicializarListas(int nodo) {
		for(int i=0; i<this.cantidadNodos; i++) {
			if(i != (nodo-1))
				this.noVisitados.add(i);
			else
				this.visitados.add(i);
		}
	}
	
	private Arista seAgrega() {
		Arista arista = null;
		boolean encontrado = false;
		int i=0;
		while(i < this.cantidadAristasTotal && encontrado == false) {
			arista = this.aristas.get(i);
			if((this.visitados.contains(arista.getNodo1()) == false &&
					this.visitados.contains(arista.getNodo2()) == true) || 
					(this.visitados.contains(arista.getNodo1()) == true &&
					this.visitados.contains(arista.getNodo2()) == false)) {
				encontrado = true;
				if(this.visitados.contains(arista.getNodo1()) == false)
					this.visitados.add(this.noVisitados.remove(arista.getNodo1()));
				else 
					this.visitados.add(this.noVisitados.remove(arista.getNodo2()));
				this.aristas.remove(i);
			}
			i++;
		}
		return arista;
	}
	
	public void calcularCosto(int nodo) {
		Arista aux;
		this.inicializarListas(nodo);
		while(this.cantidadAristasUsadas != this.cantidadNodos-1) {
			aux = seAgrega();
			this.grafo.add(aux);
			this.cantidadAristasUsadas++;
		}
	}
	
	public void mostrarCosto() {
		System.out.println("El arbol abarcador de costo minimo tiene un costo de: " + this.costo);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner entrada = new Scanner(new FileReader("prim.in"));
		Prim prim = new Prim(entrada);
		entrada.close();
		prim.calcularCosto(3);
		prim.mostrarCosto();
	}

}
