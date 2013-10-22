package hw6;

public class ArrayIterator<T> implements MyIterator<T> {
    private int index = 0;
    private T[] array = null;

    public ArrayIterator(T[] arr){
        array = arr;
    }

    public boolean isDone(){
        return index >= array.length;
    }

    public T currentItem(){
        return array[index];
    }

    public void next(){
        while (array[++index] == null && !isDone()) {}
    }

    public void reset(){
        index=0;
    }
}
