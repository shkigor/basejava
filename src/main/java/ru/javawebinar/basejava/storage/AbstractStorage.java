package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Objects;

public abstract class AbstractStorage implements Storage {

    protected abstract boolean isElementExistByIndex(Object indexObj);
    protected abstract void deleteResumeByIndex(Object indexObj);
    protected abstract Object getIndex(String uuid);
    protected abstract Resume getResumeByIndex(Object indexObj);
    protected abstract void saveResumeByIndex(Object indexObj, Resume resume);
    protected abstract void updateResumeByIndex(Object indexObj, Resume resume);

    @Override
    public void delete(String uuid) {
        Objects.requireNonNull(uuid, "ERROR delete. uuid cannot be null");
        Object indexObj = getIndex(uuid);
        if (!isElementExistByIndex(indexObj)) {
            throw new NotExistStorageException(uuid);
        }
        deleteResumeByIndex(indexObj);
    }

    @Override
    public Resume get(String uuid) {
        Objects.requireNonNull(uuid, "ERROR get. uuid cannot be null");
        Object indexObj = getIndex(uuid);
        if (!isElementExistByIndex(indexObj)) {
            throw new NotExistStorageException(uuid);
        }
        return getResumeByIndex(indexObj);
    }

    @Override
    public void save(Resume resume) {
        Objects.requireNonNull(resume, "ERROR save. Resume cannot be null");
        Object indexObj = getIndex(resume.getUuid());
        if (isElementExistByIndex(indexObj)) {
            throw new ExistStorageException(resume.getUuid());
        }
        saveResumeByIndex(indexObj, resume);
    }

    @Override
    public void update(Resume resume) {
        Objects.requireNonNull(resume, "ERROR update. Resume cannot be null");
        Object indexObj = getIndex(resume.getUuid());
        if (!isElementExistByIndex(indexObj)) {
            throw new NotExistStorageException(resume.getUuid());
        }
        updateResumeByIndex(indexObj, resume);
    }

}
