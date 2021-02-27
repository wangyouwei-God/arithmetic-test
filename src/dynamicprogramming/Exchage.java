package dynamicprogramming;

public class Exchage{
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while ( left < right ) {
            while ( left < right && nums[left] % 2 == 1 ) {
                left++;
            }
            while ( right > left && nums[right] % 2 == 0 ) {
                right--;
            }
            if ( left < right ) {
                swap(nums, left, right);
            }
        }
        return nums;
    }
    private static void swap( int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5};
        System.out.println( exchange( nums ) );
    }
}
