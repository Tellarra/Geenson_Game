package src.utilities;
import java.util.Random;
/**
 * Classe qui construit le dé
 */
public class Des {
	//Variables
	protected int[] valeurs = new int[4];
	
	/**
	 * Constructeur
	 * @param valeurs valeurs du dé
	 */
	public Des(int[] valeurs) {
		for (int i=0; i<valeurs.length; i++) {
			this.valeurs[i] = valeurs[i];
		}
	}
	
	/**
	 * Get valeurs du dé
	 * @return valeurs
	 */
	public int[] getValeurs() {
		return this.valeurs;
	}
	
	/**
	 * Méthode pour jeter le dé
	 * @return valeurs
	 */
	public int jeter() {
		Random r = new Random();
		int n = r.nextInt(4);
		return this.valeurs[n];
	}
	
	/**
	 * Affiche les valeurs du dé
	 */
	public void afficherValeurs() {
		System.out.println("Valeurs possibles du dé :");
		for (int i=0; i<this.valeurs.length; i++) {
			System.out.print(this.valeurs[i] + " ");
		}
		System.out.println();
	}
}
