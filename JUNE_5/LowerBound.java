package JUNE_5;

public class LowerBound {
    
    public static int bruteforce(int[] arr,int tar){
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=tar){
                return i;
            }
        }
        return arr.length;
    }
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
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int ta=9;

        System.out.println(bruteforce(arr, ta));
        System.out.println(optimalWay(arr,ta));
    }
}
