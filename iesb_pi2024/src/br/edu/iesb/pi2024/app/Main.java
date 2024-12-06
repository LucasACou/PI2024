package br.edu.iesb.pi2024.app;

import java.util.List;

import br.edu.iesb.pi2024.core.CSVReader;
import br.edu.iesb.pi2024.core.Grafo;
import br.edu.iesb.pi2024.core.RegiaoAdministrativa;

public class Main {

	public static void main(String[] args) {
		
		CSVReader reader = new CSVReader("PIDataset.csv");
		System.out.println("Iniciando leitura do dataset...");
		
		List<RegiaoAdministrativa> regioes = reader.lerRegioes();
		System.out.println("Total de regiões lidas: " + regioes.size());
		
		Grafo grafo = new Grafo(100);
		
		RegiaoAdministrativa ceilandia = reader.buscarRegiao(regioes,"Ceilândia");
		RegiaoAdministrativa samambaia = reader.buscarRegiao(regioes,"Samambaia");
		RegiaoAdministrativa plano_piloto = reader.buscarRegiao(regioes,"Plano Piloto");
		RegiaoAdministrativa taguatinga = reader.buscarRegiao(regioes,"Taguatinga");
		RegiaoAdministrativa guara = reader.buscarRegiao(regioes,"Guará");
		RegiaoAdministrativa aguas_claras = reader.buscarRegiao(regioes,"Águas Claras");
		RegiaoAdministrativa sobradinho2 = reader.buscarRegiao(regioes,"Sobradinho II");
		RegiaoAdministrativa vicente_pires = reader.buscarRegiao(regioes,"Vicente Pires");
		RegiaoAdministrativa sobradinho = reader.buscarRegiao(regioes,"Sobradinho");
		RegiaoAdministrativa riacho_fundo2 = reader.buscarRegiao(regioes,"Riacho Fundo II");
		RegiaoAdministrativa sudoeste = reader.buscarRegiao(regioes,"Sudoeste/Octogonal");
		RegiaoAdministrativa arniqueiras = reader.buscarRegiao(regioes,"Arniqueira");
		RegiaoAdministrativa riacho_fundo = reader.buscarRegiao(regioes,"Riacho Fundo");
		RegiaoAdministrativa cruzeiro = reader.buscarRegiao(regioes,"Cruzeiro");
		RegiaoAdministrativa n_bandeirante = reader.buscarRegiao(regioes,"Núcleo Bandeirante");
		RegiaoAdministrativa park_way = reader.buscarRegiao(regioes,"Park Way");
		
		//	System.out.println(ceilandia);
		//	System.out.println(park_way);
		
		//ceilandia
		grafo.adicionarAresta("T.Ceilandia","Cei.Norte", (double) grafo.mediaPeso(ceilandia, ceilandia, 1.2));
		grafo.adicionarAresta("Cei.Norte", "Cei.Centro", (double) grafo.mediaPeso(ceilandia, ceilandia, 1.0));
		grafo.adicionarAresta("Cei.Centro", "Guariroba", (double) grafo.mediaPeso(ceilandia, ceilandia, 1.0));
		grafo.adicionarAresta("Guariroba", "Cei.Sul", (double) grafo.mediaPeso(ceilandia, ceilandia, 1.0));
		grafo.adicionarAresta("Cei.Sul", "Centro Metro.", (double) grafo.mediaPeso(ceilandia, ceilandia, 2.5));
		grafo.adicionarAresta("Centro Metro.", "Onoyama", (double) grafo.mediaPeso(ceilandia, taguatinga, 1.0));
		//taguatinga
		grafo.adicionarAresta("Onoyama", "Pç.Relógio", (double) grafo.mediaPeso(taguatinga, taguatinga, 2.3));
		grafo.adicionarAresta("Pç.Relógio", "Estrada Pq.", (double) grafo.mediaPeso(taguatinga, taguatinga, 1.8));
		grafo.adicionarAresta("Estrada Pq.", "Concessionárias", (double) grafo.mediaPeso(taguatinga, aguas_claras, 1.0));
		//aguas claras
		grafo.adicionarAresta("Concessionárias", "Águas Claras", (double) grafo.mediaPeso(aguas_claras, aguas_claras, 1.4));
		grafo.adicionarAresta("Águas Claras", "Arniqueiras", (double) grafo.mediaPeso(aguas_claras, aguas_claras, 1.4));
		grafo.adicionarAresta("Águas Claras", "Tg.Sul", (double) grafo.mediaPeso(aguas_claras, taguatinga, 3.0));
		grafo.adicionarAresta("Arniqueiras", "Guará", (double) grafo.mediaPeso(aguas_claras, guara, 4.0));
		//samambaia
		grafo.adicionarAresta("Tg.Sul", "Furnas", (double) grafo.mediaPeso(taguatinga, samambaia, 1.5));
		grafo.adicionarAresta("Furnas", "Sam.Sul", (double) grafo.mediaPeso(samambaia, samambaia, 1.5));
		grafo.adicionarAresta("Sam.Sul", "T.Samambaia", (double) grafo.mediaPeso(samambaia, samambaia, 2.5));
		//guara
		grafo.adicionarAresta("Guará", "Feira", (double) grafo.mediaPeso(guara, guara, 1.0));
		grafo.adicionarAresta("Feira", "Shopping", (double) grafo.mediaPeso(guara, guara, 3.0));
		grafo.adicionarAresta("Shopping", "T.Asa Sul", (double) grafo.mediaPeso(guara, plano_piloto, 2.1));
		//plano piloto
		grafo.adicionarAresta("T.Asa Sul", "114", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 1.5));
		grafo.adicionarAresta("114", "112", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.75));
		grafo.adicionarAresta("112", "110", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.7));
		grafo.adicionarAresta("110", "108", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.65));
		grafo.adicionarAresta("108", "106", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.75));
		grafo.adicionarAresta("106", "104", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.75));
		grafo.adicionarAresta("104", "102", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.7));
		grafo.adicionarAresta("102", "Galerias", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.85));
		grafo.adicionarAresta("Galerias", "Central", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.63));

		//aumento do metro
		//ceilandia
		grafo.adicionarAresta("Cei.Sul", "T.Samambaia", (double) grafo.mediaPeso(ceilandia, samambaia, 4.50));
		//aguas claras
		grafo.adicionarAresta("Águas Claras", "Av.Sibipiruna", (double) grafo.mediaPeso(aguas_claras, aguas_claras, 1.0));
		grafo.adicionarAresta("Av.Sibipiruna", "Edu'Arte", (double) grafo.mediaPeso(aguas_claras, aguas_claras, 1.5));
		grafo.adicionarAresta("Edu'Arte", "Riacho Mall", (double) grafo.mediaPeso(aguas_claras, riacho_fundo, 2.2));
		grafo.adicionarAresta("Arniqueiras", "Rua 4", (double) grafo.mediaPeso(aguas_claras, vicente_pires, 1.5));
		//vicente pires
		grafo.adicionarAresta("Rua 4", "Rua 5", (double) grafo.mediaPeso(vicente_pires, vicente_pires, 0.95));
		grafo.adicionarAresta("Rua 5", "Rua 8", (double) grafo.mediaPeso(vicente_pires, vicente_pires, 0.85));
		grafo.adicionarAresta("Rua 8", "Rua 10", (double) grafo.mediaPeso(vicente_pires, vicente_pires, 0.65));
		grafo.adicionarAresta("Rua 10", "Terra. Shop.", (double) grafo.mediaPeso(vicente_pires, cruzeiro, 8.30));
		//cruzeiro
		grafo.adicionarAresta("Terra. Shop.", "Ginasio Cruzeiro", (double) grafo.mediaPeso(cruzeiro, cruzeiro, 1.20));
		grafo.adicionarAresta("Ginasio Cruzeiro", "Estudio", (double) grafo.mediaPeso(cruzeiro, cruzeiro, 1.40));
		grafo.adicionarAresta("Terra. Shop.", "CIEE", (double) grafo.mediaPeso(cruzeiro, sudoeste, 1.10));
		//sudoeste
		grafo.adicionarAresta("CIEE", "Pratique Mov", (double) grafo.mediaPeso(sudoeste, sudoeste, 1.90));
		grafo.adicionarAresta("Pratique Mov", "Pq. Sucupiras", (double) grafo.mediaPeso(sudoeste, sudoeste, 1.0));
		grafo.adicionarAresta("Pq. Sucupiras", "Memorial JK", (double) grafo.mediaPeso(sudoeste, plano_piloto, 1.10));
		//plano piloto
		grafo.adicionarAresta("Memorial JK", "Ulysses", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 1.35));
		grafo.adicionarAresta("Ulysses", "Central", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 2.25));
		grafo.adicionarAresta("Central", "Itamaraty", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 1.75));
		grafo.adicionarAresta("Central", "1", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.60));
		//asa norte
		grafo.adicionarAresta("1", "2", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.80));
		grafo.adicionarAresta("2", "3", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.70));
		grafo.adicionarAresta("3", "4", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.70));
		grafo.adicionarAresta("4", "5", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.70));
		grafo.adicionarAresta("5", "6", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.70));
		grafo.adicionarAresta("6", "7", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.75));
		grafo.adicionarAresta("7", "8", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 0.75));
		grafo.adicionarAresta("8", "Boulevard Shop.", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 1.25));
		grafo.adicionarAresta("Boulevard Shop.", "St. Taqueri", (double) grafo.mediaPeso(plano_piloto, plano_piloto, 5.20));
		grafo.adicionarAresta("St. Taqueri", "Conj. A2", (double) grafo.mediaPeso(plano_piloto, sobradinho, 9.35));
		//sobradinho
		grafo.adicionarAresta("Conj. A2", "Correios Sobradinho", (double) grafo.mediaPeso(sobradinho, sobradinho, 1.30));
		grafo.adicionarAresta("Correios Sobradinho", "SESI", (double) grafo.mediaPeso(sobradinho, sobradinho, 1.65));
		//riacho fundo
		grafo.adicionarAresta("Riacho Mall", "QN 7", (double) grafo.mediaPeso(riacho_fundo, riacho_fundo, 0.60));
		grafo.adicionarAresta("QN 7", "Capela", (double) grafo.mediaPeso(riacho_fundo, riacho_fundo, 1.40));
		grafo.adicionarAresta("Capela", "Atacado Costa", (double) grafo.mediaPeso(riacho_fundo, n_bandeirante, 1.10));
		//nucleo bandeirante
		grafo.adicionarAresta("Atacado Costa", "Contemporaneo", (double) grafo.mediaPeso(n_bandeirante, n_bandeirante, 2.90));
		grafo.adicionarAresta("Contemporaneo", "Museu", (double) grafo.mediaPeso(n_bandeirante, n_bandeirante, 1.60));
		//guara
		grafo.adicionarAresta("Shopping", "Museu", (double) grafo.mediaPeso(n_bandeirante, n_bandeirante, 3.40));
		grafo.adicionarAresta("Shopping", "Terra. Shop.", (double) grafo.mediaPeso(n_bandeirante, n_bandeirante, 3.75));
		grafo.adicionarAresta("Shopping", "Aeroporto", (double) grafo.mediaPeso(n_bandeirante, n_bandeirante, 6.70));
		
		
		grafo.executarAlgoritmoPRIM();
		
	}
}
