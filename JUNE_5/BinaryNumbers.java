package JUNE_5;

public class BinaryNumbers {
    
    public static void binary(String s,int n){
        if(s.length()==n){
            System.out.println(s);
            return ;
        }
        binary(s+"0", n);
        binary(s+"1", n);
    }
    public static void main(String[] args) {
        
        String s="";int x=2;
        binary(s, x);
        
    }
}
