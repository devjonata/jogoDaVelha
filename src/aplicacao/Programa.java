package aplicacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Velha;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Velha v = new Velha();
		int jogadas = 0;
		String posicao;
		int jogadasX = 0, jogadasO = 0;
		v.mostrar();
		long tempoInicial = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date momento = new Date();
		
		do {
			System.out.print("Informe uma posicao para " + v.trocarJogador(jogadas) + ": ");
			posicao = sc.next();
			v.verificarPosicao(posicao);
			
			do {
				if (v.verificarPosicao(posicao)) {
					System.out.println("Posicao invalida, tente novamente: ");
					System.out.print("Informe uma posicao para " + v.trocarJogador(jogadas) + ": ");
					posicao = sc.next();
				}
			}while(v.verificarPosicao(posicao));
			
			if (v.trocarJogador(jogadas).equals("X")) {
				jogadasX++;
			} else if(v.trocarJogador(jogadas).equals("O")) {
				jogadasO++;
			}
			
			v.mudarPosicao(posicao, v.trocarJogador(jogadas));
			jogadas++;
			v.verificarGanhador(jogadas);	
			v.mostrar();
			
		}while(v.verificarGanhador(jogadas) == null);
		long tempoTotal = System.currentTimeMillis() - tempoInicial;
		
		if (v.verificarGanhador(jogadas).equals("O JOGO DEU VELHA")) {
			System.out.println(v.verificarGanhador(jogadas));
		} else {
			System.out.println(v.verificarGanhador(jogadas) + " É O VENCEDOR !!!");
		}
		
		System.out.println();
		System.out.println("Dados do jogo");
		System.out.println();
		System.out.println("Data do jogo: " + sdf.format(momento));
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
