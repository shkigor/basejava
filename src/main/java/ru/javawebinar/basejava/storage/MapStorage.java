package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class MapStorage extends AbstractStorage {
    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected void add(int index, Resume resume) {

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
    protected void deleteResumeByIndex(int index) {

    }

    @Override
    protected void updateResumeByIndex(int index, Resume resume) {

    }
}
