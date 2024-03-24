/**
 * here the time complexity is O(n) where n is the number of nodes in tree
 * space complexity is O(1) if space for recursive calls is not considered here or else it is O(n)
 * if space for recursive call stack is considered then it cannot be O(1) then we have to use Morris traversal method
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
public class RecoverBst{
    static TreeNode firstIncorrectNode=null;
    static TreeNode secondIncorrectNode=null;
    static TreeNode middleIncorrectNode=null;
    static TreeNode prevNode=new TreeNode(Integer.MIN_VALUE);

    public static void printInorder(TreeNode node){
        if(node==null){
            return;
        }
        printInorder(node.left);
        System.out.print(node.val+" ");
        printInorder(node.right);
    }

    public static void inorder(TreeNode node){
        if(node==null){
            return;
        }
        inorder(node.left);
        if(prevNode!=null && (node.val<prevNode.val)){
            if(firstIncorrectNode==null){
                firstIncorrectNode=prevNode;
                middleIncorrectNode=node;
            }
            else{
                secondIncorrectNode=node;
            }
        }
        prevNode=node;
        inorder(node.right);
    }

    public static void recoverTree(TreeNode node){
        inorder(node);

        if(firstIncorrectNode!=null && secondIncorrectNode!=null){
            // System.out.print(firstIncorrectNode.val+secondIncorrectNode.val);
            int temp=firstIncorrectNode.val;
            firstIncorrectNode.val=secondIncorrectNode.val;
            secondIncorrectNode.val=temp;
        }
        else{
            // System.out.print(firstIncorrectNode.val+middleIncorrectNode.val);
            int temp=firstIncorrectNode.val;
            firstIncorrectNode.val=middleIncorrectNode.val;
            middleIncorrectNode.val=temp;
        }
        
    }
    public static void main(String args[]){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(2);
        System.out.println("The given BST is : ");
        printInorder(root);
        recoverTree(root);
        System.out.println("\nThe recovered BST is : ");
        printInorder(root);
        System.out.println('\r');
    }
}