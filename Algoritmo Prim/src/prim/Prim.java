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
	private int[][] matrizAdyacencia;
	private int costo;
	private ArrayList<Integer> visitados = new ArrayList<Integer>();
	private ArrayList<Integer> noVisitados = new ArrayList<Integer>();
	private ArrayList<Arista> aristas = new ArrayList<Arista>();
	
	public Prim(Scanner entrada) {
		int nodo1, nodo2, costo;
		this.costo = 0;
		this.cantidadAristasUsadas = 0;
		this.cantidadNodos = entrada.nextInt();
		this.cantidadAristasTotal = entrada.nextInt();
		this.matrizAdyacencia = new int[this.cantidadNodos][this.cantidadNodos];
		for(int i = 0; i < this.cantidadAristasTotal; i++) {
			nodo1 = entrada.nextInt() - 1;
			nodo2 = entrada.nextInt() - 1;
			costo = entrada.nextInt() - 1;
			this.aristas.add(new Arista(nodo1, nodo2, costo));
		}
	}
	
	private void inicializarListas(int nodo) {
		for(int i=0; i<this.cantidadNodos; i++) {
			if(i != (nodo-1))
				this.noVisitados.add(i);
			else
				this.visitados.add(i);
		}
	}
	
	
	public void calcularCosto(int nodo) {
		this.inicializarListas(nodo);
		while(this.cantidadAristasUsadas != this.cantidadNodos-1) {
			
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
