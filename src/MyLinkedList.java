public class MyLinkedList<E> {
    private int size;
    private MyLinkedList.Node<E> first;

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLast() {
        return last;
    }

    private MyLinkedList.Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }

    public void add(E value) {
        MyLinkedList.Node<E> l = this.last;
        MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(value, null, l);
        this.last = newNode;
        if (l == null) {
            this.first = newNode;
        } else {
            l.next = newNode;
        }
        ++this.size;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        MyLinkedList.Node<E> prevForRemove = null;
        MyLinkedList.Node<E> nextForRemove = null;
        MyLinkedList.Node<E> forSearching = first;

        if (index == 0) {
            this.first = forSearching.next;
        } else if (index == size - 1) {
            this.last = forSearching.prev;
        } else {

            int counter = 0;
            while (counter <= index + 1) {
                if (counter == index - 1) {
                    prevForRemove = forSearching;
                }
                if (counter == index + 1) {
                    nextForRemove = forSearching;
                }
                forSearching = forSearching.next;
                counter++;
            }
            prevForRemove.next = nextForRemove;
            nextForRemove.prev = prevForRemove;
        }
        size--;
        if (size == 0) {
            this.first = null;
            this.last = null;
        }
    }

    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public int size() {
        return this.size;
    }

    public Node<E> get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return this.first;
        }
        if (index == size - 1) {
            return this.last;
        }
        if (index < size / 2) {
            int counter = 0;
            MyLinkedList.Node<E> soughtElem = this.first;
            while (counter < index) {
                soughtElem = soughtElem.next;
                counter++;
            }
            return soughtElem;
        } else {
            int counter = size - 1;
            MyLinkedList.Node<E> soughtElem = this.last;
            while (counter > index) {
                soughtElem = soughtElem.prev;
                counter--;
            }
            return soughtElem;
        }
    }

    @Override
    public String toString() {
        if (size == 00 && this.first == null && this.last == null) {
            return "[This MyLinkedList is clear!]";
        }
        StringBuilder MyLinkedListToString = new StringBuilder();
        MyLinkedListToString.append("[");
        MyLinkedList.Node<E> l = this.first;
        int count = 0;
        while (count < size) {
            if (count == size - 1) {
                MyLinkedListToString.append(l);
                count++;
            } else {
                MyLinkedListToString.append(l).append("; ");
                l = l.next;
                count++;
            }
        }
        MyLinkedListToString.append("]");
        return new String(MyLinkedListToString);
    }
}
