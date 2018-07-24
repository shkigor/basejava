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
    protected boolean isExist(Object searchKey) {
        return resumeMap.containsKey(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        resumeMap.remove(searchKey);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return resumeMap.get(searchKey);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        resumeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        resumeMap.put(resume.getUuid(), resume);
    }
}
