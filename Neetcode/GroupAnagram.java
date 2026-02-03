import java.util.*;

class GroupAnagrams {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

    /* Runtime efficiency: O(n) based on the sorting of the sorted char array
    /* Space efficiency: O(1) since the char array is is equal to the string length
     */
    boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        chars = t.toCharArray();
        Arrays.sort(chars);
        String sorted2 = new String(chars);
        return sorted.equals(sorted2);
    }

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
        System.out.println(sol.isAnagram("bbcc", "ccbc"));
        char[] arr = {'c', 'b', 'a'};
        arr['b' - 'a']++;
        for (char c : arr) {
            System.out.println(c);
        }
    }

}
