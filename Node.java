/**
 * Node class is where stores the data for each node
 * 
 * @Jing Liang
 * @ 3/8/2015
 */
public class Node implements Comparable
{
    // instance variables
    private Comparable obj;
    private Node left;
    private Node right;
    /**
     * Constructor for objects of class Node
     */
    public Node(Comparable o)
    {
        // initialise instance variables
        obj = o;
    }

    /** The method which return the value of this node */
    public Comparable getValue()
    {
        return obj;
    }
    
    /** The method which return the left node of this node */
    public Node getLeftNode()
    {
        return left;
    }
    
    /** The method which return the right node of this node */
    public Node getRightNode()
    {
        return right;
    }
    
    /** The method which set the value of the left node */
    public void setLeftNode(Node n)
    {
        left = n;
    }
    
    /** The method which set the value of the right node */
    public void setRightNode(Node n)
    {
        right = n;
    }
    
    /** The method override the compareTo method in Comparable Interface */
    public int compareTo(Object o)
    {
        Node n = (Node) o;
        return obj.compareTo(n.getValue());
    }
}
