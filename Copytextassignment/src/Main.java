import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<String> text = new ArrayList<>();
        FileReader fReader = new FileReader("in.txt");
        BufferedReader bReader = new BufferedReader(fReader);
        String line;
        while ((line = bReader.readLine()) != null) {
            text.add(line);
        }
        bReader.close();

        searchWord(text);
    }

    public static void searchWord(ArrayList<String> text) {
        System.out.println("Type in a word that you wish to search for");
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        for ( int i = 0; i < text.size(); i++ ) {

            if (text.get(i).contains(word)){
                System.out.println(i);
            }

        }
    }
}