package JUNE_5;

// Approach: Use binary search on a sorted array.
// Check the middle value and remove half of the search range each time.
public class binarysearch {
    
    // This returns true if target is found in the sorted array.
    // Otherwise it returns false after the search range ends.
    public static boolean binarySearch(int[] arr,int tar){
        int n=arr.length;
        int l=0,r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(arr[m]==tar)return true;
            else if(arr[m]<tar)l=m+1;
            else r=m-1;

        }
        return false;
        
    }

    // This tests binary search with one sample target.
    public static void main(String[] args) {
        int[] arr={1,3,4,6,7,8};
        int t=7;
        if(binarySearch(arr,t)){
            System.out.println("yes element found");

        }
        else{
            System.out.println("No element not found");
        }
    }
}
