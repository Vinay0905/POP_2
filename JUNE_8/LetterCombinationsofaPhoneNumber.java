package JUNE_8;

import java.util.ArrayList;
import java.util.List;

// Approach: Use recursion with phone digit to letter mapping.
// For each digit, try every possible letter and build all combinations.
public class LetterCombinationsofaPhoneNumber {
    


    // This builds combinations one digit at a time.
    // When all digits are used, it saves the current string.
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

    // This handles empty input and starts the combination search.
    public static List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length()==0){
            return res;
        }
        solve(digits,res,map,"",0);

        return res;
        

        
    }
    // This tests letter combinations for sample digits.
    public static void main(String[] args) {
        String digits="23";

       List<String> ans= letterCombinations(digits);
       System.err.println(ans.toString());
    }
}
