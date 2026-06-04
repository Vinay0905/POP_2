package JUNE_4;

public class movezerostoEnd {
    
    public static void move(int[] arr,int zeros){
        int n=arr.length;
        int[] ne=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                ne[cnt]=arr[i];
                cnt++;
            }
        }
        for(int i=0;i<cnt;i++){
            arr[i]=ne[i];

        }
        for(int i=cnt;i<n;i++){
            arr[i]=0;
        }
    }
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        int totalNonZeros=0;
        for(int i:nums){
            if(i!=0)totalNonZeros++;
        }
        move(nums, totalNonZeros);
        for(int i:nums){
            System.err.println(i);
        }

    }
}
