package br.edu.iesb.pi2024.core;

public class RegiaoAdministrativa {
	private String nome;
	private int densidadePopulacional;
	private int populacaoAtual;
	private double taxaCrescimento2020_2025;
	private double taxaCrescimento2025_2030;
	private int estimativaPopulacao2030;
	private double relevanciaComercial;
	private double integracaoOutrosTransportes;
    private double trafegoRodoviario;

    public RegiaoAdministrativa(String nome, int densidadePopulacional, int populacaoAtual,
    							double taxaCrescimento2020_2025, double taxaCrescimento2025_2030,
    							int estimativaPopulacao2030, double relevanciaComercial,
    							double integracaoOutrosTransportes, double trafegoRodoviario) {
    	this.nome = nome;
    	this.densidadePopulacional = densidadePopulacional;
    	this.populacaoAtual = populacaoAtual;
    	this.taxaCrescimento2020_2025 = taxaCrescimento2020_2025;
    	this.taxaCrescimento2025_2030 = taxaCrescimento2025_2030;
    	this.estimativaPopulacao2030 = estimativaPopulacao2030;
    	this.relevanciaComercial = relevanciaComercial;
    	this.integracaoOutrosTransportes = integracaoOutrosTransportes;
    	this.trafegoRodoviario = trafegoRodoviario;
	}

	@Override
	public String toString() {
		return String.format("Região: %s, Densidade: %d, População Atual: %d, Taxa Cresc. 2020-2025: %.2f%%, " +
							"Taxa Cresc. 2025-2030: %.2f%%, Estimativa 2030: %d, Relevância Comercial: %.2f, " +
							"Integração: %.2f, Tráfego: %.2f", 
							nome, densidadePopulacional, populacaoAtual, taxaCrescimento2020_2025, 
							taxaCrescimento2025_2030, estimativaPopulacao2030, relevanciaComercial, 
							integracaoOutrosTransportes, trafegoRodoviario);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDensidadePopulacional() {
		return densidadePopulacional;
	}

	public void setDensidadePopulacional(int densidadePopulacional) {
		this.densidadePopulacional = densidadePopulacional;
	}

	public int getPopulacaoAtual() {
		return populacaoAtual;
	}

	public void setPopulacaoAtual(int populacaoAtual) {
		this.populacaoAtual = populacaoAtual;
	}

	public double getTaxaCrescimento2020_2025() {
		return taxaCrescimento2020_2025;
	}

	public void setTaxaCrescimento2020_2025(double taxaCrescimento2020_2025) {
		this.taxaCrescimento2020_2025 = taxaCrescimento2020_2025;
	}

	public double getTaxaCrescimento2025_2030() {
		return taxaCrescimento2025_2030;
	}

	public void setTaxaCrescimento2025_2030(double taxaCrescimento2025_2030) {
		this.taxaCrescimento2025_2030 = taxaCrescimento2025_2030;
	}

	public int getEstimativaPopulacao2030() {
		return estimativaPopulacao2030;
	}

	public void setEstimativaPopulacao2030(int estimativaPopulacao2030) {
		this.estimativaPopulacao2030 = estimativaPopulacao2030;
	}

	public double getRelevanciaComercial() {
		return relevanciaComercial;
	}

	public void setRelevanciaComercial(double relevanciaComercial) {
		this.relevanciaComercial = relevanciaComercial;
	}

	public double getIntegracaoOutrosTransportes() {
		return integracaoOutrosTransportes;
	}

	public void setIntegracaoOutrosTransportes(double integracaoOutrosTransportes) {
		this.integracaoOutrosTransportes = integracaoOutrosTransportes;
	}

	public double getTrafegoRodoviario() {
		return trafegoRodoviario;
	}

	public void setTrafegoRodoviario(double trafegoRodoviario) {
		this.trafegoRodoviario = trafegoRodoviario;
	}
}