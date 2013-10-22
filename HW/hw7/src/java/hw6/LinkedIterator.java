package hw6;

public class LinkedIterator<T> implements MyIterator<T> {
    private Node<T> node;
    private Node<T> rootNode;

    public LinkedIterator(Node<T> n){
        rootNode = n;
        node = rootNode;
    }

    public boolean isDone(){
        return node == null;
    }

    public T currentItem(){
        return node.value;
    }

    public void next(){
        node = node.next;
    }

    public void reset(){
        node = rootNode;
    }
}
