package dynamicprogramming;

public class SecondExchange {
    public static int[] exchange(int[] nums) {
        int fast = 0, slow = 0;
        while ( fast < nums.length ) {
            if ( (nums[fast] & 1) == 1 ) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 8, 9, 7, 3};
        exchange( nums );
    }
}
