package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> resumeListStorage = new ArrayList<>();

    @Override
    public void clear() {
        resumeListStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        return resumeListStorage.toArray(resumes);
    }

    @Override
    public int size() {
        return resumeListStorage.size();
    }

    @Override
    protected void deleteResumeByIndex(Object indexObj) {
        resumeListStorage.remove((int) indexObj);
    }

    @Override
    protected Object getIndex(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(resumeListStorage.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume getResumeByIndex(Object indexObj) {
        return resumeListStorage.get((int) indexObj);
    }

    @Override
    protected boolean isElementExistByIndex(Object indexObj) {
        return (int) indexObj != -1;
    }

    @Override
    protected void saveResumeByIndex(Object indexObj, Resume resume) {
        resumeListStorage.add(resume);
    }

    @Override
    protected void updateResumeByIndex(Object indexObj, Resume resume) {
        resumeListStorage.set((int) indexObj, resume);
    }
}
