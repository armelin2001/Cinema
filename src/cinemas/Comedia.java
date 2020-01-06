package cinemas;

public class Comedia extends Filme {
	private String tipoComedia;
	public Comedia(String classificacao, String nomeFilme, String diretor, String duracao, String tipoC) {
		super(classificacao, nomeFilme, diretor, duracao);
		this.tipoComedia = tipoC;
	}
	
	public String getTipoComedia() {
		return tipoComedia;
	}
	public void setTipoComedia(String tipoComedia) {
		this.tipoComedia = tipoComedia;
	}
	public String toString() {
		return super.toString() + 
				"Tipo de Comedia" + this.getTipoComedia();
	}

}
