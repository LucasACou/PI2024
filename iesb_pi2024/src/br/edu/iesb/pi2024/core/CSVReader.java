package br.edu.iesb.pi2024.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	private String arquivoCSV;

	public CSVReader(String arquivoCSV) {
		this.arquivoCSV = arquivoCSV;
	}
	
	// busca regiao especifica e retorna essa regiao
	public RegiaoAdministrativa buscarRegiao(List<RegiaoAdministrativa> regioes, String nome) {
	    for (RegiaoAdministrativa regiao : regioes) {
	        if (regiao.getNome().equalsIgnoreCase(nome)) {
	            return regiao;
	        }
	    }
	    return null; // retorna null se a região não for encontrada
	}
	
	private boolean isNumeroDecimal(String campo) {
		// verifica se o campo contém uma vírgula
		return campo.contains(",");
	}

	public List<RegiaoAdministrativa> lerRegioes() {
		List<RegiaoAdministrativa> regioes = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))) {
			// Ignorar a primeira linha do dataset
			reader.readLine();

			String linha;
			while ((linha = reader.readLine()) != null) {

				// tirando as aspas e pontos
				linha = linha.replaceAll("\"", "").replaceAll("\\.", "");

				// dividindo cada campo das linhas por ponto e virgula
				String[] campos = linha.split(";");
				
				
				for (int i = 0; i < campos.length; i++) {
					if (isNumeroDecimal(campos[i])) {
						//substitui virgula por .
                    	campos[i] = campos[i].replace(",", ".");
					}
				}

				// Verificar se a linha possui todos os campos necessários
				if (campos.length >= 9) {
					String nome = campos[0];
					int densidadePopulacional = Integer.parseInt(campos[1]);
					int populacaoAtual = Integer.parseInt(campos[2]);
					double taxaCrescimento2020_2025 = Double.parseDouble(campos[3]);
					double taxaCrescimento2025_2030 = Double.parseDouble(campos[4]);
					int estimativaPopulacao2030 = Integer.parseInt(campos[5]);
					double relevanciaComercial = Double.parseDouble(campos[6]);
					double integracaoOutrosTransportes = Double.parseDouble(campos[7]);
					double trafegoRodoviario = Double.parseDouble(campos[8]);

					// Criar objeto RegiaoAdministrativa e adicionar à lista
					RegiaoAdministrativa regiao = new RegiaoAdministrativa(
							nome, densidadePopulacional, populacaoAtual,
							taxaCrescimento2020_2025, taxaCrescimento2025_2030,
							estimativaPopulacao2030, relevanciaComercial,
							integracaoOutrosTransportes, trafegoRodoviario);

					regioes.add(regiao);
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}

		return regioes;
	}
}