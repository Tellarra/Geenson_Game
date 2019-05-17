package src.utilities;
import java.util.Scanner;

public class GameTurn {
	/**
	 * Tour du joueur
	 * @param j Joueur
	 * @param b Le plateau
	 */
	public static void currentTurn(Joueur j, Board b) {
		boolean turn = true;
		Scanner sc = new Scanner(System.in);
		while (turn) {
			if(b.getCell(j.getPosition()) instanceof NormalCell) {
				b.getCell(j.getPosition()).setAllJ(j.getNbJoueur(),"__");
			}
			b.affichage();
			turn = false;
			System.out.println("Choisis ton dé (1 ou 2)");
			System.out.print("Dé 1 : ");
			j.deNormal.afficherValeurs();
			System.out.print("\nDé 2 : ");
			j.deSpe.afficherValeurs();
			System.out.println();
			int choix = Integer.parseInt(sc.nextLine());
			if (choix == 1) {
				j.mouvement(j.getDeNormal());
			}
			if (choix == 2) {
				j.mouvement(j.getDeSpe());
			}
			int[] pos = j.getPosition();
			if ((pos[0] != 4) || (pos[1] != 4)) {
				if(b.getCell(j.getPosition()) instanceof NormalCell) {
					b.getCell(j.getPosition()).setAllJ(j.getNbJoueur());
				} else {
					b.getCell(j.getPosition()).setJ(j.getNbJoueur());
				}
				b.getCell(j.getPosition()).effet();
			}
		}
	}
	
	/**
	 * Le tour en général
	 * @param ongoing Si le jeu est finis ou pas
	 * @param listJoueur Le tableau des joueurs
	 * @param b Le plateau
	 */
	public static void allTurns(boolean ongoing, Joueur[] listJoueur, Board b) {
		//b.affichage();
		for(int i=0; i<listJoueur.length; i++) {
			int winner = 0;
			currentTurn(listJoueur[i], b);
			int[] finalPos = listJoueur[i].getPosition();
			if ((finalPos[0] == 4) && (finalPos[1] == 4)) {
				winner = i;
				ongoing = false;
				break;
			}
			if (ongoing) {
				allTurns(ongoing, listJoueur, b);
			} else {
				end(listJoueur[winner]);
			}
		}
	}
	
	public static void end(Joueur winner) {
		System.out.println("Jeu terminé. Le gagnant est "+ winner.getPseudo());
	}
}


