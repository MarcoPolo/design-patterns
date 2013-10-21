package hw6;
import java.util.Stack;

public class PreOrderIterator<T extends Component> implements MyIterator<T> {
    private T node;
    private T rootNode;
    private Stack<MyIterator> iteratorStack = new Stack<MyIterator>();

    public PreOrderIterator(T root){
        rootNode = root;
        node = root;
        try{
            iteratorStack.push(node.CreateIterator());
        } catch (Exception e){
            System.out.println("Error in constructing the preorder iterator");
        }
    }

    public boolean isDone(){
        return currentItem() == null;
    }

    public T currentItem(){
        if (iteratorStack.empty()){
            return null;
        } else {
            MyIterator currentIterator = iteratorStack.peek();
            return (T)currentIterator.currentItem();
        }
    }

    private void getNodeRight(){
        if ( iteratorStack.empty() ){
            return;
        }

        System.out.println("getting right");
        MyIterator currentIterator = iteratorStack.peek();
        System.out.println("getting right "+ currentIterator.isDone());
        System.out.println("count is "+iteratorStack.elementCount);
        if ( currentIterator.isDone() ){
            iteratorStack.pop(); 
            getNodeRight();
        }else {
            currentIterator.next();
            if (isDone()){
                getNodeRight();
            }
        }
    }

    private void getNextNode(){
        if ( iteratorStack.empty() ){
            return;
        }

        MyIterator currentIterator = iteratorStack.peek();
        if (currentIterator.isDone() ){
            getNodeRight();
            return;
        } else {

            try {
                MyIterator deepIterator = ((Component)currentIterator.currentItem()).CreateIterator();
                iteratorStack.push(deepIterator);
                if (isDone()) {
                    getNextNode();
                } 
            } catch (Exception e){
                System.out.println("Error in creating an iterator to push");
            }

        }
    }

    public void next(){
        getNextNode();
    }

    public void reset(){
    }
}
