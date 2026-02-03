import java.util.HashSet;

public class Set {
    
    public int hello(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i] + target;
            int vv = nums[i] - target;
            
            if (set.contains(v)) {
                count++;
                set = findAllOccurrences(set, v); // Remove all occurrences of vv
            } else if (set.contains(vv)) {
                count++;
                set = findAllOccurrences(set, vv); // Remove all occurrences of vv
            }
        }
        
        System.out.println("Count equals: " + count);
        return count;
    }

    private HashSet<Integer> findAllOccurrences(HashSet<Integer> set, int value) {
        HashSet<Integer> occurrences = new HashSet<>();
        for (Integer num : set) {
            if (num == value) {
                occurrences.remove(num);
            }
        }
        return occurrences;
    }

    public static void main(String[] args) {
        Set test = new Set();
        int[] nums = new int[]{1, 1, 3, 4, 5};
        test.hello(nums, 4);
    }
}