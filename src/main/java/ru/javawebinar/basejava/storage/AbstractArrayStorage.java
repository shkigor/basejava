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

    protected abstract void addByIndex(int index, Resume resume);
    protected abstract void deleteResume(int index);

    @Override
    public void clear() {
        Arrays.fill(resumeArrayStorage, 0, size, null);
        size = 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(resumeArrayStorage, 0, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected void deleteResumeByIndex(int index) {
        size--;
        deleteResume(index);
        resumeArrayStorage[size] = null;
    }

    @Override
    protected Resume getResumeByIndex(int index) {
        return resumeArrayStorage[index];
    }

    @Override
    protected void saveResumeByIndex(int index, Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        addByIndex(index, resume);
        size++;
    }

    @Override
    protected void updateResumeByIndex(int index, Resume resume) {
        resumeArrayStorage[index] = resume;
    }
}
