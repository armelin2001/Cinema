package cinemas;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cinemas.Filme;

public class Cinema {
	public String[] leValores(String[] dadosIn) {
		String [] dadosOut = new String [dadosIn.length];
		for(int i = 0; i < dadosIn.length; i++) {
			dadosOut[i] = JOptionPane.showInputDialog("Entre com "+ dadosIn[i]+": ");
		}
			
		
		return dadosOut;
		
	}
	
	public Comedia leComedia() {
		String [] valores = new String [5];//indica a quantidade de parametros contido na classe comedia..
		String [] nomeValor = {"Classificação", "Nome do filme", "Diretor","Duração", "Genero de Comedia" };
		valores = leValores(nomeValor);
		
		Comedia filmeComedia = new Comedia(valores[0], valores[1], valores[2], valores[3], valores[4]);
		return filmeComedia;
	}
	public Animacao leAnimacao() {
		String [] valores = new String [5];//indica a quantidade de parametros contido na classe comedia..
		String [] nomeValor = {"Classificação", "Nome do filme", "Diretor","Duração", "Animadores" };
		valores = leValores(nomeValor);
		
		Animacao filmeAnimacao = new Animacao(valores[0], valores[1], valores[2], valores[3], valores[4]);
		return filmeAnimacao;
	}
	public Acao leAcao() {
		String [] valores = new String [4];//indica a quantidade de parametros contido na classe comedia..
		String [] nomeValor = {"Classificação", "Nome do filme", "Diretor","Duração"};
		valores = leValores(nomeValor);
		
		Acao filmeAcao = new Acao(valores[0], valores[1], valores[2], valores[3]);
		return filmeAcao;
	}
	public Drama leDrama() {
		String [] valores = new String [5];//indica a quantidade de parametros contido na classe comedia..
		String [] nomeValor = {"Classificação", "Nome do filme", "Diretor","Duração", "Genero de Drama" };
		valores = leValores(nomeValor);
		
		Drama filmeDrama = new Drama(valores[0], valores[1], valores[2], valores[3], valores[4]);
		return filmeDrama;
	}
	public FiccaoCientifica leFiccaoCientifica() {
		String [] valores = new String [5];//indica a quantidade de parametros contido na classe comedia..
		String [] nomeValor = {"Classificação", "Nome do filme", "Diretor","Duração"};
		valores = leValores(nomeValor);
		
		FiccaoCientifica FilmeFiccaoCientifica = new FiccaoCientifica(valores[0], valores[1], valores[2], valores[3]);
		return FilmeFiccaoCientifica;
	}
	
	@SuppressWarnings("finally")
	public ArrayList<Filme> recuperaFilmes (){
		ArrayList<Filme> Filmes = new ArrayList<Filme>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("Cinema.dad"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Filme) {
					Filmes.add((Filme) obj);//adicionando objetos de filme que estao em array filme
				}   
			}          
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("End of file reached.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com produtos NÃO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return Filmes;
		}
	}
	public void salvaFilmes (ArrayList<Filme> filmes){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("Cinema.dad"));
			for (int i=0; i < filmes.size(); i++)
				outputStream.writeObject(filmes.get(i));//escrevendo os objetos de filme
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");//tratando erro de criacao de arquivos
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void menuFilmes(){

		ArrayList<Filme> Filmes = new ArrayList<Filme>();


		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle Supermercado\n" +
					"Opções:\n" + 
					"1. Entrar Filmes\n" +
					"2. Exibir Filmes\n" +
					"3. Limpar Filmes\n" +
					"4. Gravar Filmes\n" +
					"5. Recuperar Filmes\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			
			while (!numeroInteiroValido(entrada)) {
	            entrada = JOptionPane.showInputDialog(null, menu + 
	                    "\n\nEntrada inválida! Digite um número inteiro.");
	        }
			opc1 = new Integer(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrada de filme\n" +
						"Opções:\n" + 
						"1. Ação\n" +
						"2. Animação\n" +
						"3. Comedia\n" +
						"4. Drama\n" + 
						"5. Ficção cientifica";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				while (!numeroInteiroValido(entrada)) {
		            entrada = JOptionPane.showInputDialog(null, menu + 
		                    "\n\nEntrada inválida! Digite um número inteiro.");
		        }
				opc2 = new Integer(entrada);
				//chamando os metodos de leitura de generos de filmes
				switch (opc2){
				case 1: Filmes.add((Filme)leAcao());
				break;
				case 2: Filmes.add((Filme)leAnimacao());
				break;
				case 3: Filmes.add((Filme)leComedia());
				break;
				case 4: Filmes.add((Filme)leDrama());
				break;
				case 5: Filmes.add((Filme)leFiccaoCientifica());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Filme não foi escolhido!");
				}

				break;
			case 2: // Exibir dados
				if (Filmes.size() == 0) {
					JOptionPane.showMessageDialog(null,"Registre algum filme primeiro");
					break;
				}
				String dados = "";
				for (int i=0; i < Filmes.size(); i++)	{
					dados += Filmes.get(i).toString() + "\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpa dados
				if (Filmes.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com filmes primeiramente");
					break;
				}
				Filmes.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 4: // Grava os filmes
				if (Filmes.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com filmes primeiramente");
					break;
				}
				salvaFilmes(Filmes);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break;
			case 5: // Ve os filmes
				Filmes = recuperaFilmes();
				if (Filmes.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo Cinema");
				break;
			}
		} while (opc1 != 9);
	}

	private boolean numeroInteiroValido(String s) {
		 boolean resultado;
	        try {
	            Integer.parseInt(s);
	            resultado = true;
	        } catch (NumberFormatException e) {
	            resultado = false;
	        }
	        return resultado;
	    
	}

	public static void main(String[] args) {
		Cinema cn = new Cinema();
		cn.menuFilmes();
	}
}
