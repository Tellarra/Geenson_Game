package src.utilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

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

    public void showWords(String wordToGuess, HashMap<String , ArrayList<Double>> wordsList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Donnez 3 indices");
        String [] clues = new String[3];
        for(int i = 0; i < clues.length; i++) {
            clues[i] = sc.nextLine();
            System.out.println(clues[i]);
        }
        sc.close();
        //double[] listVecto = wordsList.toArray(new double[wordsList.size()]);
        
        double moyenne = 0;
        //Prend les indices et pour chaque indice fait un tableau de double
        for (String clue : clues) {
            double[] listVec = new double[100];
            for(int i = 0; i < listVec.length; i++) {
                listVec[i] = wordsList.get(clue).get(i);
            }
            //double [] clueList = wordsList.get(clue);
            moyenne += UtilVector.meanVec(listVec);
            
        }
        moyenne = moyenne/3;
        System.out.println(moyenne);

        

        /* TreeMap<String, Double> tp = new TreeMap<String, Double>();
        double moyenne = 0;
        for(int i = 0; i < wordsList.size(); i++) {
            moyenne += UtilVector.meanVec(wordsList.get(clues[i]));
        }
         
        for (Key key : wordsList.values()) {
            UtilVector.cosVec(moyenne, wordsList.get(key));
            
        } */
        //getMostSimilare(clues, wordsList);
        
    }

    public int getMostSimilare(String [] clues) {
        //Array de vecteur
        //UtilVector.moy()
        //Tab [10][2]
        //for(int i = 0; i < tab.length; i++) {
        TreeMap<String, Double> tp = new TreeMap<String, Double>();
        //for(int i = 0; i < ) {}
        System.out.println();
        return 0;
    }

    /* public double[] arrayListToArr(ArrayList listVect) {
        
    } */

}