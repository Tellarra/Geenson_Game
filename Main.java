import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = System.getProperty("user.dir");
        ReadFile rf = new ReadFile();
        HashMap<String , ArrayList<Double>> wordsVectors = rf.readVectors(filePath);
        System.out.println(wordsVectors.get("mère"));
    }
}
