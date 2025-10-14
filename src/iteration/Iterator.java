package iteration;

public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove();
}
