package LAB2;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SpellChecker {

    /* 
    --  To test this class (in the command prompt):
    --  Use the cd command to navigate to the directory where your java files are stored, then compile:
        javac SpellChecker.java
    --  Then run the following command:
        java SpellChecker <words to check>
    --  Example:
        java SpellChecker This is spelled correctly
    */

    public static boolean checkWord(String word, HashTable dictionary) {
        // TODO: check if the (hashed) word exists in the dictionary
        // output: if the word is in the dictionary, return true
        boolean x = false;
        int index = dictionary.hashFunction(word);
        for (int i = 0; i < dictionary.getTable()[index].size() ; i++){ 
            if(word == dictionary.get(word)){
                x = true;
            }else{
                x = false;
            }
        }
        return x;

    }

    public static List<String> checkSeveralWords(List<String> words, HashTable dictionary) {
        // This method takes in several words to check, checks them, and then removes them from the list of words to check.
        for (int i = words.size()-1; i>=0; i--){
            if (checkWord(words.get(i), dictionary)){
                words.remove(i);
            }
        }
        return words;
    }

    public static void main(String[] args) throws IOException{
        // read the dictionary file and create a HashTable
        File dictionaryFile = new File("dictionary.txt");
        HashTable dictionary = new HashTable();
        try (Scanner sc = new Scanner(dictionaryFile)) {
            while (sc.hasNext()) {
                dictionary.insert(sc.next());
            }
        }
        // Test the spell checker
        List<String> wordsToCheck = new ArrayList<String>(Arrays.asList(args));
        System.out.println("The following words are not spelled correctly, according to our dictionary: " + checkSeveralWords(wordsToCheck, dictionary));
    }
}