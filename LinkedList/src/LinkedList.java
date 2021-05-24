public class LinkedList<T extends Comparable<T>> implements CustomList<T>  {
    private Node<T> head;
    private int counter;

    @Override
    public void put(T data) {
        ++this.counter;
        if (head == null) {
            head = new Node<>(data);
        } else {
            insertAtBeginning(data);
        }
    }

    @Override
    public void delete(T data) {
        if (this.head == null) {
            return;
        }

        --this.counter;

        if (this.head.getData().compareTo(data) == 0) {
            this.head = this.head.getNext();
        } else {
            remove(data, head, head.getNext());
        }
    }

    @Override
    public void replicate(int n) {
        if (this.head == null) {
            return;
        }
        Node<T> node = this.head;
        while (node != null) {
            for (int i=0; i<n-1; i++){
                //Creating a node
                Node<T> first = new Node<>(node.getData());
                Node<T> second = node.getNext();
                //putting it after the current node
                node.setNext(first);
                first.setNext(second);
                //go to the next node
                node = node.getNext();
            }
            node = node.getNext();
        }
    }

    @Override
    public void traverseList() {
        if (this.head == null) {
            return;
        }

        Node<T> node = this.head;

        while (node != null) {
            System.out.print(node + " ");
            node = node.getNext();
        }
    }

    @Override
    public int size() {
        return this.counter;
    }

    //Here we have constant time complexity O(1)
    private void insertAtBeginning(T data) {
        if (data !=null) {
            Node<T> newNode = new Node<>(data);
            newNode.setNext(head);
            this.head = newNode;
        }
    }

    // Here we have Linear complexity O(N)
    private void insertAtEnd(T data, Node<T> node) {

        if (node.getNext() != null) {
            insertAtEnd(data, node.getNext());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNext(newNode);
        }
    }

    private void remove(T dataForRemoval, Node<T> previousNode, Node<T> actualNode) {

        while (actualNode != null) {

            if (actualNode.getData().compareTo(dataForRemoval) == 0) {
                previousNode.setNext(actualNode.getNext());
                actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNext();
        }
    }
}
