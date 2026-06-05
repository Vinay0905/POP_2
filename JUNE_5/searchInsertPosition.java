package JUNE_5;

public class searchInsertPosition {
    
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

    public static void main(String[] args) {
        int arr[] = {1,2,4,7}, x = 6;
        System.out.println(BruteANDOptimalApproch(arr,x));
    }
}
