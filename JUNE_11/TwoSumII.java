package JUNE_11;

public class TwoSumII {


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
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(numbers,target));
    }

}
