package dynamicprogramming;

public class SortColors {
    public static void sortColors(int[] nums) {
        int pre = 0;
        for ( int i=0; i<nums.length; i++) {
            if ( nums[i] == 0 ) {
                swap(nums, pre, i);
                pre++;
            }
        }
        for ( int j=pre; j<nums.length; j++ ) {
            if ( nums[j] == 1 ) {
                swap( nums, pre, j);
                pre++;
            }
        }
    }
    private static void swap( int[] nums, int i, int j ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors( nums );
    }
}
