package recursion;

public class ReverseLinkedList {
    class Node{
        int val;
        Node next;
    }

    private Node reverseLinkedList(Node root){
        if(root == null)
            return null;
        Node previous = null;
        while(root != null){
            Node temp = root.next;
            root.next = previous;
            previous = root;
            root = temp;
        }

        return previous;
    }

    public static void main(String[] args) {
        ReverseLinkedList.Node node = (new ReverseLinkedList()).new Node();
        node.val = 1;


    }
}
