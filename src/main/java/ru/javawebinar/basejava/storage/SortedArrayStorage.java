package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void add(int index, Resume resume) {
        int position = Math.abs(index) - 1;
        System.arraycopy(storage, position, storage, position + 1, size - position);
        storage[position] = resume;
    }

    @Override
    protected void remove(int index) {
        int numMoved = size - index;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

    /**
     * If the binary search method returns a negative value that is equivalent to (- <insertion point> - 1),
     * where insertion point is defined as the index at which the search key would be inserted into the array
     *
     * @param uuid
     * @return position of searched element
     */
    @Override
    protected int getIndex(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid));
    }
}
