import java.util.ArrayList;
import java.util.HashMap;
import src.utilities.*;
public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = System.getProperty("user.dir");
        try {
            ReadFile rf = new ReadFile();
            HashMap<String , ArrayList<Double>> wordsVectors = rf.readVectors(filePath);
            System.out.println(wordsVectors.get("mère"));
        } catch (Exception e) {
            System.out.println("Votre fichier w2v_final3 doit être à la racine du projet");
        }
    }
}
