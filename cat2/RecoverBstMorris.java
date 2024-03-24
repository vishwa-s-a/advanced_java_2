/**
 * this is the second method of recovering bst using morris traversal method
 * time complexity: O(n)
 * space complexity: O(1) this is the speciality here
 * uses the threaded binary tree concept
 */
import java.util.ArrayList;
import java.util.List;
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
public class RecoverBstMorris{

    public static TreeNode firstIncorrectNode=null;
    public static TreeNode secondIncorrectNode=null;
    public static TreeNode temp=null;

    //this is the normal inorder traversal which uses recursive calls and space complexity would be O(n)
    public static void printInorder(TreeNode node){
        if(node==null){
            return;
        }
        printInorder(node.left);
        System.out.print(node.val+" ");
        printInorder(node.right);
    }

    //now this morris traversal method on bst which gives us the space complexity of O(1)
    public static void morrisTraversal1(TreeNode node){
        //here in this method we are doing the inorder traversal of the tree
        TreeNode cur=node;
        TreeNode prev=null;
        while(cur!=null){
            if(cur.left==null){
                //inorder.add(cur.val);
                if(prev!=null && prev.val>cur.val){
                    if(firstIncorrectNode==null){
                        firstIncorrectNode=prev;
                    }
                    secondIncorrectNode=cur;
                }
                prev=cur;
                cur=cur.right;
            }
            else{
                temp=cur.left;
                while(temp.right!=null && temp.right!=cur){
                    temp=temp.right;
                }
                if(temp.right==null){
                    temp.right=cur;
                    cur=cur.left;
                }
                else{
                    prev.right=null;
                    //inorder.add(cur.val);
                    if(prev!=null && prev.val>cur.val){
                        if(firstIncorrectNode==null){
                            firstIncorrectNode=prev;
                        }
                        secondIncorrectNode=cur;
                    }
                    prev=cur;
                    cur=cur.right;
                }
            }
        }
    }

    public static void recoverBST(TreeNode node){
        morrisTraversal1(node);
        if(firstIncorrectNode!=null && secondIncorrectNode!=null){
            int temp=firstIncorrectNode.val;
            firstIncorrectNode.val=secondIncorrectNode.val;
            secondIncorrectNode.val=temp;

        }
    }

    public static void main(String args[])
    {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(2);
        System.out.println("The given BST is : ");
        printInorder(root);
        morrisTraversal1(root);
        recoverBST(root);
        System.out.println("\nThe recovered BST is : ");
        printInorder(root);
        System.out.println(' ');

    }
}