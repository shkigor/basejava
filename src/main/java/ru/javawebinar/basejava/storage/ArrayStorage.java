package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(resumeArrayStorage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertElement(int index, Resume resume) {
        resumeArrayStorage[size] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        resumeArrayStorage[index] = resumeArrayStorage[size];
    }
}
