package JUNE_4;

// Approach: Use binary search on a sorted array.
// Keep cutting the search area into half until target is found or range ends.
public class binarysearch {
    
    // This checks if target is present in the sorted array.
    // It moves left or right based on the middle value.
    public static boolean search(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // This creates a sample array and prints if target is found.
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14};
        int target = 10;

        if (search(arr, target)) {
            System.out.println(target + " found in the array.");
        } else {
            System.out.println(target + " not found in the array.");
        }
    }
}
