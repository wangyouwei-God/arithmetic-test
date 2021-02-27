package dynamicprogramming;

public class FindNumberIn2DArray {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for ( int i=0; i<m; i++) {
            int left = 0;
            int right = n-1;
            int mid = 0;
            while ( left <= right ) {
                mid = left + ( right - left )/2;
                if ( matrix[i][mid] == target ) {
                    return true;
                } else if ( matrix[i][mid] < target ) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println( findNumberIn2DArray(matrix, 5) );
        String a = new String();
    }
}
