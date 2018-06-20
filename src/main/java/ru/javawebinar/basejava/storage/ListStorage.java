package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class ListStorage extends AbstractStorage {
    @Override
    public void clear() {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

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
    protected void remove(int index) {

    }

    @Override
    public int size() {
        return 0;
    }
}
