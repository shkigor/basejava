package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addByIndex(int index, Resume resume) {
        int position = Math.abs(index) - 1;
        System.arraycopy(resumeArrayStorage, position, resumeArrayStorage, position + 1, size - position);
        resumeArrayStorage[position] = resume;
    }

    /**
     * If the binary search method returns a negative value that is equivalent to (- <insertion point> - 1),
     * where insertion point is defined as the index at which the search key would be inserted into the array
     *
     * @param uuid
     * @return position of searched element
     */
    @Override
    protected Object getIndex(String uuid) {
        return Arrays.binarySearch(resumeArrayStorage, 0, size, new Resume(uuid));
    }

    @Override
    protected void deleteResume(int index) {
        int numMoved = size - index;
        if (numMoved > 0) {
            System.arraycopy(resumeArrayStorage, index + 1, resumeArrayStorage, index, numMoved);
        }
    }
}
