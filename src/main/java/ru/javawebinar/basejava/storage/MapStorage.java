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
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        return resumeMap.values().toArray(resumes);
    }

    @Override
    protected void deleteResumeByIndex(Object indexObj) {
        if (Objects.isNull(getResumeByIndex(indexObj))) {
            throw new NotExistStorageException((String) indexObj);
        }
        resumeMap.remove(indexObj);
    }

    @Override
    public int size() {
        return resumeMap.size();
    }

    @Override
    protected Object getIndex(String uuid) {
        return uuid;
    }

    @Override
    protected Resume getResumeByIndex(Object indexObj) {
        return resumeMap.get(indexObj);
    }

    @Override
    protected void saveResumeByIndex(Object indexObj, Resume resume) {
        if (Objects.nonNull(getResumeByIndex(indexObj))) {
            throw new ExistStorageException(resume.getUuid());
        }
        resumeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResumeByIndex(Object indexObj, Resume resume) {
        if (Objects.isNull(getResumeByIndex(indexObj))) {
            throw new NotExistStorageException(resume.getUuid());
        }
        resumeMap.put(resume.getUuid(), resume);
    }
}
