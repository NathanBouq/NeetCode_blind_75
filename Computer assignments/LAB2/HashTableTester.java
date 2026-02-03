package LAB2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class HashTableTester {

    private static Random rand = new Random();

    public static void main(String[] args) throws IOException {
        // read the dictionary file and create a HashTable
        File dictionaryFile = new File("dictionary.txt");
        HashTable dictionary = new HashTable();

        // If you want, you can include different Hashtable implementations here.

        // Store the words in memory
        List<String> words = new ArrayList<>();
        try (Scanner sc = new Scanner(dictionaryFile)) {
            while (sc.hasNext()) {
                words.add(sc.next());
            }
        }
        testHashTable(words, dictionary);
    }

    public static void testHashTable(List<String> words, HashTable table) {

        long startTime = System.currentTimeMillis();
        for (String word : words) {
            table.insert(word);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to insert all words: " + (endTime - startTime) + " ms");

        int collisions = 0;
        for (List<String> list : table.getTable()) {
            collisions += list.size() - 1;
        }
        System.out.println("Number of collisions: " + collisions);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            // Search for a random word
            String testWord = words.get(rand.nextInt(words.size()));
            table.search(testWord);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to search for 10,000 words: " + (endTime - startTime) + " ms");

    }
}
