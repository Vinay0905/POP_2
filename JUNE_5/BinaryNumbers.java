package JUNE_5;

// Approach: Use recursion to build every binary string.
// At each step add 0 and 1 until the string length becomes n.
public class BinaryNumbers {
    
    // This prints all binary strings of length n.
    // It stops when the current string reaches length n.
    public static void binary(String s,int n){
        if(s.length()==n){
            System.out.println(s);
            return ;
        }
        binary(s+"0", n);
        binary(s+"1", n);
    }
    // This starts the binary generation for a sample length.
    public static void main(String[] args) {
        
        String s="";int x=2;
        binary(s, x);
        
    }
}
