package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    static final int STORAGE_LIMIT = 10000;

    Resume[] resumeArrayStorage = new Resume[STORAGE_LIMIT];
    protected int size;

    protected abstract void remove(int index);

    @Override
    protected void saveResumeByIndex(int index, Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        addByIndex(index, resume);
        size++;
    }

    public void clear() {
        Arrays.fill(resumeArrayStorage, 0, size, null);
        size = 0;
    }

    @Override
    protected void deleteResumeByIndex(int index) {
        size--;
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

    @Override
    public int size() {
        return size;
    }
}
