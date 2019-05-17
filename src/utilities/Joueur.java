package src.utilities;
/**
 * Classe pour la création des joueurs
 */
public class Joueur {
    //Variables
    protected int[] position = new int[2];
    protected int[] valeursDefaut = {1,2,3,4};
    protected Des deNormal = new Des(valeursDefaut);
    protected Des deSpe;
    protected String pseudo;
    protected int nbJoueur;

    /**
	 * Constructeur
	 * @param nom nom du joueur
	 * @param choix choix de dé du joueur
	 * @param nbJoueur nombre du joueur
	 */
    public Joueur(String nom, Des choix, int nbJoueur) {
	this.pseudo = nom;
	this.deSpe = choix;
	this.nbJoueur = nbJoueur;
	this.position[0] = 0;
	this.position[1] = 0;
	}

	public Joueur() {
		//Constructeur vide
	}
    
    /**
	 * Setter
	 * @param pos position du joueur
	 */
    public void setPosition(int[] pos) {
    	this.position[0] = pos[0];
    	this.position[1] = pos[1];
    }
	
    /**
	 * Getter Position
	 * @return position
	 */
    public int[] getPosition() {
		return this.position;
    }
	
	/**
	 * Getter Dé Special
	 * @return deSpe
	 */
    public Des getDeSpe() {
		return this.deSpe;
    }
	
	/**
	 * Getter deNormal
	 * @return deNormal
	 */
    public Des getDeNormal(){
		return this.deNormal;
    }
	
	/**
	 * Getter pseudo
	 * @return pseudo
	 */
    public String getPseudo() {
		return this.pseudo;
    }
	
	/**
	 * Getter numéro du Joueur
	 * @return nbJoueur
	 */
    public int getNbJoueur() {
    	return this.nbJoueur;
    }
    
    /**
	 * Fait lancer le dé et avancer le joueur sur le plateau
	 * @param choix le choix de dé du joueur
	 */
    public void mouvement(Des choix) {
		int jet = choix.jeter();
		for (int i=0; i<jet; i++) {
		    if (this.position[0] % 2 == 0) {
				this.position[1]++;
			if (this.position[1]==5) {
			    this.position[1] = 4;
			    this.position[0]++;
			}
		    } else {
				this.position[1]--;
				if (this.position[1]==-1) {
				    this.position[1]=0;
				    this.position[0]++;
				}
		    }
		}
		if (this.position[0]>4) {
		    this.position[0]=4;
		}
		
    }
}
