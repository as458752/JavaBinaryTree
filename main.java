/**
 * This is the testing class for binary tree
 * 
 * @Jing Liang
 * @ 3/8/2015
 */
import java.util.Random;
public class main
{
    public static void main(String[] arg)
    {
        BinaryTree tree = new BinaryTree();
        Random ranNumber = new Random();
        
        //test the insertNode function of the binary tree
        int ranN;
        for(int i=0;i<50;i++)
        {
            ranN = ranNumber.nextInt(200);
            tree.insertNode(ranN);
        }
        tree.printInorder();
        
        //test the deleteNode function of the binary tree
        boolean success;
        for(int i=0;i<10;i++)
        {
            ranN = ranNumber.nextInt(200);
            success = tree.deleteNode(ranN);
            if(success) System.out.println(ranN + " has been deleted");
            else System.out.println(ranN + " is not found");
        }
        tree.printInorder();
    }
}
