package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    List<Resume> resumeListStorage = new ArrayList<>(STORAGE_LIMIT);

    @Override
    public void clear() {
        resumeListStorage.clear();
        size = 0;
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        return resumeListStorage.toArray(resumes);
    }

    @Override
    protected void add(int index, Resume resume) {
        resumeListStorage.add(resume);
    }

    @Override
    protected int getIndex(String uuid) {
        return resumeListStorage.indexOf(new Resume(uuid));
    }

    @Override
    protected Resume getResumeByIndex(int index) {
        return resumeListStorage.get(index);
    }

    @Override
    protected void deleteResumeByIndex(int index) {
        resumeListStorage.remove(index);
        ((ArrayList) resumeListStorage).trimToSize();
    }

    @Override
    protected void updateResumeByIndex(int index, Resume resume) {
        resumeListStorage.set(index, resume);
    }

}
