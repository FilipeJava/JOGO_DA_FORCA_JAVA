package br.com.fiap.cp2.jogoforca.view;

import java.util.Scanner;

import br.com.fiap.cp2.jogoforca.model.Tentativa;

public class Forca {

	public static void main(String[] args) {
		// Declações das variáveis e instancia de Tentativa
		Tentativa play = new Tentativa();
		String segredo = "";
		String dica;
		
		// Mensagens sobre as regras do jogo
		System.out.println("Seja bem vindo ao Jogo da Forca do Grupo Tills.");
		System.out.println("As regras são simples. Você vai digitar uma palavra para a forca, depois a quantidade de vidas que deseja e "
				+ "por ultimo irá passar uma dica.");
		System.out.println("Se você acertar a palavra antes das vidas zerarem você ganha!");
		System.out.println("-------------------------------------------");
		
		//Entrada de Dados para a Palavra, Vida e Dica
		Scanner entrada = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a palavra da forca: ");
		play.setPalavra(entrada.next().toLowerCase());
		
		// Validação da entrada de vidas
		while (play.getVida() < 1) {
		System.out.println("Digite a quantidades de vida que deseja: ");
		play.setVida(entrada.nextInt());
		}
		
		System.out.println("Digite uma dica para a sua palavra: ");
		dica = sc.next();
		
		//Início do jogo
		System.out.println("Tudo pronto! Seu jogo vai começar.");
		System.out.println("-------------------------------------------");
		System.out.println("Total de vidas: " + play.getVida());
		System.out.println("Sua Dica é: " + dica );

		//Atualização da vida e chamada dos métodos da classe Tentativa para censurar a palavra
		int contador = play.getVida();
		segredo = play.censurarPalavra(); 	
		play.setPalavraSecreta(segredo);

		// Laço e condições para que o jogo continue enquanto a palavra ainda tiver * ou acabem as vidas
		while (contador > 0 && play.getPalavraSecreta().contains("*")) {
			System.out.println("-------------------------------------------");
			System.out.println("Digite uma letra: ");
			System.out.println(play.getPalavraSecreta());
			String tentativa = sc.next().toLowerCase();
			play.verificaTentativa(tentativa);
			
			// Atualização das vidas e letras erradas
			contador = play.getVida();
			System.out.println("Total de vidas: " + play.getVida());
			System.out.println("Letras Erradas:" + play.getPalpite());
					
		}
		// Fechamento dos leitores
		sc.close();
		entrada.close();
	}
	}

	