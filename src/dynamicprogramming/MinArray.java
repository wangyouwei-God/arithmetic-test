package dynamicprogramming;

public class MinArray {
    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid = 0;
//        while (left < right) {
//            mid = left + (right - left) / 2;
//            if (numbers[left] < numbers[mid]) {
//                left = mid + 1;
//            } else if (numbers[left] > numbers[mid]) {
//                right = mid;
//            } else if (numbers[left] == numbers[mid]) {
//                right--;
//            }
//        }
        while ( left < right ) {
            mid = left + ( right - left )/2;
            if ( numbers[right] < numbers[mid] ) {
                left = mid+1;
            } else if ( numbers[right] > numbers[mid] ){
                right = mid;
            } else if ( numbers[right] == numbers[mid] ){
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println( minArray( nums) );
    }
}
