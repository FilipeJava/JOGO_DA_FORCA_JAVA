package br.com.fiap.cp2.jogoforca.view;

import java.util.Scanner;

import br.com.fiap.cp2.jogoforca.model.Tentativa;

public class Forca {

	public static void main(String[] args) {
		// Decla��es das vari�veis e instancia de Tentativa
		Tentativa play = new Tentativa();
		String segredo = "";
		String dica;
		
		// Mensagens sobre as regras do jogo
		System.out.println("Seja bem vindo ao Jogo da Forca do Grupo Tills.");
		System.out.println("As regras s�o simples. Voc� vai digitar uma palavra para a forca, depois a quantidade de vidas que deseja e "
				+ "por ultimo ir� passar uma dica.");
		System.out.println("Se voc� acertar a palavra antes das vidas zerarem voc� ganha!");
		System.out.println("-------------------------------------------");
		
		//Entrada de Dados para a Palavra, Vida e Dica
		Scanner entrada = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a palavra da forca: ");
		play.setPalavra(entrada.next().toLowerCase());
		
		// Valida��o da entrada de vidas
		while (play.getVida() < 1) {
		System.out.println("Digite a quantidades de vida que deseja: ");
		play.setVida(entrada.nextInt());
		}
		
		System.out.println("Digite uma dica para a sua palavra: ");
		dica = sc.next();
		
		//In�cio do jogo
		System.out.println("Tudo pronto! Seu jogo vai come�ar.");
		System.out.println("-------------------------------------------");
		System.out.println("Total de vidas: " + play.getVida());
		System.out.println("Sua Dica �: " + dica );

		//Atualiza��o da vida e chamada dos m�todos da classe Tentativa para censurar a palavra
		int contador = play.getVida();
		segredo = play.censurarPalavra(); 	
		play.setPalavraSecreta(segredo);

		// La�o e condi��es para que o jogo continue enquanto a palavra ainda tiver * ou acabem as vidas
		while (contador > 0 && play.getPalavraSecreta().contains("*")) {
			System.out.println("-------------------------------------------");
			System.out.println("Digite uma letra: ");
			System.out.println(play.getPalavraSecreta());
			String tentativa = sc.next().toLowerCase();
			play.verificaTentativa(tentativa);
			
			// Atualiza��o das vidas e letras erradas
			contador = play.getVida();
			System.out.println("Total de vidas: " + play.getVida());
			System.out.println("Letras Erradas:" + play.getPalpite());
					
		}
		// Fechamento dos leitores
		sc.close();
		entrada.close();
	}
	}

	