package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private final int NOT_FOUND = -1;
    private Resume[] storage = new Resume[10000];
    private int size;
    private int index = NOT_FOUND;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        Objects.requireNonNull(resume, "ERROR update. Resume cannot be null");

        if (getIndex(resume.getUuid()).isPresent()) {
            storage[index] = resume;
        } else {
            System.out.println("Resume(" + resume.getUuid() + ") not exist");
        }
    }

    public void save(Resume resume) {
        Objects.requireNonNull(resume, "ERROR save. Resume cannot be null");
        if (size == storage.length) {
            System.out.println("Storage overflow");
            return;
        }

        if (getIndex(resume.getUuid()).isPresent()) {
            System.out.println("Resume(" + resume.getUuid() + ") already exist");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        Objects.requireNonNull(uuid, "ERROR get. uuid cannot be null");

        if (getIndex(uuid).isPresent()) {
            return storage[index];
        } else {
            System.out.println("Resume(" + uuid + ") not exist");
            return null;
        }
    }

    public void delete(String uuid) {
        Objects.requireNonNull(uuid, "ERROR delete. uuid cannot be null");

        if (getIndex(uuid).isPresent()) {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        } else {
            System.out.println("Resume(" + uuid + ") not exist");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private Optional<Integer> getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
                return Optional.of(i);
            }
        }
        index = NOT_FOUND;
        return Optional.empty();
    }
}
