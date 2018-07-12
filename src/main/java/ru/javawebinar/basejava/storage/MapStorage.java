package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> resumeMap = new HashMap<>();

    @Override
    public void clear() {
        resumeMap.clear();
    }

    @Override
    public void delete(String uuid) {
        Objects.requireNonNull(uuid, "ERROR delete. uuid cannot be null");

        Resume r = resumeMap.get(uuid);
        if (Objects.isNull(r)) {
            throw new NotExistStorageException(uuid);
        } else {
            resumeMap.remove(uuid);
        }
    }

    @Override
    public Resume get(String uuid) {
        Objects.requireNonNull(uuid, "ERROR get. uuid cannot be null");

        Resume r = resumeMap.get(uuid);
        if (Objects.isNull(r)) {
            throw new NotExistStorageException(uuid);
        }
        return r;
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        return resumeMap.values().toArray(resumes);
    }

    @Override
    public void save(Resume resume) {
        Objects.requireNonNull(resume, "ERROR save. Resume cannot be null");

        Resume r = resumeMap.get(resume.getUuid());
        if (Objects.nonNull(r)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            resumeMap.put(resume.getUuid(), resume);
        }
    }

    @Override
    public int size() {
        return resumeMap.size();
    }

    @Override
    public void update(Resume resume) {
        Objects.requireNonNull(resume, "ERROR update. Resume cannot be null");

        Resume r = resumeMap.get(resume.getUuid());
        if (Objects.isNull(r)) {
            throw new NotExistStorageException(resume.getUuid());
        }
        resumeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void addByIndex(int index, Resume resume) {
        resumeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResumeByIndex(int index) {

    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    protected Resume getResumeByIndex(int index) {
        return null;
    }

    @Override
    protected void saveResumeByIndex(int index, Resume resume) {

    }

    @Override
    protected void updateResumeByIndex(int index, Resume resume) {

    }
}
