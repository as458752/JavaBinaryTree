
/**
 * Binary class is where stores all nodes and methods of insert node,delete node and print nodes.
 * 
 * @ Jing liang
 * @ 3/8/2015
 */
public class BinaryTree
{
    // instance variables
    private Node root;

    /**
     * Constructor for objects of class BinaryTree
     */
    public BinaryTree()
    {
        root = null;
    }

    /** This method take a new Node and insert it into the binary tree */
    public void insertNode(Node newNode)
    {
        Node n = root;         //n is the iterator node
        Node parent = null;     //keep track the parent of the iterator node
        do
        {
            if (n == null && parent == null)
            {
                root = newNode;
                return;
            }
            else if (n == null && parent != null)
            {
                if(newNode.compareTo(parent)< 0) parent.setLeftNode(newNode);
                else parent.setRightNode(newNode);
                return;
            }
            else      // n is not empty
            {
                parent = n;
                if(newNode.compareTo(n)< 0) n = n.getLeftNode();
                else n = n.getRightNode();
            }
        }while(true);
    }
    
    /** This method overload insertNode(Node newNode). */
    public void insertNode(Comparable c)
    {
        Node n= new Node(c);
        insertNode(n);
    }
    
    /** This method delete the node with value of c */
    public boolean deleteNode(Comparable c)
    {
        Node n = root;
        Node parent = null;
        while (n != null && n.getValue().compareTo(c)!=0)
        {
            parent = n;
            if(c.compareTo(n.getValue())< 0) n = n.getLeftNode();
            else n = n.getRightNode();
        }
        if (n==null) return false;
        else
        {
            if(parent==null) root=removeRoot(n);
            else if(parent.getLeftNode()==null) parent.setRightNode(removeRoot(n));
            else if (n.getValue().compareTo(parent.getLeftNode().getValue())==0) parent.setLeftNode(removeRoot(n));
            else parent.setRightNode(removeRoot(n));
            return true;
        }
    }

    /** This method delete the Node and return the right child of this node if the left child is empty. Otherwise
     ** return the left child of the node.*/
    private Node removeRoot(Node rt)
    {
        if(rt.getLeftNode()==null) return rt.getRightNode();
        else if(rt.getRightNode()==null) return rt.getLeftNode();
        else if(rt.getLeftNode().getRightNode()==null)
        {
            rt.getLeftNode().setRightNode(rt.getRightNode());
            return rt.getLeftNode();
        }
        else
        {
            Node n = rt.getRightNode();
            while(n!=null) 
            {
                if (n.getLeftNode()==null)
                {
                    n.setLeftNode(rt.getLeftNode().getRightNode());
                    rt.getLeftNode().setRightNode(rt.getRightNode());
                    return rt.getLeftNode();
                }
                n = n.getLeftNode();
            }
            return null;
        }
    }
    
    /** This method overload printInorder(Node n) */
    public void printInorder()
    {
        if(root ==null) System.out.println("The binary tree is empty");
        else printInorder(root);
    }
    
    /** This method print out each node in order. */
    public void printInorder(Node n)
    {
        if(n != null)
        {
            printInorder(n.getLeftNode());
            System.out.print(n.getValue()+" ");
            printInorder(n.getRightNode());
        }
    }
}
