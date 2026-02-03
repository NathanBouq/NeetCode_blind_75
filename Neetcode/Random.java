
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public String encode(List<String> strs) {
        String r = ""; 
        for (String s: strs) {
            r += s + " ";
        }
        return r;
    }

    public List<String> decode(String str) {
        List<String> map = new ArrayList<>(Arrays.asList(str.split(" ")));
        return map;
    }
}
