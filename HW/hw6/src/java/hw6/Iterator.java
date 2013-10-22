package hw6;

interface MyIterator<T> {
    public boolean hasNext();
    public T currentItem();
    public void next();
    public void reset();
}
