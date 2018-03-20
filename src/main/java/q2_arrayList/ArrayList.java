package q2_arrayList;

import java.util.Arrays;

public class ArrayList {

    // Mark - Constructors

    public ArrayList() {
        storage = new int[initCapacity];
        size = 0;
    }

    // Mark - Storage

    private final static int initCapacity = 4;
    private int[] storage;

    private int size;

    private int capacity() {
        return storage.length;
    }

    private void tryResize() {

        if (size == capacity()) {
            expand();
            return;
        }

        if (capacity() <= initCapacity) {
            return;
        }

        if (size < capacity() / 4) {
            shrink();
        }
    }


    private void expand() {
        storage = Arrays.copyOf(storage, capacity() * 2);
    }

    private void shrink() {
        storage = Arrays.copyOf(storage, capacity() / 2);
    }

    //  Mark - Utils

    private int newIndex() {
        return size;
    }

    private boolean outOfBounds(int index) {
        return index < 0 || index >= size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    //  Mark - Basic

    public void add(int value) {
        tryResize();
        storage[newIndex()] = value;
        size += 1;
    }


    public int get(int index) {
        if (outOfBounds(index)) {
            return -1;
        }

        return storage[index];
    }

    public int size() {
        return size;
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }

        size -= 1;
        tryResize();
    }

    //  Mark - Advanced

    private void move(int fromIndex, int toIndex, int offset) {
        int direction = offset > 0 ? 1 : -1;
        int start = direction > 0 ? toIndex - 1 : fromIndex;

        int index = start;
        for (int i = 0; i < toIndex - fromIndex; i++) {
            storage[index + offset] = storage[index];
            index -= direction;
        }
    }

    public void insert(int index, int value) {
        if (outOfBounds(index) && index != size) {
            return;
        }
        tryResize();
        move(index, size, 1);
        storage[index] = value;
        size += 1;
    }

    public void remove(int index) {
        if (outOfBounds(index)) {
            return;
        }
        move(index + 1, size, -1);
        size -= 1;
        tryResize();
    }

    // Mark - to String

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < size; i++) {
            builder.append(get(i));
            if (i < size - 1) {
                builder.append(", ");
            }
        }

        builder.append("]");
        return builder.toString();
    }
}
