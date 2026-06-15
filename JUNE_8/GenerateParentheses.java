package JUNE_8;

import java.util.ArrayList;
import java.util.List;

// Approach: Use backtracking to build valid parentheses.
// Add '(' when possible and add ')' only when it will stay valid.
public class GenerateParentheses {
    

    // This builds all valid strings using open and close counts.
    // When both counts become n, it stores the answer.
    public static void solve(int n,int op,int cl, String ans,List<String> res){

        if(op==n && cl==n){
            res.add(ans);
            return ;

        }
        else{
            if(op<n){
                solve(n,op+1,cl,ans+"(",res);
            }
            if(op>cl){
                solve(n,op,cl+1,ans+")",res);
            }
        }

    }

    // This prepares the result list and starts the recursion.
    public static List<String> generateParenthesis(int n) {

        List<String> res=new ArrayList<>();
        // String[] map={"()"} ;
        int op=0,cl=0;
        String ans="";
        solve(n,op,cl,ans,res);


        return res;

    }

    // This prints all valid parentheses for one sample n.
    public static void main(String[] args) {
        
        int n=3;
        System.out.println();
        System.out.println();
        System.out.println(generateParenthesis(n));
        System.out.println();
        System.out.println();

    }
}
