package JUNE_9;

import java.util.ArrayList;
import java.util.List;

// Approach: Generate all subsets in two ways.
// One uses backtracking, and the other uses bit masks.
public class Subsets {
    

        // This builds subsets by choosing or skipping values from the start index.
        // It stores the current subset before trying more values.
        public static void solve(int[] nums,List<Integer> ans,List<List<Integer>> res,int start){
            res.add(new ArrayList<>(ans));
            for(int i=start;i<nums.length;i++){
                ans.add(nums[i]);
                solve(nums, ans, res, i+1);
                ans.remove(ans.size()-1);
            }
        }


        // This prepares lists and starts the backtracking method.
        public static List<List<Integer>> subsets(int[] nums) {
            

            List<List<Integer>> res=new ArrayList<>();
            List<Integer> ans=new ArrayList<>();
            solve(nums,ans,res,0);
            return res;
        }


    // This creates subsets using bits of numbers from 0 to 2^n - 1.
    // If a bit is set, that array value is included.
    public static List<List<Integer>> bitwiseSolution(int[] arr){
        List<List<Integer>> res=new ArrayList<>();
        int n=arr.length;
        for (int i = 0; i < (1 << n); i++) {
            
            List<Integer> ans=new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                ans.add(arr[j]);
            }
        }
        res.add(ans)        ;
        }
        return res;
    }
    // This prints subsets using both methods for a sample array.
    public static void main(String[] args) {
        
        int[] arr={1,2,3};
        List<List<Integer>> ans=subsets(arr);
        System.out.println(ans);
        System.out.println(bitwiseSolution(arr));















        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = i; j < arr.length; j++) {
        //         System.out.print("[");
        //         for (int k = i; k <= j; k++) {
        //             System.out.print(arr[k]);
        //             if (k < j) {
        //                 System.out.print(", ");
        //             }
        //         }
        //         System.out.println("]");
        //     }
        // }
    }
}
