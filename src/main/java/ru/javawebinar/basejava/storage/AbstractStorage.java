package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Objects;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchKey(String uuid);
    protected abstract boolean isExist(Object searchKey);
    protected abstract void doDelete(Object searchKey);
    protected abstract Resume doGet(Object searchKey);
    protected abstract void doSave(Object searchKey, Resume resume);
    protected abstract void doUpdate(Object searchKey, Resume resume);

    @Override
    public void delete(String uuid) {
        Objects.requireNonNull(uuid, "ERROR delete. uuid cannot be null");
        Object searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    @Override
    public Resume get(String uuid) {
        Objects.requireNonNull(uuid, "ERROR get. uuid cannot be null");
        Object searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public void save(Resume resume) {
        Objects.requireNonNull(resume, "ERROR save. Resume cannot be null");
        Object searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(searchKey, resume);
    }

    @Override
    public void update(Resume resume) {
        Objects.requireNonNull(resume, "ERROR update. Resume cannot be null");
        Object searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(searchKey, resume);
    }


    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
