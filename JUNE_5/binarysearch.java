package JUNE_5;

public class binarysearch {
    
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
