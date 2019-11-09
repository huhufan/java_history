package 队列;

public interface Merger<E> {
    E merge(E a,E b);
}
