package hw6;

public class ArrayIterator<T> implements MyIterator<T> {
    private int index = 0;
    private T[] array = null;

    public ArrayIterator(T[] array){
        this.array = array;
    }

    public boolean hasNext(){
        return index < array.length;
    }

    public T currentItem(){
        return array[index];
    }

    public void next(){
        index++; 
    }

    public void reset(){
        index=0;
    }
}
