package iteration;

public interface MyIterator<E> {
    boolean hasNext();
    E next();
    void remove();
}
