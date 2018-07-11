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
    protected void addByIndex(int index, Resume resume) {
        resumeListStorage.add(resume);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume[] resumes = new Resume[size()];
        resumeListStorage.toArray(resumes);
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(resumes[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void saveResumeByIndex(int index, Resume resume) {
        addByIndex(index, resume);
    }

    @Override
    protected Resume getResumeByIndex(int index) {
        return resumeListStorage.get(index);
    }

    @Override
    protected void deleteResumeByIndex(int index) {
        resumeListStorage.remove(index);
    }

    @Override
    protected void updateResumeByIndex(int index, Resume resume) {
        resumeListStorage.set(index, resume);
    }

    @Override
    public int size() {
        return resumeListStorage.size();
    }
}
