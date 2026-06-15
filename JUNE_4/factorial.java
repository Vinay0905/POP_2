package JUNE_4;

// Approach: Use recursion to find factorial.
// Multiply n with factorial of n-1 until n becomes 0 or 1.
public class factorial {
    
    // This returns factorial of n.
    // Base case is 0 or 1, where answer is 1.
    public static int fact(int n){
        if(n==0 || n==1)return 1;
        
        return n*fact(n-1);
    }

    // This calls factorial for one sample number.
    public static void main(String[] args) {
        
        int n=5;
        System.out.println(fact(n));
    }

}
