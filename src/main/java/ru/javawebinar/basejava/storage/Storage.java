package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.List;

public interface Storage {

    void clear();

    void delete(String uuid);

    Resume get(String uuid);

    Resume[] getAll();
// TODO return list, sorted by fullName
//    List<Resume> getAllSorted();

    void save(Resume r);

    int size();

    void update(Resume r);
}
