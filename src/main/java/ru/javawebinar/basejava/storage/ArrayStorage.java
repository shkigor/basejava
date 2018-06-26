package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void add(int index, Resume resume) {
        resumeArrayStorage[size] = resume;
    }

    @Override
    protected void remove(int index) {
        resumeArrayStorage[index] = resumeArrayStorage[size];
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(resumeArrayStorage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
