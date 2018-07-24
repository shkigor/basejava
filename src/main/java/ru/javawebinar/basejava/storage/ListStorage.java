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
    protected void doDelete(Object searchKey) {
        resumeListStorage.remove((int) searchKey);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(resumeListStorage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return resumeListStorage.get((int) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        resumeListStorage.add(resume);
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        resumeListStorage.set((int) searchKey, resume);
    }
}
