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


    public Node insertNode(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if(val<root.val){
            root.left=insertNode(root.left, val);
        }
        else if(val>root.val){
            root.right=insertNode(root.right, val);
        }
        return root;
    }

    
    boolean search(int val){
        return searchRec(root,val);
    }

    boolean searchRec(Node root,int val){
        if(root==null){
            return false;

        }
        if(root.val==val)return true;
        if(val<root.val)return searchRec(root.left, val);
        else return searchRec(root.right, val);
    }
    void inorder(){
        inorderRec(root);
    }
    void inorderRec(Node root){
        if(root==null){
            return;
        }
        inorderRec(root.left);
        System.out.println(root.val+" ");
        inorderRec(root.right);
    }

}


public class BST_INtro {
    public static void main(String[] args) {
        BST tree=new BST();
        tree.insert(100);
        tree.insert(200);
        tree.insert(98);
        tree.insert(32);

    }
}
