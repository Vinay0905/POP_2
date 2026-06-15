package JUNE_4;

// Approach: Copy all non-zero values first, then fill remaining places with zero.
// This keeps the order of non-zero values same.
public class movezerostoEnd {
    
    // This moves all zero values to the end of the array.
    // It first stores non-zero values, then writes zeros after them.
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
    // This creates a sample array and prints it after moving zeros.
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
