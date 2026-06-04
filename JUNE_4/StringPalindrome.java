package JUNE_4;

public class StringPalindrome {
    
    public static boolean palindrome(String s){
        if (s==null)return false;

        int start=0,end=s.length()-1;

        while(start<end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;

    }
    public static void main(String[] args) {
        String s="racecar";
        if(palindrome(s)){
            System.out.println("yes its a Pallindrome");
        }
        else{
            System.out.println("no its not a Pallindrome");
        }
    }
}
