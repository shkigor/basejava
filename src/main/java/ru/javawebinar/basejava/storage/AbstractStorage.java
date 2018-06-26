package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Objects;

public abstract class AbstractStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected int size;

    protected abstract void add(int index, Resume resume);
    protected abstract int getIndex(String uuid);
    protected abstract Resume getResumeByIndex(int index);
    protected abstract void deleteResumeByIndex(int index);
    protected abstract void updateResumeByIndex(int index, Resume resume);

    public int size() {
        return size;
    }

    public void save(Resume resume) {
        Objects.requireNonNull(resume, "ERROR save. Resume cannot be null");

        int index = getIndex(resume.getUuid());
        if (index > -1) {
            throw new ExistStorageException(resume.getUuid());
        } else if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            add(index, resume);
            size++;
        }
    }

    public Resume get(String uuid) {
        Objects.requireNonNull(uuid, "ERROR get. uuid cannot be null");

        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getResumeByIndex(index);
    }

    public void update(Resume resume) {
        Objects.requireNonNull(resume, "ERROR update. Resume cannot be null");

        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            updateResumeByIndex(index, resume);
        }
    }

    public void delete(String uuid) {
        Objects.requireNonNull(uuid, "ERROR delete. uuid cannot be null");

        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            size--;
            deleteResumeByIndex(index);
        }
    }
}
