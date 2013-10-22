package hw6;

interface MyIterator<T> {
    public boolean isDone();
    public T currentItem();
    public void next();
    public void reset();
}
