public class OddEvenMergeSorttt {

    /* The time complexity for the sort() method is of O(n log n) as it divides the input array
     * into odd and even arrays using the separateOddEven method and then calls itself recursively 
     * until the array length is of 1. Therefore, the time complexity is O(n log n) 
     */
    public int[] sort(int[] arr) {
        // The recursive base-case
        if (arr.length <= 1) {
            return arr;
        }
    
        int[][] separated = separateOddEven(arr);
        
        // Recursively sort the separated arrays.
        int[] odd = sort(separated[0]);
        int[] even = sort(separated[1]);
    
        // Merge the separated arrays back together. Merge based on odd/even indices.
        int[] merged = oddEvenMerge(odd, even);
        // Put the merged array into the correct order (this step can also be done in the oddEvenMerge
        int[] sorted = compareExchange(merged);
    
        return sorted;
    }

    /* The time complexity for the separateOddEven method is O(n), with n being the size of the array arr, 
     * as the the alogithm loops through the array once, checks if the integer at the index is even or odd 
     * and adds it to the odd or even array subsequently
     */
    public int[][] separateOddEven(int[] arr) {

    int n1 = (int) Math.ceil(arr.length*1.0 / 2); 
    int n2 = (int) Math.abs(arr.length*1.0 / 2); 

    int even [] = new int [n1]; 
    int odd [] = new int [n2]; 
    int y = 0, z = 0;
    for (int i = 0; i < arr.length; i++){
        if (i % 2 == 0){
            even[y] = arr[i];
            y++;
        }else{
            odd[z] = arr[i];
            z++;
        }
    }
    int a [][] = {odd,even};
    return a;
    }

    /* The time complexity for the oddEvenMerge method is O(n), with n being the size of the even array taken 
     * as parameter, because the algorithm loops through the odd and even arrays at the same time and adds its
     *  elements to an array x
     */
    public int[] oddEvenMerge(int[] oddArr, int[] evenArr) {

        int x [] = new int [oddArr.length+evenArr.length];
        int i = 0, j = 0, k = 0;
        while (i < evenArr.length && j < oddArr.length) {
            if (evenArr[i] <= oddArr[j]) {
                x[k] = evenArr[i];
                i++; k++;
                if (i == evenArr.length-1){ 
                    while ( j< oddArr.length){
                        x[k] = oddArr[j];
                        j++; k++;
                    }
                }
                
             }
             else {
                x[k] = oddArr[j];
                j++; k++;
                if (j == oddArr.length-1){ 
                    while (i < evenArr.length) {
                        x[k] = evenArr[i];
                        i++; k++;
                    }
                }
                
             }
             
         }
         return x;
     }


    /* The time complexity for the compareExchange method is O(n), with n being the middle of the array taken 
     * as parameter, because the algorithm loops through the array once, and swaps the even elements with the 
     * odd elements if the even elements are bigger than the odd elements.
     */
    public int[] compareExchange(int[] output) {
    System.out.print("avant compareexchange"); printResults(output);  System.out.println();
    for (int i = 0; i < output.length-1; i++){
        if (output[i] > output[i+1]){ 
            int change = output[i];
            output[i] = output[i+1];
            output[i+1] = change;
        }
    }
    System.out.print("apres compareexchange"); printResults(output); System.out.println();
    return output;
    }

public static void main(String[] args) {
    OddEvenMergeSorttt x = new OddEvenMergeSorttt();

    int[] testingArray = new int[] { 5, 1, 3, 0};
    System.out.println(" Before Sorting: ");
    printResults(testingArray);
    testingArray = x.sort(testingArray);
    System.out.println("\n After Sorting:");
    printResults(testingArray);
    System.out.println("\n Is your array sorted now?");
    }
    public static void printResults(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
    System.out.print(" " + arr[i]);
    }
}

    
}