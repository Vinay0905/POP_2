package JUNE_8;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    

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

    public static List<String> generateParenthesis(int n) {

        List<String> res=new ArrayList<>();
        // String[] map={"()"} ;
        int op=0,cl=0;
        String ans="";
        solve(n,op,cl,ans,res);


        return res;

    }

    public static void main(String[] args) {
        
        int n=3;
        System.out.println();
        System.out.println();
        System.out.println(generateParenthesis(n));
        System.out.println();
        System.out.println();

    }
}
