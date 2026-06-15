package JUNE_5;

// Approach: Use binary search to find where target should be placed.
// Return the first index where array value is greater than or equal to target.
public class searchInsertPosition {
    
    // This finds the insert position for target in a sorted array.
    // If target is found, it returns that index.
    public static int BruteANDOptimalApproch(int[] arr,int tar){
        int n=arr.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=tar)return mid;
            else if(arr[mid]<tar)l=mid+1;
            else r=mid-1;
        }
        return 0;
    }

    // This tests search insert position with a sample array.
    public static void main(String[] args) {
        int arr[] = {1,2,4,7}, x = 6;
        System.out.println(BruteANDOptimalApproch(arr,x));
    }
}
