package JUNE_5;

import java.util.ArrayList;

public class NQueens {


    public static int isSafe(int[][] mat,int row,int col){
        int n=mat.length;
        int i,j;
        for(i=0;i<row;i++){
            if(mat[i][col]==1)return 0;
        }
        for(i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(mat[i][j]==1)return 0;
        }
        for (i = row - 1, j = col + 1; j < n && i >= 0; i--, j++)
            if (mat[i][j] == 1)
                return 0;

        return 1;
    }

    public static void placeQueens(int row,int[][] mat,ArrayList<ArrayList<Integer>> res){
        int n=mat.length;
        if(row==n){
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        ans.add(j + 1);
                    }
                }
            }
            res.add(ans);
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(mat,row,i)==1){
                mat[row][i]=1;
                placeQueens(row+1, mat, res);

                mat[row][i]=0;
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> nQueen(int n){

        int [][] mat=new int[n][n];
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        placeQueens(0, mat, res);
        return res;
    }
    public static void main(String[] args) {
        
        int n=4;
        ArrayList<ArrayList<Integer>> result = nQueen(n);
        for (ArrayList<Integer> ans : result) {
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
