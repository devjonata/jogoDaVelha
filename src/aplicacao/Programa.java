package aplicacao;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

import entidades.Velha;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Velha v = new Velha();
		int jogadas = 0;
		String posicao;
		int jogadasX = 0, jogadasO = 0;
		v.Mostrar();
		long tempoInicial = System.currentTimeMillis();
		
		do {
			System.out.print("Informe uma posicao para " + v.TrocarJogador(jogadas) + ": ");
			posicao = sc.next();
			v.VerificarPosicao(posicao);
			
			do {
				if (v.VerificarPosicao(posicao)) {
					System.out.println("Posicao invalida, tente novamente: ");
					System.out.print("Informe uma posicao para " + v.TrocarJogador(jogadas) + ": ");
					posicao = sc.next();
				}
			}while(v.VerificarPosicao(posicao));
			
			if (v.TrocarJogador(jogadas).equals("X")) {
				jogadasX++;
			} else if(v.TrocarJogador(jogadas).equals("O")) {
				jogadasO++;
			}
			
			v.MudarPosicao(posicao, v.TrocarJogador(jogadas));
			jogadas++;
			v.VerificarGanhador(jogadas);	
			v.Mostrar();
			
		}while(v.VerificarGanhador(jogadas) == null);
		long tempoTotal = System.currentTimeMillis() - tempoInicial;
		
		if (v.VerificarGanhador(jogadas).equals("O JOGO DEU VELHA")) {
			System.out.println(v.VerificarGanhador(jogadas));
		} else {
			System.out.println(v.VerificarGanhador(jogadas) + " É O VENCEDOR !!!");
		}
		
		System.out.println();
		System.out.println("Dados do jogo");
		System.out.println();
		
		if (tempoTotal/1000 > 60) {
			long minutos = (tempoTotal/1000)/60;
			long segundos = (tempoTotal/1000)%60;
			System.out.println("Tempo de jogo: " + minutos + " minutos e " + segundos + " segundos.");
		} else {
			System.out.println("Tempo de jogo: " + tempoTotal/1000 + " segundos");
		}
		System.out.println("Total de jogadas: " + jogadas);
		System.out.println("Jogadas X: " + jogadasX);
		System.out.println("Jogadas O: " + jogadasO);
		
		sc.close();
	}

}
