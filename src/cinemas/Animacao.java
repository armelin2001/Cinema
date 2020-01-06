package cinemas;

public class Animacao extends Filme {

	private String animadores;

	public Animacao(String classificacao, String nomeFilme, String diretor, String duracao, String animador) {
		super(classificacao, nomeFilme, diretor, duracao);
		this.animadores = animadores;
	}

	public String getAnimadores() {
		return animadores;
	}

	public void setAnimadores(String animadores) {
		this.animadores = animadores;
	}

	public String toString() {
		return super.toString()+ "Animador" + this.getAnimadores();
	}



}
