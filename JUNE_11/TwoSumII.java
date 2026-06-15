package JUNE_11;

// Approach: Use two pointers because the array is sorted.
// Move left pointer for small sum and right pointer for big sum.
public class TwoSumII {


    // This returns 1-based indexes of two numbers that make target.
    // If no pair is found, it returns {-1, -1}.
    public static int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int s=0,e=n-1;
        while(s<e){
            if(numbers[s]+numbers[e]==target)return new int[]{s+1,e+1};
            if(numbers[s]+numbers[e]<target)s++;
            if(numbers[s]+numbers[e]>target)e--;
        }
        return new int[]{-1,-1};
    }
    // This tests two sum with one sorted array.
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(numbers,target));
    }

}
