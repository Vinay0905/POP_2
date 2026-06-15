package JUNE_4;

// Approach: Use two pointers, one from start and one from end.
// Compare both characters and move inward until they meet.
public class StringPalindrome {
    
    // This checks if the string reads the same from both sides.
    // If any pair of characters is different, it returns false.
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
    // This tests the palindrome function with one sample string.
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
