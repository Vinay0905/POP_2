package JUNE_9;



class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }

}

class BST{
    Node root;
    BST(){
        root=null;
    }
    
    public void insert(int val){
        root=insertNode(root,val);
    }
    // public Node insertNode(Node root,int val){

    // }


}



public class BST_Practice {
    
}
