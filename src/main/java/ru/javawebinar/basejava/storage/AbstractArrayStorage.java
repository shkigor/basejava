package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    protected Resume[] resumeArrayStorage = new Resume[STORAGE_LIMIT];

    protected abstract void remove(int index);

    public void clear() {
        Arrays.fill(resumeArrayStorage, 0, size, null);
        size = 0;
    }

    @Override
    protected void deleteResumeByIndex(int index) {
        remove(index);
        resumeArrayStorage[size] = null;
    }

    @Override
    protected void updateResumeByIndex(int index, Resume resume) {
        resumeArrayStorage[index] = resume;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(resumeArrayStorage, 0, size);
    }

    @Override
    protected Resume getResumeByIndex(int index) {
        return resumeArrayStorage[index];
    }
}
