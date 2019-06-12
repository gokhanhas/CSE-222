/*
 * Gokhan Has - 161044067
 */

/**
 * This is the myStack generic class.Implementation stack methods.
 * @param <E> generic parameter.
 * @author gokhanHas
 */
public class myStack<E> {
    /**
     * Node that keep data.
     */
    private Node head;

    /**
     * It is the helper variable to stacks size.
     * Noırmally it is not necessary.
     */
    int size = 0;

    /**
     * This is the node class.Used in myStack class.
     */
    private class Node {
        /**
         * Data variable keep the data.
         */
        E data;

        /**
         * It keeps the previous element.
         */
        Node nextNode;

        /**
         *
         * @return previous element.
         */
        private Node getNextNode() {
            return nextNode;
        }

        /**
         *
         * @param nxt next Node.
         */
        private void setNextNode(Node nxt) {
            this.nextNode = nxt;
        }

        /**
         *
         * @return  generic type data.
         */
        private E getData() {
            return data;
        }

        /**
         *
         * @param nw to set data.
         */
        private void setData(E nw) {
            this.data = nw;
        }
    }

    /**
     * No parameter constructor.
     */
    public myStack() {
        head = null;
        size = 0;
    }

    /**
     * It added to new element in myStack object.
     * @param newObject the element to be added to myStack.
     * @return E type to added element.
     */
    public E push(E newObject) {

        if(this.empty()) {
            this.head = new Node();
            this.head.data = newObject;
            this.head.nextNode = null;
        }
        else {
            Node newNode = new Node();
            newNode.data = newObject;
            newNode.nextNode = this.head;
            head = newNode;
        }
        size++;
        return this.head.data;
    }

    /**
     *
     * @return the last element which is removed.
     */
    public E pop() {

        if(this.empty()) {
            System.out.println("Error ! Stack is empty.Exception will be throw.");
            throw new NullPointerException();
        }

        E returnedElement = head.data;
        head = head.nextNode;
        size--;
        return returnedElement;
    }

    /**
     *
     * @return last element in myStack.
     */
    public E peek() {
        if(this.empty()) {
            System.out.println("Error ! Stack is empty.Exception will be throw.");
            throw new NullPointerException();
        }
        return head.data;
    }

    /**
     *
     * @return true if the myStack is empty.
     */
    public boolean empty() {
        if(size == 0)
            return true;
        return false;
    }
}
