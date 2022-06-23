package br.com.fiap.cp2.jogoforca.model;

public class Tentativa {
	
	//Declaração das variáveis
	private String tentativa;
	private String palavra;
	private String palavraSecreta;
	private int vida;
	private String palpite = "";

	
	//Getters e Setters
	public String getPalpite() {
		return palpite;
	}

	public String getTentativa() {
		return tentativa;
	}

	public void setTentativa(String tentativa) {
		this.tentativa = tentativa;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public String getPalavraSecreta() {
		return palavraSecreta;
	}

	public void setPalavraSecreta(String palavraSecreta) {
		this.palavraSecreta = palavraSecreta;
	}
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	
	
	// Método para transformar a palavra em *
	public String censurarPalavra() {
		String palavraSecreta = "";
		for (int i = 0; i < this.palavra.length(); i++) {
			palavraSecreta += "*";
		}
		return palavraSecreta;
		}
	
	
	
	// Método para verificar se o chute foi certo ou não
	public void verificaTentativa(String tentativa) {
		String novaPalavraSecreta = "";
		for (int i = 0; i < palavra.length(); i++) {
			if (palavra.charAt(i) == tentativa.charAt(0)) {
				novaPalavraSecreta += tentativa.charAt(0);
			} else if (palavraSecreta.charAt(i) != '*') {
				novaPalavraSecreta += palavra.charAt(i);
			} else {
				novaPalavraSecreta += "*";
			}
		}
		

		// Condicionais para diminuir a vida ou mostrar a palava atualizada
		if (palavraSecreta.equals(novaPalavraSecreta)) {
			palpite = this.palpite + tentativa;		
			this.vida--;
		} else {
			palavraSecreta = novaPalavraSecreta;
		}
		
		
		
		// Condicionais para vencer ou perder o jogo
		if (palavraSecreta.equals(palavra)) {
			System.out.println("Ganhou! Você acertou a palavra! A palavra era: " + palavra);
			System.exit(vida);
		}
		
		else if (this.vida == 0) {
			System.out.println("Perdeu! Suas vidas chegaram a 0! A palavra era: " + palavra);
			System.exit(vida);
		} 
		
	}

}
