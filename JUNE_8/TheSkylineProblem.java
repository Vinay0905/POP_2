package JUNE_8;

import java.util.ArrayList;
import java.util.List;

public class TheSkylineProblem {
    

    public static List<int[]> merge(List<int[]> left, List<int[]> right) {
        List<int[]> res = new ArrayList<>();

        int i = 0, j = 0;
        int h1 = 0, h2 = 0;

        while (i < left.size() && j < right.size()) {
            int x;

            if (left.get(i)[0] < right.get(j)[0]) {
                x = left.get(i)[0];
                h1 = left.get(i)[1];
                i++;
            } else if (left.get(i)[0] > right.get(j)[0]) {
                x = right.get(j)[0];
                h2 = right.get(j)[1];
                j++;
            } else {
                x = left.get(i)[0];
                h1 = left.get(i)[1];
                h2 = right.get(j)[1];
                i++;
                j++;
            }

            int maxH = Math.max(h1, h2);

            if (res.isEmpty() || res.get(res.size() - 1)[1] != maxH) {
                res.add(new int[]{x, maxH});
            }
        }

        while (i < left.size()) {
            int[] point = left.get(i++);
            if (res.isEmpty() || res.get(res.size() - 1)[1] != point[1]) {
                res.add(point);
            }
        }

        while (j < right.size()) {
            int[] point = right.get(j++);
            if (res.isEmpty() || res.get(res.size() - 1)[1] != point[1]) {
                res.add(point);
            }
        }

        return res;
    }

    public static List<int[]> build(int[][] buildings , int start,int end ){
        if(start>end){
            return new ArrayList<>();

        }
        if(start==end){
            List<int[]> res=new ArrayList<>();

            res.add(new int []{buildings[start][0],buildings[start][2]});
            res.add(new int []{buildings[start][1],0});
            return res;

        }
        int mid=(start+end)/2;
        List<int[]> left=build(buildings, start, mid);
        List<int[]> right=build(buildings, mid+1, end);
        return merge(left, right);
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        int n=buildings.length;
        if(n==0){
            return new ArrayList<>();

        }
        List<int[]> pairs=build(buildings,0,n-1);
        List<List<Integer>> ans=new ArrayList<>();

        for(int[] pair:pairs){
            List<Integer> point=new ArrayList<>();
            point.add(pair[0]);
            point.add(pair[1]);
            ans.add(point);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};

        System.out.println(getSkyline(buildings));


    }
}
