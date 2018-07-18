package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

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
    public int size() {
        return resumeMap.size();
    }

    @Override
    protected boolean isElementExistByIndex(Object indexObj) {
        return resumeMap.containsKey(indexObj);
    }

    @Override
    protected void deleteResumeByIndex(Object indexObj) {
        resumeMap.remove(indexObj);
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
        resumeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResumeByIndex(Object indexObj, Resume resume) {
        resumeMap.put(resume.getUuid(), resume);
    }
}
