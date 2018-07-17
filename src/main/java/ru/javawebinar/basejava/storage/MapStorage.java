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
        resumeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResumeByIndex(int index, Resume resume) {

    }
}
