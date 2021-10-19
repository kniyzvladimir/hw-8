import java.util.Arrays;

public class MyArrayList <E> {
    private int capacity;

    private E [] array;

    public int getCapacity() {
        return capacity;
    }

    public MyArrayList (){
        capacity = 10;
        array = (E []) new Object[capacity];
    }

    public MyArrayList (int capacity) {
        this.capacity = capacity;
        array = (E []) new Object[capacity];
    }

    @Override
    public String toString() {
        int size = size();
        if (size == 0) {
            return "[]";
        }
        array = Arrays.copyOf(array, size());
        return Arrays.toString(array);

    }

    public int size () {
        int size = 0;
        for (E elem : array) {
            if (elem == null) {
                return size;
            }
            size ++;
        }
        return size;
    }

    public void add (E element) {
        int size = size();
        if (size < capacity) {
            array[size] = element;
        } else {
            int newLength = (int)(array.length * 1.5 + 1);
            array = Arrays.copyOf(array, newLength);
            array[size] = element;
        }

    }

    public void clear () {
        this.array = (E []) new Object[10];
    }

}
