import java.lang.reflect.Array;
import java.util.*;

class GroupAnagrams {

    private List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);
            System.out.println("Sorted String: " + sortedStr);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
                // add strs to the arraylist
                map.get(sortedStr).add(s);
            }
            map.get(sortedStr).add(s);
        }
        return new ArrayList<>(map.values());        
    }

    // Palindrome check ignoring non-alphanumeric characters and case
    private boolean isPalindrome2(String s) {
       s = s.toLowerCase();
       
       // Use two pointers: one from start, one from end
       int left = 0;
       int right = s.length() - 1;
       while (left < right) {
           // Skip non-alphanumeric characters from left
           while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
               left++;
           }
           // Skip non-alphanumeric characters from right
           while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
               right--;
           }
           if (s.charAt(left) != s.charAt(right)) {
               return false;
           }
           left++; right--;
        }
        return true;
    }

public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> s = new ArrayList<>();
        if (nums.length < 3) return s;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                System.out.println("Sum: " + sum + " for i: " + i + " left: " + left + " right: " + right);
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(nums[i]);   
                    a.add(nums[left]);
                    a.add(nums[right]);     
                    s.add(a);
                    
                    // Skip duplicates before moving pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return s;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // System.out.println(sol.groupAnagrams(strs)); 
        // System.out.println(sol.isPalindrome2("Was it a car or a cat I saw?"));
        System.out.println(sol.threeSum(new int[] {1,-1,-1,0}));
        System.out.println(sol.twoSum(new int[] {2,7,11,15}, 9));
    }

}
