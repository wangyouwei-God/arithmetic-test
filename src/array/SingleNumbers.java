package array;

import java.util.Arrays;

public class SingleNumbers {
    public static int[] singleNumbers(int[] nums) {
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        int[] res = new int[2];
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                i++;
            } else {
                res[j++] = nums[i - 1];
            }
        }
        if ( j-1 < res.length-1 ) {
            res[j] = nums[nums.length-1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 4, 6};
        int[] res = singleNumbers(nums);
        for( int num : res ) {
            System.out.println( num );
        }
    }
}
