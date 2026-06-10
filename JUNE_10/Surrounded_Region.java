package JUNE_10;

import java.util.LinkedList;
import java.util.Queue;

public class Surrounded_Region {
    public static void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        Queue<int[]> q=new LinkedList<>();
        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') {

                q.offer(new int[]{i, 0});

            }

            if (board[i][n - 1] == 'O') {

                q.offer(new int[]{i, n - 1});

            }

        }

        for (int j = 0; j < n; j++) {

            if (board[0][j] == 'O') {

                q.offer(new int[]{0, j});

            }

            if (board[m - 1][j] == 'O') {

                q.offer(new int[]{m - 1, j});

            }

        }
        int[] dr = {-1, 1, 0, 0};

        int[] dc = {0, 0, -1, 1};

        while(q.isEmpty()==false){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            if(r<0 || r>=m || c<0 || c>=n || board[r][c]!='O'){
                continue;
            }
            board[r][c]='S';
            for(int k=0;k<4;k++){
                q.offer(new int[]{r+dr[k],c+dc[k]});
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='S')board[i][j]='O';
            }
        }

    }
    public static void main(String[] args) {

        char[][] board = {

            {'X','X','X','X'},

            {'X','O','O','X'},

            {'X','X','O','X'},

            {'X','O','X','X'}

        };

        

        solve(board);

        for (char[] row : board) {

            for (char ch : row) {

                System.out.print(ch + " ");

            }

            System.out.println();

        }

    }
}
