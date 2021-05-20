package entidades;

public class Velha {
	
	private String[][] jogo = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
	
	public void Mostrar() {
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

}
