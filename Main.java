import src.utilities.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//import src.utilities.*;
public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = "";
        int nbPlayers = 0;
        int nbTry = 0;
        int nbRes = 0;
        HashMap<String , ArrayList<Double>> wordsVectors;
        
        //java Main --w2v ../Geenson_Game/ --nbPlayers 2 --nbTry 3 --k 3 --magicalDice
        
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
                case "--magicalDice" :
                    //Dice md = new Dice();
                    break;
            }
        }
        
        GameOn game = new GameOn(nbPlayers, nbTry, nbRes);

        System.out.println("var = " + filePath + " " + nbPlayers + " " + nbTry + " " + nbRes);

        /* try {
            
            //System.out.println(wordsVectors.get("ordinateur"));
        } catch (Exception e) {
            System.out.println("Votre fichier w2v_final3 n'est pas dans le répertoir spécifié");
        } */

        ReadFile rf = new ReadFile();
        wordsVectors = rf.readVectors(filePath);
        String wordToGuess = game.getRandWord(wordsVectors);
        game.showWords(wordToGuess, wordsVectors);      

    }
}
