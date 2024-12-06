package br.edu.iesb.pi2024.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Grafo {
	
	int vertices;
	LinkedList<Aresta>[] listaAdjacencia;
	Map<String, Integer> mapaVertices;
	int indiceAtual = 0;
	
	
	public Grafo(int vertices) {
		
		this.vertices = vertices;
		this.listaAdjacencia = new LinkedList[vertices];
		this.mapaVertices = new LinkedHashMap<String, Integer>();
		
		for (int i = 0; i < vertices; i++) {
			listaAdjacencia[i] = new LinkedList<>();
		}
	}
	
	private int addOuGetIndice(String nomeVertice) {
		
		 // verifica se o vértice já existe no mapa
		if (mapaVertices.containsKey(nomeVertice)) {
			// se já existe, retorna o índice associado ao nome do vértice
			return mapaVertices.get(nomeVertice);
			
		} else {
			// se não existe, verifica se há espaço disponível no grafo
			if (indiceAtual >= vertices) {
				// Caso contrário, lança uma exceção indicando que o grafo atingiu sua capacidade
				throw new IllegalStateException("Capacidade máxima do grafo excedida! Não é possível adicionar mais vértices.");
			}
			// adiciona o novo vértice ao mapa associando o próximo índice disponível
			mapaVertices.put(nomeVertice, indiceAtual);
			// retorna o índice recém-adicionado e o incrementa para o próximo vértice
			return indiceAtual++;
	    }
	    
	}
	
	public double mediaPeso(RegiaoAdministrativa origem, RegiaoAdministrativa destino, double distanciaFisica) {
		
		int PopulacaoMedia = (int) ((origem.getPopulacaoAtual() + destino.getPopulacaoAtual()) / 2);
		int DensidadeMedia = (int) ((origem.getDensidadePopulacional() + destino.getDensidadePopulacional()) / 2);
		int RelevMedia = (int) ((origem.getRelevanciaComercial() + destino.getRelevanciaComercial()) / 2);
		int TrafegoMedia = (int) ((origem.getTrafegoRodoviario() + destino.getTrafegoRodoviario()) / 2);
		int IntegracaoMedia = (int) ((origem.getIntegracaoOutrosTransportes() + destino.getIntegracaoOutrosTransportes()) / 2);
		
		int media = (int) ((distanciaFisica) * (1 + ( PopulacaoMedia + DensidadeMedia + 
					RelevMedia + TrafegoMedia + IntegracaoMedia) / 1000));
		
		return media;
	}
	
	public void adicionarAresta(String origem, String destino, double peso) {
		
		int indiceOrigem = addOuGetIndice(origem);
		int indiceDestino = addOuGetIndice(destino);
		
		Aresta aresta = new Aresta(origem,destino,peso);
		
		listaAdjacencia[indiceOrigem].add(aresta);
		listaAdjacencia[indiceDestino].add(new Aresta(destino,origem,peso));
	}
	
	public void executarAlgoritmoPRIM() {
		// marca os vértices que já estão na MST
		boolean[] inMST = new boolean[vertices];

	    // fila de prioridade para as arestas, ordenadas pelo peso
	    PriorityQueue<Aresta> priorityQueue = 
	    		new PriorityQueue<>(Comparator.comparingDouble(Aresta::getPeso));

	    // lista para armazenar as arestas da MST
	    List<Aresta> mst = new ArrayList<>();

	    // percorre o grafo para garantir que todas as componentes sejam processadas
	    for (int verticeInicial = 0; verticeInicial < vertices; verticeInicial++) {
	    	// se o vértice já está na MST, pule
	    	if (inMST[verticeInicial]) continue;

	        // adiciona todas as arestas do vértice inicial à fila de prioridade
	        inMST[verticeInicial] = true;
	        for (Aresta aresta : listaAdjacencia[verticeInicial]) {
	        	priorityQueue.add(aresta);
	        }

	        // processa a fila de prioridade
	        while (!priorityQueue.isEmpty()) {
	        	// retira a aresta de menor peso
	        	Aresta arestaAtual = priorityQueue.poll();

	            // obtém o índice do destino da aresta
	            int destinoIndice = addOuGetIndice(arestaAtual.getDestino());

	            // verifica se o vértice de destino já está na MST
	            if (!inMST[destinoIndice]) {
	            	// Adiciona a aresta à MST
	            	mst.add(arestaAtual);

	                // marca o vértice como incluído na MST
	                inMST[destinoIndice] = true;

	                // adiciona todas as arestas adjacentes ao vértice de destino à fila
	                for (Aresta aresta : listaAdjacencia[destinoIndice]) {
	                	int proximoDestino = addOuGetIndice(aresta.getDestino());
	                    if (!inMST[proximoDestino]) {
	                    	priorityQueue.add(aresta);
	                    }
	                }
	            }
	        }
	    }
	    
	    int count = 0;
	    
	    // exibe as arestas da Árvore Geradora Mínima (MST)
	    System.out.println("\n>> Árvore Geradora Mínima (MST):\n");
	    for (Aresta aresta : mst) {
	    	System.out.println("[" + aresta.getOrigem() + "] -> "
	    			+ "[" + aresta.getDestino() + ", "
	    			+ aresta.getPeso() + "]");
	    	count++;
	    }
	    
	    System.out.println("\nNumero de Arestas na MST: " + count);
	    
	    // exibe as as conexoes que o vertice tem
	    System.out.println("\n>> Conexões p/ Vertices:\n");
	    for (String vertice : mapaVertices.keySet()) {
	    	System.out.print(vertice + " ->");
	    	for (Aresta aresta : mst) {
	    		if(aresta.getOrigem().equals(vertice)) {
	    			System.out.print(" [" + aresta.getDestino() + ", "
			    			+ aresta.getPeso() + "]");
	    		}
	    		if (aresta.getDestino().equals(vertice)) {
	                System.out.print(" [" + aresta.getOrigem() + ", " 
	                		+ aresta.getPeso() + "]");
	            }
		    }
	    	System.out.println();
	    }  
	}
}
