import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
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
public class VerticalTraversal{

    public static List<List<Character>> verticalPrint(TreeNode root){

        List<List<Character>> vertical=new ArrayList<>();
        if(root == null){
            return vertical;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        Queue<Integer> hdQueue=new LinkedList<>();
        Map<Integer,List<Character>>treeMap=new TreeMap<>();
        queue.offer(root);
        hdQueue.offer(0);
        while(!queue.isEmpty()){
            TreeNode tempNode=queue.poll();
            int hd=hdQueue.poll();

            //this below line will check if there is a key of value hd and a List associated with it or not
            // if a list is not there for this key
            // then the arrow function creates a new List and adds the node value
            treeMap.computeIfAbsent(hd,k-> new ArrayList<>()).add(tempNode.val);

            if(tempNode.left !=null){
                queue.offer(tempNode.left);
                hdQueue.offer(hd-1);
            }

            if(tempNode.right!=null){
                queue.offer(tempNode.right);
                hdQueue.offer(hd+1);
            }
        }

        //in the below line treeMap.values() returns a list containing lists as elements
        for(List<Character> value: treeMap.values()){
            vertical.add(value);
        }

        return vertical;

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

        List<List<Character>>result=verticalPrint(root);
        for(List<Character> i: result){
            for(Character j: i){
                System.out.print(j+" ");
            }
            System.out.println(" ");
        }

    }
}