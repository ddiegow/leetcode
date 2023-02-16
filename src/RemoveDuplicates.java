import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int count = 1;
        for (int i = 0, j = 0; j < nums.length - 1; j++) {
            if (nums[i] != nums[j + 1]) {
                swap(nums, i + 1, j + 1);
                i++;
                count++;
            }

        }
        return count;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int nums[] = new int[] {1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 7};
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
        nums = new int[] {1, 1, 2};
        System.out.println(rd.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
        nums = new int[] {1};
        System.out.println(rd.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
        nums = new int[] {};
        System.out.println(rd.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }
}
