import java.util.NoSuchElementException;

public class UniBHList<T> {
    private Node<T> firstNode;
    private int totalElements;

    public UniBHList() {
        this.firstNode = null;
        this.totalElements = 0;
    }

    public void insertAtBeginning(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(firstNode);
        firstNode = newNode;
        totalElements++;
    }

    public Node<T> removeAtBeginning() {
        if (isEmpty()) {
            throw new NoSuchElementException("A lista está vazia.");
        }
        Node<T> aux = firstNode;
        firstNode = firstNode.getNext();
        totalElements--;
        return aux;
    }

    public T search(T value) {
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }
        throw new NoSuchElementException("O item não existe na lista.");
    }

    public void removeByValue(T value) {
        if (isEmpty()) {
            throw new NoSuchElementException("Não é possível remover de uma lista vazia.");
        }

        if (firstNode.getValue().equals(value)) {
            removeAtBeginning();
            return;
        }

        Node<T> currentNode = firstNode;
        while (currentNode.getNext() != null && !currentNode.getNext().getValue().equals(value)) {
            currentNode = currentNode.getNext();
        }

        if (currentNode.getNext() == null) {
            throw new NoSuchElementException("O valor não está presente na lista.");
        }

        currentNode.setNext(currentNode.getNext().getNext());
        totalElements--;
    }

    public boolean isEmpty() {
        return this.totalElements == 0;
    }

    public void insertAfter(int i, T value) {
        if (i < 0 || i >= this.totalElements) {
            throw new IndexOutOfBoundsException("A lista não possui o item na posição " + i);
        }

        Node<T> newNode = new Node<>(value);
        Node<T> currentNode = this.firstNode;
        for (int j = 0; j < i; j++) {
            currentNode = currentNode.getNext();
        }
        
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        totalElements++;
    }

    public T removeAtIndex(int i) {
        if (i < 0 || i >= this.totalElements) {
            throw new IndexOutOfBoundsException("A lista não possui o item na posição " + i);
        }

        if (i == 0) {
            return removeAtBeginning().getValue();
        }

        Node<T> previousNode = this.firstNode;
        for (int j = 0; j < i - 1; j++) {
            previousNode = previousNode.getNext();
        }

        Node<T> nodeToRemove = previousNode.getNext();
        previousNode.setNext(nodeToRemove.getNext());
        totalElements--;
        return nodeToRemove.getValue();
    }

    public int size() {
        return this.totalElements;
    }

    public void set(int i, T newValue) {
        if (i < 0 || i >= this.totalElements) {
            throw new IndexOutOfBoundsException("A lista não possui o item na posição " + i);
        }

        Node<T> currentNode = this.firstNode;
        for (int j = 0; j < i; j++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setValue(newValue);
    }
    
    @Override
    public String toString() {
        if (this.totalElements == 0) {
            return "[ ]";
        }

        Node<T> currentNode = firstNode;
        StringBuilder builder = new StringBuilder("[");

        while(currentNode != null) {
            builder.append(currentNode.getValue());
            if(currentNode.getNext() != null){
               builder.append(", ");
            }
            currentNode = currentNode.getNext();
        }

        builder.append("]");
        return builder.toString();
    }
}
