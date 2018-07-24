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

    protected abstract Integer getSearchKey(String uuid);
    protected abstract void insertElement(int index, Resume resume);
    protected abstract void fillDeletedElement(int index);

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
    protected boolean isExist(Object index) {
        return (int) index >= 0;
    }

    @Override
    protected void doDelete(Object index) {
        size--;
        fillDeletedElement((int) index);
        resumeArrayStorage[size] = null;
    }

    @Override
    protected Resume doGet(Object index) {
        return resumeArrayStorage[(int) index];
    }

    @Override
    protected void doSave(Object index, Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        insertElement((int) index, resume);
        size++;
    }

    @Override
    protected void doUpdate(Object index, Resume resume) {
        resumeArrayStorage[(int) index] = resume;
    }
}
