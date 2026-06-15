package JUNE_15;

// Approach: Use backtracking to fill the rectangle with squares.
// Always pick the first empty cell and try the biggest square first.
public class TilingArectanlgewithsquares {
        
    static int ans=0;
    // This creates the rectangle grid and starts the search.
    // It returns the minimum number of squares needed.
    public static int tilingRectangle(int n, int m) {
        int[][] rectangle=new int[n][m];
        ans=Integer.MAX_VALUE;
        solve(rectangle,0,n,m);
        return ans;
    }

    // This checks if a k by k square can fit at x, y.
    // It must stay inside the rectangle and use only empty cells.
    public static boolean canPlace(int[][] rec,int x,int y,int k,int n,int m){
        for(int i=x;i<x+k;i++){
            for(int j=y;j<y+k;j++){
                if(i>=n || j>=m || rec[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
    }

    // This fills or clears a k by k square.
    // val is 1 for placing and 0 for removing.
    public static void place(int[][] rect,int x,int y,int k,int val){
        int i,j;
        for(i=x;i<x+k;i++){
            for(j=y;j<y+k;j++){
                rect[i][j]=val;
            }
        }
    }
    // This tries all square placements using backtracking.
    // It stops early when current count is already worse than answer.
    public static void solve(int[][] rect,int c,int n,int m){
        if(c>=ans){
            return;
        }
        int x=-1,y=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rect[i][j]==0){
                    x=i;
                    y=j;
                    break;
                }
            }
            if(x!=-1){
                break;
            }
        }
        if(x==-1){
            ans=Math.min(ans,c);
            return;
        }
        for(int k=Math.min(n-x,m-y);k>=1;k--){
            if(canPlace(rect,x,y,k,n,m)){
                place(rect,x,y,k,1);
                solve(rect, c+1, n, m);
                place(rect,x,y,k,0);
            }
        }
    }
    // This tests rectangle tiling for one sample size.
    public static void main(String[] args) {
        

        int n=5,m=8;
        System.out.println(tilingRectangle(n,m));;

        
        
    }
}
