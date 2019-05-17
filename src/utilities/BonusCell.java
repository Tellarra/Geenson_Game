package src.utilities;
/**
 * Classe qui crée la cellule bonus
 */
public class BonusCell extends Cell{
	//Variable
	protected Joueur j;
	
	/**
	 * Constructeur
	 * @param pos position de la cellule
	 */
	public BonusCell(int[] pos) {
		super(pos);
	}
	
	/**
	 * Set la position du joueur sur celle de la case
	 * @param j position du joueur
	 */
	public void setJ(Joueur j){
		this.j = j;
	}
	
	/**
	 * Fait rejouer le joueur
	 */
	public void effet() {
		System.out.println("Vous pouvez relancer le dé");
	}
	
	/**
	 * Affiche le type de la case
	 */
	public String affichage() {
		return "R";
	}
}