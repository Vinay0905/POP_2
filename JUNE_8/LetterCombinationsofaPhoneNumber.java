package JUNE_8;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    


    public static void solve(String digits,List<String> res,String[] map,String ans,int i){

        if(i==digits.length()){
            res.add(ans);
            return ;

        }
        else{
            String temp=map[digits.charAt(i )-'0'];//temp=abc
            for(int j=0;j<temp.length();j++){
                solve(digits, res, map, ans+temp.charAt(j), i+1);
                
            }
            
        }

    }

    public static List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length()==0){
            return res;
        }
        solve(digits,res,map,"",0);

        return res;
        

        
    }
    public static void main(String[] args) {
        String digits="23";

       List<String> ans= letterCombinations(digits);
       System.err.println(ans.toString());
    }
}
