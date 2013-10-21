package hw6;

public class NullIterator<T> implements MyIterator<T> {
    private int index = 0;

    public NullIterator(){
    }

    public boolean isDone(){
        return true;
    }

    public T currentItem(){
        return null;
    }

    public void next(){
    }

    public void reset(){
    }
}
