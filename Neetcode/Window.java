import java.util.HashSet;
import java.util.Set;


public class Window {
        
    public int lengthOfLongestSubstring(String s) {
        Set<Character> map = new HashSet<>();
        int l = 0, r = 0, maxLen = 0;
        while (r < s.length()) {
            if (!map.contains(s.charAt((r)))) {
                map.add(s.charAt(r));
                r++;
                maxLen = Math.max(maxLen, r - l);
            } else {
                map.remove(s.charAt(l));
                l++;
            }
            System.out.println("MaxLen: " + maxLen + " for r: " + r + " l: " + l);
            System.out.println(map);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        Window window = new Window();
        String s = "abcabcbb";
        System.out.println(window.lengthOfLongestSubstring(s));
        
    }
}
