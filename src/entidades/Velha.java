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

}
