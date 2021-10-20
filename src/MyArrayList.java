import java.util.Arrays;

public class MyArrayList <E> {
    private int capacity;

    private E [] array;

    public int getCapacity() {
        return array.length;
    }

    public MyArrayList (){
        capacity = 10;
        array = (E []) new Object[capacity];
    }

    public MyArrayList (int capacity) {
        this.capacity = capacity;
        array = (E []) new Object[capacity];
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
        this.array = (E []) new Object[getCapacity()];
    }

    public E get (int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException("Индекс превышает размер объекта MyArrayList");
        return array[index];
    }

    public void remove (int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException("Индекс превышает размер объекта MyArrayList");
        int size = size();
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }


    }

    @Override
    public String toString() {
        int size = size();
        if (size == 0) {
            return "[]";
        }
        StringBuilder arrayToString = new StringBuilder(size);
        arrayToString.append("[");
        for (int i= 0; i < size; i++) {
            if (i == size-1) {
                arrayToString.append(array[i]);
            } else {
                arrayToString.append(array[i]).append(", ");
            }
        }
        arrayToString.append("]");
        return new String(arrayToString);

    }

}
