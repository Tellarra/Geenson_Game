package src.utilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import src.utilities.*;
public class GameOn {
    int nbPlayers = 0;
    int nbTry = 0;
    int nbRes = 0;
    Boolean gameOn = false;
    //Player = new Player();

    public GameOn(int nbPlayers, int nbTry, int nbRes) {
        this.nbPlayers = nbPlayers;
        this.nbTry = nbTry;
        this.nbRes = nbRes;
        gameOn = true;
    }

    /* private Players[] setPlayers() {
       //Player playersListe = new Player[nbPlayers]; 
    } */

    //Lancer de dé ?
    /* private int playDice(Type de dé) {
        //return int nb = dee.random();
    }*/
    
    //La ou on doit savoir si c'est 
    public String getRandWord(HashMap<String , ArrayList<Double>> wordsList) {
        //If boxBoard.equal("relance le dé") -> Rappel la fonction playDice
        //Else -> choisit un mot au hasard dans la liste et demande user input
        String randomName = (String)wordsList.keySet().toArray()[new Random().nextInt(wordsList.keySet().toArray().length)];
        //System.out.println(randomName);
        System.out.println("Faites deviner ce mot: " + randomName);
        return randomName;
    }

    public void showWords(String wordToGuess) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Donnez 3 indices");
        String [] clues = new String[3];
        for(int i = 0; i < clues.length; i++) {
            clues[i] = sc.nextLine();
            System.out.println(clues[i]);
        }
        sc.close();
        getMostSimilare(clues);
        
    }

    public int getMostSimilare(String [] clues) {
        //Array de vecteur
        //UtilVector.moy()
        //Tab [10][2]
        //for(int i = 0; i < tab.length; i++) {
            
        System.out.println();
        return 0;
    }

}