import src.utilities.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//import src.utilities.*;
/**
 * Main classe qui s'occupe de démarrer le jeu
 */
public class Main {
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

        Board plateau = new Board();
		plateau.affichage();

        /* try {
            
            //System.out.println(wordsVectors.get("ordinateur"));
        } catch (Exception e) {
            System.out.println("Votre fichier w2v_final3 n'est pas dans le répertoir spécifié");
        }  */

        ReadFile rf = new ReadFile();
        wordsVectors = rf.readVectors(filePath);
        //String wordToGuess = game.getRandWord(wordsVectors);
        
        while(game.getGameOn() != false) {
            game.showWords("ordinateur", wordsVectors); 
        } 
         

    }

   /*  public void tours(int nbPlayers) {
        Scanner sc = new Scanner(System.in);
        Joueur listJoueur = new Joueur[nbPlayers];
        for (int i = 0; i < nbPlayers; i++) {
            System.out.println("Donnez votre nom joueur:" + i);
            String nameP = sc.nextLine();
            System.out.println("Choisissez votre type de dé: 1.Dé \n2.Dé spécial");
            int deP = Integer.parseInt(sc.nextLine());
            Joueurs j = new Joueur();
            listJoueur[i] = j;
        }

        //Tour
        boolean tourJ = true;
        count = 0;
        while(tourJ) {
            tourJ = false;
            Joueur actualJ = listJoueur[count];
            //Joueur lance dé
            actualJ.mouvement(actualJ.getDe());
            System.out.println(actualJ.getPos());
            //switch() {}
        }
    } */
}
