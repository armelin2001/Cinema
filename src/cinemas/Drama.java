package cinemas;

public class Drama extends Filme {
	/*tipos de DRAMA:
	 * Melodrama
	 * Dramaturgia
	 * Comedia dramatica*/
	private String tipoDrama;
	public Drama(String classificacao, String nomeFilme, String diretor, String duracao, String tipoDrama) {
		super(classificacao, diretor, nomeFilme, duracao);
		this.tipoDrama = tipoDrama;
	}
	public String getTipoDrama() {
		return tipoDrama;
	}
	public void setTipoDrama(String tipoDrama){
		this.tipoDrama = tipoDrama;
	}
	public String toString() {
		return super.toString() +
				"Tipo de drama: " + this.getTipoDrama();
	}



}
