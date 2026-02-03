public class OddEvenMergeSortTester {
    public static void main(String[] args) {
    OddEvenMergeSort oems = new OddEvenMergeSort();
    int[] testingArray = new int[] { 5, 1, 3, 0, 7, 4, 2, 9}; 
    System.out.println(" Before Sorting: ");
    printResults(testingArray);
    testingArray = oems.sort(testingArray);
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
