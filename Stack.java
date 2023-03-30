public class Stack
{
    Node top;
    
    public void push(String p) {
        Node n = new Node(p);
        n.next = top;
        top = n;
    }
    
    /**
     * Integer is a java wrapper class
     */
    public String peek() {
        if (top == null) return null;
        return top.value;
    }
    
    public String pop() {
        if (top == null) return null;
        Node oldtop = top;
        top = top.next;
        oldtop.next = null;
        return oldtop.value;
    }

    public class Node
    {
        String value;
        Node next;

        public Node(String x) {
            value = x;
        }
    }
}
