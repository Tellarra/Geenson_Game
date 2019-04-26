import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadFile {
    /**
     * Lecture du fichier w2v_final3
     * Pour chaque ligne, on va séparer en key value
     * Key = Le mot
     * Value = Les vecteurs
     * @return un Hashmap <String, Arraylist <Double> >
     * @throws Exception
     */
    public static HashMap readVectors() throws Exception {
        FileReader fr = new FileReader("/Users/adele/Documents/GitHub/Geenson_Game/w2v_final3");
        BufferedReader br = new BufferedReader(fr);
        String line;
        HashMap<String , ArrayList<Double>> wordsVectors = new HashMap<String , ArrayList<Double>>();
        while((line = br.readLine()) != null) {
            String [] words = line.split(" ");
            ArrayList <Double> vectorArr = new ArrayList<>();

            if(words.length > 2) {
                for(int i = 1; i < words.length; i++) {
                    vectorArr.add(Double.parseDouble(words[i]));
                }
                wordsVectors.put(words[0], vectorArr);
            }
        }

        fr.close();
        return wordsVectors;
    }
}