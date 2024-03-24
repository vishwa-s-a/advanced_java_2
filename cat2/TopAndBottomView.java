import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

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
class Pair{
    TreeNode node;
    int hd;
    public Pair(TreeNode node,int hd){
        this.node=node;
        this.hd=hd;
    }
}
public class TopAndBottomView{

    public static List<Character> topView(TreeNode root){
        List<Character>top=new ArrayList<>();
        if(root==null){
            return top;
        }

        Map<Integer,Character> treeMap=new TreeMap<>();
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            TreeNode temp=pair.node;
            int hd=pair.hd;

            if(!treeMap.containsKey(hd)){
                treeMap.put(hd,temp.val);
            }

            if(temp.left!=null){
                queue.offer(new Pair(temp.left,hd-1));
            }

            if(temp.right!=null){
                queue.offer(new Pair(temp.right,hd+1));
            }
        }
        for(Character i: treeMap.values()){
            top.add(i);
        }
        return top;

    }

    public static List<Character> bottomView(TreeNode root){
        List<Character>bottom=new ArrayList<>();
        if(root==null){
            return bottom;
        }

        Map<Integer,Character> treeMap=new TreeMap<>();
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            TreeNode temp=pair.node;
            int hd=pair.hd;

            treeMap.put(hd,temp.val);

            if(temp.left!=null){
                queue.offer(new Pair(temp.left,hd-1));
            }

            if(temp.right!=null){
                queue.offer(new Pair(temp.right,hd+1));
            }
        }
        for(Character i: treeMap.values()){
            bottom.add(i);
        }
        return bottom;

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

        List<Character> top=topView(root);
        System.out.println("The top view of the tree is: ");
        for(char i: top){
            System.out.print(i+" ");
        }
        System.out.println("\nThe bottom view of the tree is: ");
        List<Character>bottom=bottomView(root);
        for(char i: bottom){
            System.out.print(i+" ");
        }
        System.out.println(" ");
    }
}