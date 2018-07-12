package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addByIndex(int index, Resume resume) {
        resumeArrayStorage[size] = resume;
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

    @Override
    protected void deleteResume(int index) {
        resumeArrayStorage[index] = resumeArrayStorage[size];
    }
}
