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
    //Insert---------------------------------------------------------------------------------------------------------
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


    

    //Search---------------------------------------------------------------------------------------------------------
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

    //Inorder------------------------------------------------------------------------------------------------------------------------------
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
    
    private int inorderPre(Node temp){
        while(temp.right!=null){
            temp=temp.right;

        }
        return temp.val;
    }

    public Integer getInorderPre(int val){
        Node curr=root;
        while(curr!=null && curr.val!=val){
            if(val<curr.val){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        if(curr==null || curr.left==null){
            return null;
        }
        return inorderPre(curr.left);
    }

    private int inorderSuc(Node temp){
        while(temp.left!=null){
            temp=temp.left;

        }
        return temp.val;
    }
    //Deletion---------------------------------------------------------------------------------------------------------
    void delete(int val){
        root=deleteNode(root,val);

    }
    Node deleteNode(Node root, int val){
        if(root==null)return null;
        if(val<root.val)root.left=deleteNode(root.left, val);
        else if(val>root.val)root.right=deleteNode(root.right, val);
        else{
            //3 types :- 
                // 1) left side no child 
                // 2) right side no child 
                // 3) 2 child.
            if(root.left==null )return root.right;
            if (root.right==null)return root.left;
            //changes the curr val with the inordersuccessor value
            root.val=inorderSuc(root.right);
            // now the inorderSucc value is deleted.
            root.right=deleteNode(root.right, root.val);
        }
        return root;

    }
    
    //Validation------------------------------------------------------------------------------------------------------------------------------
    public boolean isValidBST(Node root) {
        return isValid(root,null,null) ;
    }
    public boolean isValid(Node root,Integer min, Integer max){

        if(root==null){
            return true;
        }
        else if(min!=null && root.val<=min){
            return false;
        }
        else if (max!=null &&root.val>=max){
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }



}


public class BST_INtro {
    public static void main(String[] args) {
        BST tree=new BST();

        System.out.println("Inserting values...");
        int[] values = {100, 50, 200, 25, 75, 150, 250, 60, 80};

        for (int val : values) {
            tree.insert(val);
        }

        System.out.println("\nInorder traversal after insertion:");
        tree.inorder();

        System.out.println("\nSearching values:");
        System.out.println("Search 75: " + tree.search(75));
        System.out.println("Search 999: " + tree.search(999));
        System.out.println("Search 100: " + tree.search(100));

        System.out.println("\nChecking if tree is valid BST:");
        System.out.println(tree.isValidBST(tree.root));

        System.out.println("\nChecking inorder predecessor:");
        System.out.println("Inorder predecessor of 100: " + tree.getInorderPre(100));
        System.out.println("Inorder predecessor of 75: " + tree.getInorderPre(75));
        System.out.println("Inorder predecessor of 25: " + tree.getInorderPre(25));
        System.out.println("Inorder predecessor of 999: " + tree.getInorderPre(999));

        System.out.println("\nDeleting leaf node 25...");
        tree.delete(25);
        tree.inorder();
        System.out.println("Valid BST: " + tree.isValidBST(tree.root));

        System.out.println("\nDeleting node with one child 75...");
        tree.delete(75);
        tree.inorder();
        System.out.println("Valid BST: " + tree.isValidBST(tree.root));

        System.out.println("\nDeleting node with two children 100...");
        tree.delete(100);
        tree.inorder();
        System.out.println("Valid BST: " + tree.isValidBST(tree.root));

        System.out.println("\nDeleting value not present 999...");
        tree.delete(999);
        tree.inorder();
        System.out.println("Valid BST: " + tree.isValidBST(tree.root));

    }
}
