package JUNE_5;

public class UpperBound {
    public static int bruteforce(int[] arr,int tar){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > tar) {
                return i; // Return index of first element > x
            }
        }
        return arr.length;
    }
    public static int optimalSoluiton(int[] arr,int tar){
        int l=0,r=arr.length-1;
        int ans=arr.length;
        while(l<=r){
            int m=l+(r-l)/2;
            if(arr[m]>tar){
                ans=m;
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19}; // Sorted array
        int x = 9;
        System.out.println(bruteforce(arr, x));
        System.out.println(optimalSoluiton(arr, x));
    }
}
