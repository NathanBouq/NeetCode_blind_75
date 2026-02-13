import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Binary {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(mid + " mid");
            if (nums[mid] < nums[high]) { // min is left
                high = mid;
            } else { // result is on right
                low = mid + 1;
            }
        }
        return nums[low];
    }

 static class Interval {
      public int start, end;
      public Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
  
   public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i-1).end > intervals.get(i).start) {
                return false;
            }
        }
        return true;
    }

static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        collect(root, list);
        System.out.println(list);        
        return list.get(k - 1);
    }
    public void collect(TreeNode node, List<Integer> list) {
        if (node == null) return;
        collect(node.left, list);
        list.add(node.val);
        collect(node.right, list);
    }



    public static void main(String[] args) {
        Binary binary = new Binary();
        int[] nums = {3, 4, 5, 1, 2};
        // System.out.println(binary.findMin(nums));
        Set<Integer> intervals = new HashSet<>();
        intervals.add(8);
        intervals.add(8);
        System.out.println(intervals.size());
        System.out.println(intervals);
        int r = binary.kthSmallest(new TreeNode(3, new TreeNode(1), new TreeNode(4)), 2);
        System.out.println(r);
    }
}
