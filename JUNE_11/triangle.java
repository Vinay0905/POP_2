package JUNE_11;

import java.util.List;

public class triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        
       return  recur(0, 0, triangle);
        
    }
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
    public static void main(String[] args) {
        
    }
}
