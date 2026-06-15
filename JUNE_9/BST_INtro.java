package JUNE_9;

// Approach: Build a Binary Search Tree where left values are smaller and right values are bigger.
// Use recursion for insert, search, traversal, delete, and validation.

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
    // This starts insertion from the root.
    public void insert(int val){
        root=insertNode(root,val);
    }


    // This inserts a value at the correct place in BST.
    // Smaller values go left and bigger values go right.
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
    // This starts searching from the root.
    boolean search(int val){
        return searchRec(root,val);
    }

    // This searches a value using BST rules.
    // It goes left or right based on comparison.
    boolean searchRec(Node root,int val){
        if(root==null){
            return false;

        }
        if(root.val==val)return true;
        if(val<root.val)return searchRec(root.left, val);
        else return searchRec(root.right, val);
    }

    //Inorder------------------------------------------------------------------------------------------------------------------------------
    // This starts inorder traversal from the root.
    void inorder(){
        inorderRec(root);
    }
    // This prints the tree in sorted order.
    // It visits left, root, then right.
    void inorderRec(Node root){
        if(root==null){
            return;
        }
        inorderRec(root.left);
        System.out.println(root.val+" ");
        inorderRec(root.right);
    }
    
    // This finds the largest value in the left subtree.
    private int inorderPre(Node temp){
        while(temp.right!=null){
            temp=temp.right;

        }
        return temp.val;
    }

    // This finds inorder predecessor for a given value.
    // It returns null if value or left subtree is missing.
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

    // This finds the smallest value in the right subtree.
    private int inorderSuc(Node temp){
        while(temp.left!=null){
            temp=temp.left;

        }
        return temp.val;
    }
    //Deletion---------------------------------------------------------------------------------------------------------
    // This starts deletion from the root.
    void delete(int val){
        root=deleteNode(root,val);

    }
    // This deletes a value from BST.
    // It handles leaf, one child, and two child cases.
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
    // This checks if the tree follows BST rules.
    public boolean isValidBST(Node root) {
        return isValid(root,null,null) ;
    }
    // This validates each node using min and max allowed limits.
    // Left side must stay smaller and right side must stay bigger.
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
    // This creates a sample BST and tests its main operations.
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
