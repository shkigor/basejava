package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Objects;

public abstract class AbstractStorage implements Storage {

    protected abstract boolean isResumeExist(Object indexObj);
    protected abstract void deleteResume(Object indexObj);
    protected abstract Object getIndex(String uuid);
    protected abstract Resume getResume(Object indexObj);
    protected abstract void saveResume(Object indexObj, Resume resume);
    protected abstract void updateResume(Object indexObj, Resume resume);

    @Override
    public void delete(String uuid) {
        Objects.requireNonNull(uuid, "ERROR delete. uuid cannot be null");
        Object indexObj = getIndex(uuid);
        if (!isResumeExist(indexObj)) {
            throw new NotExistStorageException(uuid);
        }
        deleteResume(indexObj);
    }

    @Override
    public Resume get(String uuid) {
        Objects.requireNonNull(uuid, "ERROR get. uuid cannot be null");
        Object indexObj = getIndex(uuid);
        if (!isResumeExist(indexObj)) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(indexObj);
    }

    @Override
    public void save(Resume resume) {
        Objects.requireNonNull(resume, "ERROR save. Resume cannot be null");
        Object indexObj = getIndex(resume.getUuid());
        if (isResumeExist(indexObj)) {
            throw new ExistStorageException(resume.getUuid());
        }
        saveResume(indexObj, resume);
    }

    @Override
    public void update(Resume resume) {
        Objects.requireNonNull(resume, "ERROR update. Resume cannot be null");
        Object indexObj = getIndex(resume.getUuid());
        if (!isResumeExist(indexObj)) {
            throw new NotExistStorageException(resume.getUuid());
        }
        updateResume(indexObj, resume);
    }

}
