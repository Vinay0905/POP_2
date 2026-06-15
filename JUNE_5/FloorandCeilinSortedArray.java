package JUNE_5;

// Approach: Use binary search because the array is sorted.
// Find floor and ceil separately, then return both values.
public class FloorandCeilinSortedArray {
    
     // This finds the largest value which is less than or equal to x.
     // If no such value exists, it returns -1.
     public static int findFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) {
                ans = arr[mid];     // Potential floor
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // This finds the smallest value which is greater than or equal to x.
    // If no such value exists, it returns -1.
    public static int findCeil(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = arr[mid];     // Potential ceil
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // This calls floor and ceil functions and returns both answers.
    public static int[] getFloorAndCeil(int[] arr, int x) {
        int f = findFloor(arr, x);
        int c = findCeil(arr, x);
        return new int[]{f, c};
    }
    // This tests floor and ceil on one sorted array.
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int x = 5;
        getFloorAndCeil(arr,x);   
    }
}
