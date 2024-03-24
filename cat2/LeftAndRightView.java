import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val){
        this.val=val;
        left=null;
        right=null;
    }
}
public class LeftAndRightView{

    public static List<Character> leftView(TreeNode root){
        List<Character> left=new ArrayList<>();
        if(root == null){
            return left;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for (int i=0;i<levelSize;i++)
            {
                TreeNode temp=queue.poll();
                if(i==0){
                    left.add(temp.val);
                }

                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }
        return left;
    }

    public static List<Character> rightView(TreeNode root){
        List<Character> right=new ArrayList<>();
        if(root == null){
            return right;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for (int i=0;i<levelSize;i++)
            {
                TreeNode temp=queue.poll();
                if(i==levelSize-1){
                    right.add(temp.val);
                }

                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }
        return right;
    }


    public static void main(String args[]){
        TreeNode root=new TreeNode('A');
        root.left=new TreeNode('B');
        root.right=new TreeNode('C');
        root.left.left=new TreeNode('D');
        root.left.right=new TreeNode('E');
        root.left.right.left=new TreeNode('F');
        root.left.right.right=new TreeNode('G');
        root.left.right.left.left=new TreeNode('Z');
        root.right.left=new TreeNode('H');
        root.right.right= new TreeNode('I');

        List<Character> left=leftView(root);
        System.out.println("The left view of the tree is: ");
        for(char i: left){
            System.out.print(i+" ");
        }
        System.out.println("\nThe right view of the tree is: ");
        List<Character>right=rightView(root);
        for(char i: right){
            System.out.print(i+" ");
        }
        System.out.println(" ");
    }
}