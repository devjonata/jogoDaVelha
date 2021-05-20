package aplicacao;

import java.util.Scanner;

import entidades.Velha;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Velha v = new Velha();
		int jogadas = 0;
		String posicao;
		v.Mostrar();
		
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
			
			v.MudarPosicao(posicao, v.TrocarJogador(jogadas));
			jogadas++;
			v.VerificarGanhador(jogadas);

			
			v.Mostrar();
			
		}while(v.VerificarGanhador(jogadas) == null);
	
		if (v.VerificarGanhador(jogadas).equals("O JOGO DEU VELHA")) {
			System.out.println(v.VerificarGanhador(jogadas));
		} else {
			System.out.println(v.VerificarGanhador(jogadas) + " É O VENCEDOR !!!");
		}
		
		
		sc.close();
	}

}
