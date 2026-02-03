import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Backtracking {
 
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] nums, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, target - nums[i], i, current, result);
            current.remove(current.size() - 1); //
            System.out.println(current);
        }
    }

    public static void main(String[] args) {
        Backtracking backtracking = new Backtracking();
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = backtracking.combinationSum(nums, target);
        //System.out.println(combinations);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.println(set.toArray()[1]);
    }
}