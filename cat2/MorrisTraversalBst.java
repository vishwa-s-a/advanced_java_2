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
public class MorrisTraversalBst{

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
    public static List<Integer> morrisTraversal1(TreeNode node){
        //here in this method we are doing the inorder traversal of the tree
        List<Integer>inorder=new ArrayList<>();
        TreeNode cur=node;
        while(cur!=null){
            if(cur.left==null){
                inorder.add(cur.val);
                cur=cur.right;
            }
            else{
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }
                else{
                    prev.right=null;
                    inorder.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return inorder;
    }

    public static List<Integer> morrisTraversal2(TreeNode node){
        //here in this method we are doing the inorder traversal of the tree
        List<Integer>preorder=new ArrayList<>();
        TreeNode cur=node;
        while(cur!=null){
            if(cur.left==null){
                preorder.add(cur.val);
                cur=cur.right;
            }
            else{
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    preorder.add(cur.val);
                    cur=cur.left;
                }
                else{
                    prev.right=null;
                    cur=cur.right;
                }
            }
        }
        return preorder;
    }

    public static void main(String args[])
    {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(2);
        System.out.println("The given BST is : ");
        printInorder(root);
        System.out.println("\nThe inorder of BST using Morris Traversal: ");
        List<Integer>result=morrisTraversal1(root);
        for(Integer i: result){
            System.out.print(i+" ");
        }
        System.out.println("\nThe preorder of BST using Morris Traversal: ");
        result=morrisTraversal2(root);
        for(Integer i: result){
            System.out.print(i+" ");
        }

    }
}