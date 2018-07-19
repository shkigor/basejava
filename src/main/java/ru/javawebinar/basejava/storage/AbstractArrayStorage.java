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
    protected void deleteResume(Object indexObj) {
        size--;
        deleteResume((int) indexObj);
        resumeArrayStorage[size] = null;
    }

    @Override
    protected Resume getResume(Object indexObj) {
        return resumeArrayStorage[(int) indexObj];
    }

    @Override
    protected boolean isResumeExist(Object indexObj) {
        return (int) indexObj >= 0;
    }

    @Override
    protected void saveResume(Object indexObj, Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        addByIndex((int) indexObj, resume);
        size++;
    }

    @Override
    protected void updateResume(Object indexObj, Resume resume) {
        resumeArrayStorage[(int) indexObj] = resume;
    }
}
