package br.edu.iesb.pi2024.core;

public class Aresta {

	private String origem;
	private String destino;
	private double peso;
	
	public Aresta(String origem, String destino, double peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}
