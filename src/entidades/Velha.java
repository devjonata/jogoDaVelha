package entidades;

public class Velha {
	
	private String[][] jogo = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
	
	public void Mostrar() {
		System.out.println("=============");
		System.out.println("JOGO DA VELHA");
		System.out.println("+---+---+---+");
		for (int i=0; i<jogo.length; i++) {
			for (int j=0; j<jogo[i].length; j++) {
				System.out.printf("| %S ", jogo[i][j]);
			}
			System.out.printf("|%n+---+---+---+%n");
		}
	}
	
	public void MudarPosicao(String posicao, String jogador) {
		if (posicao.equals("1")) {
			jogo[0][0] = jogador;
		} else if (posicao.equals("2")) {
			jogo[0][1] = jogador;
		} else if (posicao.equals("3")) {
			jogo[0][2] = jogador;
		} else if (posicao.equals("4")) {
			jogo[1][0] = jogador;
		} else if (posicao.equals("5")) {
			jogo[1][1] = jogador;
		} else if (posicao.equals("6")) {
			jogo[1][2] = jogador;
		} else if (posicao.equals("7")) {
			jogo[2][0] = jogador;
		} else if (posicao.equals("8")) {
			jogo[2][1] = jogador;
		} else if (posicao.equals("9")) {
			jogo[2][2] = jogador;
		}
	}
	
	public String TrocarJogador(int jogadas) {
		String jogador;
		if (jogadas%2 == 0) {
			jogador = "X";
		} else {
			jogador = "O";
		}
		return jogador;
	}
	
	public boolean VerificarPosicao(String posicao) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (jogo[i][j].equals(posicao)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public String VerificarGanhador(int jogadas) {
		String[] vet = new String[8];
		String vencedor = null;
		
		vet[0] = jogo[0][0] + jogo[0][1] + jogo[0][2];
		vet[1] = jogo[1][0] + jogo[1][1] + jogo[1][2];
		vet[2] = jogo[2][0] + jogo[2][1] + jogo[2][2];
		
		vet[3] = jogo[0][0] + jogo[1][0] + jogo[2][0];
		vet[4] = jogo[0][1] + jogo[1][1] + jogo[2][1];
		vet[5] = jogo[0][2] + jogo[1][2] + jogo[2][2];
		
		vet[6] = jogo[0][0] + jogo[1][1] + jogo[2][2];
		vet[7] = jogo[0][2] + jogo[1][1] + jogo[2][0];
		
		if (jogadas <= 8) {
			for (int i=0; i<vet.length; i++) {
				if (vet[i].equals("XXX")) {
					vencedor = "O JOGADOR X";
				} else if (vet[i].equals("OOO")) {
					vencedor = "O JOGADOR O";
				}
			}
		} else {
			vencedor = "O JOGO DEU VELHA";
		}
		return vencedor;
	}

}
