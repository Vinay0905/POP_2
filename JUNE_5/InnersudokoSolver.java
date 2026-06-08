package JUNE_5;

public class InnersudokoSolver {

    static int N=9;
    // Checks whether placing number 'c' at (row, col) follows Sudoku rules
    // public static boolean isValid(int[][] board,int row,int col,int c){
    public static boolean isValid(char[][] board,int row,int col,char c){
        // Check whether the number already exists in the same column
        for(int i=0;i<N;i++){
            if(board[i][col]==c){
                return false;
            }
        }
        // Check whether the number already exists in the same row
        for(int i=0;i<N;i++){
            if(board[row][i]==c){
                return false;
            }
        }

        // Check the corresponding 3x3 sub-grid for duplicates

        // Find the top-left corner of the 3x3 box containing (row, col)
        int startrow=(row/3)*3;
        int startcol=(col/3)*3;
        for(int i=startrow;i<startrow+3;i++){
            for(int j=startcol;j<startcol+3;j++){
                if(board[i][j]==c){
                    return false;
                }
            }
        }

        return true;
    }
    // Solves the Sudoku using Backtracking
    // Returns true when a valid solution is found
    // public static boolean SolveSudoko(int board[][]){
    public static boolean SolveSudoko(char[][] board){
        // Traverse every cell to find the next empty position (0)
        for(int i=0;i<N;i++)
            {
            for(int j=0;j<N;j++)
                {

                // If an empty cell is found, try placing numbers 1 to 9
                if(board[i][j]=='.')
                    {
                    for(char c='1';c<='9';c++ )
                        {
                        if(isValid(board,i,j,c))
                            {
                            // Place the candidate number temporarily
                            board[i][j]=c;
                            // Recursively attempt to solve the remaining board
                            if(SolveSudoko(board)){
                                return true;

                            }
                            // Backtrack: undo the choice if it leads to no solution
                            board[i][j]='.';

                        }   
                    }
                    // No valid number fits here, trigger backtracking
                    return false;
                }
            }
        }
        // No empty cells left, Sudoku is solved
        return true;
    }
    // Displays the solved Sudoku board
    public static void printBoard(char[][] board) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            System.out.print(board[i][j] + " ");
        }
        System.out.println();
    }
}
    public static void main(String[] args) {
        // Sample Sudoku puzzle where 0 represents an empty cell
        // Scanner sc=new Scanner(System.in);
        // int board[][] = {
        //     {5,3,0,0,7,0,0,0,0},
        //     {6,0,0,1,9,5,0,0,0},
        //     {0,9,8,0,0,0,0,6,0},
        //     {8,0,0,0,6,0,0,0,3},
        //     {4,0,0,8,0,3,0,0,1},
        //     {7,0,0,0,2,0,0,0,6},
        //     {0,6,0,0,0,0,2,8,0},
        //     {0,0,0,4,1,9,0,0,5},
        //     {0,0,0,0,8,0,0,7,9}
        // };
        char[][] board_1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        if(SolveSudoko(board_1)){
            printBoard(board_1);
        }
        else{
            System.out.println("NO BOARD ");
        }
    }   
    
}
