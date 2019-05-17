package src.utilities;

import src.utilities.GameOn;

/**
 * Classe qui crée la cellule normal du plateau
 */
public class NormalCell extends Cell{
	//Variable
	protected String[] allJ = new String[5];
	
	/**
	 * Constructeur
	 * @param pos position de la cellule
	 */
	public NormalCell(int[] pos) {
		super(pos);
		for (int i=0; i<this.allJ.length-1; i++) {
			this.allJ[i] = "__";
		}
		this.allJ[4] = "N";
	}
	
	/**
	 * Set la position du joueur sur la case avec son numéro
	 * @param nbJoueur le nombre du joueur
	 */
	public void setAllJ(int nbJoueur){
		this.allJ[nbJoueur] = "J" + nbJoueur;
	}

	/**
	 * Set la case du joueur qui était dessus en __
	 * Pour signifier qu'il a bougé
	 * @param nbJoueur le Nombre du joueur
	 * @param vide la ligne __
	 */
	public void setAllJ(int nbJoueur, String vide) {
		this.allJ[nbJoueur] = vide; //Ici vide = forcément "__"
	}
	
	/**
	 * Fait deviner le mot à l'ordinateur
	 */
	public void effet() {
		
	}
	
	/**
	 * Affiche la case avec les joueurs dedans
	 */
	public String affichage() {
		String s = "";
		for (int i=0; i<this.allJ.length; i++) {
			s = s + this.allJ[i];
		}
		return s;
	}
}