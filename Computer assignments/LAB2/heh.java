package LAB2;

public class heh {

public int hashFunction2(String word) {
    // TODO:    Hash function goes here
    // Input:   String to be hashed
    // Output:  Hashcode of the input String
    char[] wordToChars = word.toCharArray();
    int s = 0;
    for (int i = 0; i < wordToChars.length; i++){
        s += wordToChars[i]; // sum is then the word
    }
    return s % wordToChars.length;
//o(n) n la taille du mot
}
}
