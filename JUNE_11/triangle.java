package JUNE_11;

import java.util.List;

// Approach: Use recursion to try both moves in the triangle.
// From each value, go down or down-right and take the smaller sum.
public class triangle {

    // This starts finding the minimum path from the top.
    public int minimumTotal(List<List<Integer>> triangle) {
        
       return  recur(0, 0, triangle);
        
    }
    // This returns the minimum path sum from position i, j.
    // Base case is the last row.
    public int recur(int i,int j,List<List<Integer>> triangle)
    {
        if(i==triangle.size()-1)
        {
            return triangle.get(i).get(j);
        }
        int d=recur(i+1,j,triangle);
        int r=recur(i+1,j+1,triangle);
        return triangle.get(i).get(j)+Math.min(d,r);
    }
    // This is empty now, but can be used to test triangle input.
    public static void main(String[] args) {
        
    }
}
