package src.utilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Classe qui créée une partie
 * avec des méthodes qui fonctionnent 
 * autour de la recherche des mots dans la liste des vecteurs
 */
public class GameOn {
    int nbPlayers;
    int nbTry;
    int nbRes;
    String wordGuess;
    Boolean gameOn;
    //Player = new Player();

    /**
     * Constructeur de GameOn, qui permet de créer la partie
     * @param nbPlayers Nombre de joueurs
     * @param nbTry Nombre d'essaies pour deviner
     * @param nbRes Nombre de résultat à afficher
     */
    public GameOn(int nbPlayers, int nbTry, int nbRes) {
        this.nbPlayers = nbPlayers;
        this.nbTry = nbTry;
        this.nbRes = nbRes;
        gameOn = true;
    }

    /**
     * Pour savoir si le tour du joeur est finis ou non
     * Fini si tour = false
     * Sinon non
     * @return randomWord
     */
    public boolean getGameOn() {
        return this.gameOn;
    }

    /* private Players[] setPlayers() {
       //Player playersListe = new Player[nbPlayers]; 
    } */

    //Lancer de dé ?
    /* private int playDice(Type de dé) {
        //return int nb = dee.random();
    }*/
    
    /**
     * Méthode qui permet de choisir un mot au hasard 
     * à faire deviner à l'ordinateur
     * @param wordsList liste des mots et leurs vecteurs
     * @return randomWord (String)
     */
    public String getRandWord(HashMap<String , ArrayList<Double>> wordsList) {
        //If boxBoard.equal("relance le dé") -> Rappel la fonction playDice
        //Else -> choisit un mot au hasard dans la liste et demande user input
        String randomWord = (String)wordsList.keySet().toArray()[new Random().nextInt(wordsList.keySet().toArray().length)];
        //System.out.println(randomName);
        System.out.println("Faites deviner ce mot: " + randomWord);
        return randomWord;
    }

    /**
     * Méthode qui permet de montrer les mots 
     * @param wordToGuess Mot à deviner
     * @param wordsList liste des mots et leurs vecteurs
     */
    public void showWords(String wordToGuess, HashMap<String , ArrayList<Double>> wordsList) {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        TreeMap<Double, String> keys = new TreeMap<Double, String>();
        System.out.println(wordToGuess);
        while(!keys.containsValue(wordToGuess)) {
            System.out.println("Donnez 3 indices");
            String [] clues = new String[3];
            for(int i = 0; i < clues.length; i++) {
                clues[i] = sc.nextLine();
                while(!wordsList.containsKey(clues[i])) {
                    System.out.print("Votre mot n'existe pas dans notre dictionnaire - recommancez: ");
                    clues[i] = sc.nextLine();
                }
            }
            System.out.println("\nIndices: " + clues[0] + " / " + clues[1] + " / " + clues[2]);
            keys = getMostSimilare(clues, wordsList);
            if(count == nbTry) {
                System.out.println("Oh non vous n'avez pas réussi !");
                this.gameOn = false;
                break;
            }
            
            count++;
        }
        sc.close();
        
        System.out.println("\nBravo vous m'avez bien fait deviner le mot : " + wordToGuess);
        this.gameOn = false;
        
    }

    /**
     * Méthode qui doit retourner les 10 premiers les plus simi
     * @param max Le maximum à afficher
     * @param tp Le tree map avec les valeurs triées
     * @return keys
     */
    public TreeMap<Double, String> putFirstEntries(int max, TreeMap<Double,String> tp) {
        int count = 0;
        TreeMap<Double, String> keys = tp;
        System.out.println("\n");
        for (Map.Entry entry : tp.entrySet()) {
            if (count >= max) {
                break;
            }
            System.out.println(entry.getValue() + " " +  entry.getKey());
            keys.put((double)entry.getKey(), entry.getValue().toString());
            count++;
        }
        return keys;
      }
    
    /**
     * Fonction pour retourner les n similaires mots
     * @param clues tableau des indices
     * @param wordsList liste des mots et leurs vecteurs
     * @return keys
     */
    public TreeMap<Double, String> getMostSimilare(String [] clues, HashMap<String , ArrayList<Double>> wordsList) {
        //Prend les indices et pour chaque indice fait un tableau de double
        double[] clue1= arrListToArr(wordsList.get(clues[0]));
        double[] clue2 = arrListToArr(wordsList.get(clues[1]));
        double[] clue3 = arrListToArr(wordsList.get(clues[2]));
        
        double [] moyenne = UtilVector.meanVec(clue1, clue2, clue3);
        for(int i = 0; i < clues.length; i++) {
            wordsList.remove(clues[i]);
        }
        
        TreeMap<Double, String > tp = new TreeMap<Double,String>(Collections.reverseOrder());

        for (String key : wordsList.keySet()) {
            tp.put(UtilVector.cosVec(moyenne, arrListToArr(wordsList.get(key))), key);
        }

        TreeMap<Double, String> keys = putFirstEntries(nbRes, tp);
         
        return keys;
    }

    /**
     * Transforme un ArrayList en Array de double
     * @param listVect Liste de vecteurs
     * @return values
     */
    public double[] arrListToArr(ArrayList listVect) {
        double [] values = new double[listVect.size()];
        for(int i = 0; i < listVect.size(); i++) {
            values[i] = (double)listVect.get(i);
        }
        return values;
    }

}