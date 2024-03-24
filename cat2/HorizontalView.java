import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

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

public class HorizontalView{

    // //this function was written by me and its 90% correct
    // public static void horizontalPrint(TreeNode node){
    //     if(node ==null){
    //         return;
    //     }
    //     // System.out.print(node.val+" ");
    //     if(node.left!=null)
    //     System.out.print(node.left.val+" ");
    //     if(node.right!=null)
    //     System.out.print(node.right.val+" ");

    //     horizontalPrint(node.left);
    //     horizontalPrint(node.right);

    // }

    // this function is from reference materials
    public static List<Character> printHorizontal(TreeNode node){
        List<Character>horizontal=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();

        if(node==null){
            return horizontal;
        }
        queue.offer(node);
        while(!queue.isEmpty()){
            int level=queue.size();
            for(int i=0;i<level;i++){
                TreeNode temp=queue.poll();
                horizontal.add(temp.val);

                if(temp.left!=null){
                    queue.offer(temp.left);
                }

                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }
        return horizontal;
    } 
    public static void main(String args[])
    {
        TreeNode root=new TreeNode('A');
        root.left=new TreeNode('B');
        root.right=new TreeNode('C');
        root.left.left=new TreeNode('D');
        root.left.right=new TreeNode('E');
        root.right.left=new TreeNode('F');
        root.right.right=new TreeNode('G');
        // horizontalPrint(root);
        List<Character> result=printHorizontal(root);
        for(Character i: result){
            System.out.print(i+" ");
        }

    }
}