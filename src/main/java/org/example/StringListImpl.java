package org.example;

import org.example.Exceptions.ElementNotFoundException;
import org.example.Exceptions.InvalidIndexException;
import org.example.StringList;
import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] storage;
    private int size;

    public StringListImpl(String[] storage) {
        this.storage = storage;
    }

    public StringListImpl() {
        storage = new String[10];
    }

    public StringListImpl(int initSize) {
        storage = new String[initSize];
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
    }

    private void validateSize() {
        if (size == storage.length) {
            throw new IllegalStateException("Storage is full");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException();
        }
    }


    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException("Element " + item + " is not present in the list");
        }
        if (index != size) {
            System.arraycopy(storage, index, storage, index + 1, size - index);
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String removedItem = storage[index];
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        storage[size - 1] = null;
        size--;
        return removedItem;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(String item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }
}