package cinemas;

import java.io.Serializable;

public class Filme implements Serializable {

	private String classificacao;

	private String nomeFilme;

	private String diretor;

	private String duracao;

	private float valorIngresso;

	public Filme(String classificacao, String nomeFilme, String diretor, String duracao) {
		this.classificacao = classificacao;
		this.nomeFilme = nomeFilme;
		this.diretor = diretor;
		this.duracao = duracao;
	}
	

	public void setClassificacao(String classificacao) {
		this.classificacao  = classificacao;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getDuracao() {
		return duracao;
	}

	
	public String toString() {
		String retorno;
		retorno = "------------------------------------"+
			      "Classificação indicativa: " + this.getClassificacao() +
			      "------------------------------------\n" +
			      "Nome do filme: " + this.getNomeFilme() + "\n"+
			      "Diretor: " + this.getDiretor() + "\n" +
			      "Duração: " + this.getDuracao() + "\n";
		return retorno;
	}
	
};











