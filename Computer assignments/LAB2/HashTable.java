/*  I implememented two hashfunctions : word.length() % SIZE AND word.length() / 16. For a array Linked list of size 256.
For the hashfunction : word.length() % SIZE, the Big O notation is O(n) with n being a constant.
The number of collisions is 369849, the time taken to insert all words is 15 ms. 
The Time taken to search for 10,000 words is between 1,900 and 2,200 ms.
For the hashfunction : word.length() / 16, the Big O notation is O(n) with n being a constant.
The number of collisions is 369849, the time taken to insert all words is 17 ms. 
The Time taken to search for 10,000 words is around 7,000 ms.
The hashfuncitons : word.length() % SIZE, is faster ton insert words (2 ms) and searches around 5,000 ms faster then 
the Hashfunction word.length() / 16.
If we change the size of the array Linked list, the time taken to insert all words is the same, the time taken
to search for 10,000 words is the same. But the number of collisions changes.
*/

package LAB2;

import java.util.LinkedList;
import java.util.List;

class HashTable {
    private final int SIZE = 700;
    private LinkedList<String>[] table;

    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void insert(String word) {
        // TODO: Implement this method - it should insert the word into the HashTable at the appropriate index
        int i = hashFunction(word);
        table[i].add(word);
    }

    public String get(String word){
        // TODO: Implement this method - it should return the word if it exists in the HashTable
        // If the word doesn't exist in the HashTable, don't return it. 
        if(search(word) == true){
            return word;
        }else{
            return null;
        }
    }

    public int hashFunction(String word) {
        // TODO:    Hash function goes here
        // Input:   String to be hashed
        // Output:  Hashcode of the input String
        return word.length() % SIZE;
        //O(constant)
    }

    public int hashFunction1(String word) {
        //TODO:    Hash function goes here
        // Input:   String to be hashed
        // Output:  Hashcode of the input String
        return word.length() / 16;
 
    }

    public boolean search(String word) {
        int index = hashFunction(word);
        return table[index].contains(word);
    }

    public void delete(String word) {
        int index = hashFunction(word);
        table[index].remove(word);
    }
    public List<String>[] getTable() {
        return table;
    }
}