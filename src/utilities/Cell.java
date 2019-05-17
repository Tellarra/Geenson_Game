package src.utilities;
/**
 * Classe qui construit une cellule du plateau
 */
public abstract class Cell{
	//Variables
	protected int[] position = new int[2];
	
	/**
	 * Constructeur
	 * @param pos position de la cellule
	 */
	public Cell(int[] pos) {
		this.position[0] = pos[0];
		this.position[1] = pos[1];
	}
	
	/**
	 * Get position de la cellule
	 * @return position
	 */
	public int[] getPos() {
		return this.position;
	}
	
	/**
	 * Méthode qui contient l'effet associé à la cellule
	 */
	public abstract void effet();
	
	/**
	 * Méthode qui va afficher le type de la cellule
	 * @return un string
	 */
	public abstract String affichage();
	

}