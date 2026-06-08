package JUNE_8;

import java.util.Scanner;

public class AllPossibleGridPaths {
    

    public static void display(int[][] mat,int n,int m){
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                System.err.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void solve(int[][] mat,int row,int col,int end_row,int end_col){


        if(row==end_row-1 && col==end_col-1){
            display(mat,end_row,end_col);
            return ;
        }
        else{
            //right
            int next_row=row;
            int next_col=col+1;
            if(next_row<end_row&&next_col<end_col){
                mat[next_row][next_col]=1;
                solve(mat,next_row,next_col,end_row,end_col);

            }
            //down
            next_row=row+1;
            next_col=col;
            if(next_row<end_row&&next_col<end_col){
                mat[next_row][next_col]=1;
                solve(mat,next_row,next_col,end_row,end_col);

            }
        }


    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // int m=sc.nextInt();
        int n=3;
        int m=3;
        int[][] mat=new int[n][m];
        mat[0][0]=1;
        solve(mat, 0, 0, n, n);
        sc.close();



    }
}
