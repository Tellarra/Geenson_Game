package src.utilities;
/**
 * Classe qui crée le plateau du jeu
 */
public class Board {
	//Variables 
	protected Cell[][] currentBoard = new Cell[5][5];
	
	/**
	 * Constructeur
	 */
	public Board() {
		int[] pos = new int[2];
		for(int i=0; i<this.currentBoard.length; i++) {
			for(int j=0; j<this.currentBoard[i].length; j++) {
				pos[0] = i;
				pos[1] = j;
				if(j==4) {
					this.currentBoard[i][j] = new MalusCell(pos);
				} else {
					if(j==2) {
						this.currentBoard[i][j] = new BonusCell(pos);
					} else {
						this.currentBoard[i][j] = new NormalCell(pos);
					}
				}
			}
		}
	}
	
	/**
	 * Afficher le plateau
	 */
	public void affichage() {
		for(int i=0; i<this.currentBoard.length; i++) {
			for(int j=0; j<this.currentBoard[i].length; j++) {
				System.out.print("|" + this.currentBoard[i][j].affichage());
			}
			System.out.println("|");
		}
	}
}