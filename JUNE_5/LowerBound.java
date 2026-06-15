package JUNE_5;

// Approach: Lower bound means first index where value is greater than or equal to target.
// One method checks linearly, and the other uses binary search.
public class LowerBound {
    
    // This finds lower bound by checking every value from left to right.
    // It returns array length if no value is big enough.
    public static int bruteforce(int[] arr,int tar){
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=tar){
                return i;
            }
        }
        return arr.length;
    }
    // This finds lower bound using binary search.
    // It keeps the best index and searches more on the left side.
    public static int optimalWay(int[] arr,int tar){
        int l=0,r=arr.length-1;
        int ans=arr.length;
        while(l<=r){
            int m=l+(r-l)/2;

            if(arr[m]>=tar){
                ans=m;
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return ans;

    }
    // This compares brute force and binary search answers.
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int ta=9;

        System.out.println(bruteforce(arr, ta));
        System.out.println(optimalWay(arr,ta));
    }
}
