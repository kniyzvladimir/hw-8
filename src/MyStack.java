public class MyStack<E> {
    private int size;
    private MyStack.Node<E> first;

    private MyStack.Node<E> last;

    private static class Node<E> {
        E item;
        MyStack.Node<E> next;
        MyStack.Node<E> prev;

        public Node(E item, MyStack.Node<E> next, MyStack.Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }

    public void push(E value) {
        MyStack.Node<E> l = this.last;
        MyStack.Node<E> newNode = new MyStack.Node<>(value, null, l);
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
        MyStack.Node<E> prevForRemove = null;
        MyStack.Node<E> nextForRemove = null;
        MyStack.Node<E> forSearching = first;

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

    public MyStack.Node<E> peek() {
        return this.last;
    }

    public MyStack.Node<E> pop() {
        if (size == 0) {
            return null;
        }
        MyStack.Node<E> newLast = this.last.prev;
        MyStack.Node<E> removable = this.last;
        this.last = newLast;
        size--;
        if (size == 0) {
            this.first = null;
        }
        return removable;
    }

    @Override
    public String toString() {
        if (size == 00 && this.first == null && this.last == null) {
            return "[This MyStack is clear!]";
        }
        StringBuilder MyStackToString = new StringBuilder();
        MyStackToString.append("[");
        MyStack.Node<E> l = this.first;
        int count = 0;
        while (count < size) {
            if (count == size - 1) {
                MyStackToString.append(l);
                count++;
            } else {
                MyStackToString.append(l).append("; ");
                l = l.next;
                count++;
            }
        }
        MyStackToString.append("]");
        return new String(MyStackToString);
    }
}
