public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> nextNode;

    //Constructor
    public Node(T data) {
        this.data = data;
    }

    //Getter and Setters for the Node
    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return nextNode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

}
