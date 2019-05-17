import src.utilities.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//import src.utilities.*;
/**
 * Main classe qui s'occupe de démarrer le jeu
 */
public class Main {
    /**
     * Main
     * @param args Le tableau de la ligne de commande
     * @throws Exception pour éviter les erreurs de lecture de args
     */
    public static void main(String[] args) throws Exception {
        String filePath = "";
        int nbPlayers = 0;
        int nbTry = 0;
        int nbRes = 0;
        HashMap<String , ArrayList<Double>> wordsVectors;
        
        //java Main --w2v ../Geenson_Game/ --nbPlayers 2 --nbTry 3 --k 3
        
        if(args.length == 8) {
    
            for(int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "--w2v" :
                        filePath = args[1];
                        break;
                    case "--nbPlayers" :
                        nbPlayers = Integer.parseInt(args[3]);
                        break;
                    case "--nbTry" :
                        nbTry = Integer.parseInt(args[5]);
                        break;
                    case "--k" :
                        nbRes = Integer.parseInt(args[7]);
                        break;
                }
            }
        } else {
            System.out.println("Vous devez entrer les informations requises pour lancer une partie");
            System.exit(1);
        }
        
        GameOn game = new GameOn(nbPlayers, nbTry, nbRes);
        
        ReadFile rf = new ReadFile();
        wordsVectors = rf.readVectors(filePath);
        Board b = new Board();
        Joueur[] listJoueur = preparation(nbPlayers);
        int[] initial = {0,0};
        NormalCell first = (NormalCell)b.getCell(initial);
        for(int i=0; i<listJoueur.length; i++) {
        	first.setAllJ(i); 	
        }
        GameTurn.allTurns(true, listJoueur, b);        

    }

    /**
     * Prépare les paramètres du jeu
     * @param nbPlayers Nombre de joueurs
     * @return La liste des joueurs
     */
    public static Joueur[] preparation(int nbPlayers) {
        Scanner sc = new Scanner(System.in);
        Joueur[] listJoueur = new Joueur[nbPlayers];
        for (int i = 0; i < nbPlayers; i++) {
            System.out.println("Donnez votre nom joueur:" + i);
            String nameP = sc.nextLine();
            System.out.println("Vous avez un dé normal à 4 faces et un dé bonus. Choisissez votre dé bonus.(1 ou 2)");
            System.out.println("1. Cases du dé : 0,0,4,5");
            int[] valeursSpe1 = {0,0,4,5};
            Des spe1 = new Des(valeursSpe1);
            System.out.println("2. Cases du dé : 2,2,2,2");
            int[] valeursSpe2 = {2,2,2,2};
            Des spe2 = new Des(valeursSpe2);
            int deP = Integer.parseInt(sc.nextLine());
            if(deP == 1) {
                Joueur j = new Joueur(nameP, spe1, i);
                listJoueur[i] = j;
            } else if(deP == 2) {
                Joueur j = new Joueur(nameP, spe2, i);
                listJoueur[i] = j;
            }
            
        
        }
        return listJoueur;

      
    } 
}
