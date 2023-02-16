import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hm.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {
            4, 5, 7, 1, 2, 4
        };
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicate(numbers));
    }
}
