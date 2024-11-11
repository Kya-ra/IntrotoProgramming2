import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

public class WordLinks
{

    public static ArrayList<String> readDictionary(BufferedReader br) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            words.add(line);
        }
        return words;
    }

    public static String[] readWordList(String input)
    {
        return input.split(", ");
    }

    public static boolean isUniqueList(String[] checkWords)
    {
        for (int i = 0; i < checkWords.length; i++) {
            for (int j = i+1; j < checkWords.length; j++) {
                if (Objects.equals(checkWords[i], checkWords[j]))
                    return false;
            }
        }
        return true;
    }

    public static boolean isEnglishWord(String[] checkWords, String[] dictionary) {
        for (String checkWord : checkWords) {
            if (Arrays.binarySearch(dictionary, checkWord) < 0) {
                return false;
            }

        }
        return true;
    }


    public static boolean isDifferentByOne(String[] checkWords)
    {
        boolean instance1 = false;
        for (int i = 0; i < checkWords.length - 1; i++) {
            for (int j = 0; j < checkWords[i].length(); j++) {
                 if (checkWords[i].charAt(j) != checkWords[i + 1].charAt(j)) {
                    if (instance1) {
                        return false;
                    }
                    else {
                        instance1 = true;
                    }
                    }
                }
            instance1 = false;
            }
        return true;
        }

    /*public void isWordChain(String[], String[])
    {

    }*/

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        FileReader fr = new FileReader("words.txt");
        BufferedReader br = new BufferedReader(fr);

        String[] dictionary = readDictionary(br).toArray(new String[0]);
        Arrays.sort(dictionary);

        System.out.println("Enter a comma separated list of words (or an empty list to quit):");
        String fullinput = input.nextLine();
        System.out.println(fullinput);
        String[] words = readWordList(fullinput);

        if (isUniqueList(words)) {
            if(isEnglishWord(words, dictionary)) {
                if (isDifferentByOne(words)) {
                    System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
                }
                else {
                    System.out.println("Not a valid chain of words from Lewis Carroll's word-links game");
                }
            }
            else {
                System.out.println("Not a valid chain of words from Lewis Carroll's word-links game");
            }
        }
        else {
            System.out.println("Not a valid chain of words from Lewis Carroll's word-links game");
        }
    }
}
