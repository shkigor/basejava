package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private final int RESUME_NOT_FOUND = -1;
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        Objects.requireNonNull(resume, "ERROR. Cannot update. Resume cannot be null");

        int index = obtainResumeIndexInStorage(resume);
        if (index == RESUME_NOT_FOUND) {
            System.out.println("ERROR. Cannot update. The Resume is not found in Storage");
            return;
        }
        storage[index] = resume;
    }

    public void save(Resume resume) {
        Objects.requireNonNull(resume, "ERROR. Cannot save. Resume cannot be null");
        if (size == storage.length) {
            System.out.println("ERROR. Cannot save Resume! Not enough space in Storage");
            return;
        }
        int index = obtainResumeIndexInStorage(resume);
        if (index != RESUME_NOT_FOUND) {
            System.out.println("ERROR. Cannot save. The Resume is present in Storage");
            return;
        }
        storage[size] = resume;
        size++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        Objects.requireNonNull(uuid, "ERROR. Cannot delete. UUID cannot be null");
        int index = obtainResumeIndexInStorage(get(uuid));
        if (index == RESUME_NOT_FOUND) {
            System.out.println("ERROR. Cannot delete. The Resume is not found in Storage");
            return;
        }
        size--;
        storage[index] = storage[size];
        storage[size] = null;
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

    private int obtainResumeIndexInStorage(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(resume)) {
                return i;
            }
        }
        return RESUME_NOT_FOUND;
    }
}
