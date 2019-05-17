package src.utilities;
/**
 * Classe qui crée la cellule avec un malus
 */
public class MalusCell extends Cells {	
	protected Joueur j = new Joueur();
	/**
	 * Constructeur
	 * @param pos position de la cellule
	 */
	public MalusCell(int[] pos) {
		super(pos);
	}
	
	/**
	 * Set la position du joueur sur celle de la case
	 * @param j position du joueur
	 */
	public void setJ(Joueur j) {
		this.j = j;
	}
	
	/**
	 * Fait reculer le joueur de 3 cases
	 */
	public void effet() {
		int[] malus = j.getPosition();
		malus[1] = malus[1] - 3;
		this.j.setPosition(malus);
	}
	
	/**
	 * Affiche le type de la case
	 */
	public String affichage() {
		return "X";
	}
}