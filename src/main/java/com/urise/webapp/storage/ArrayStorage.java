package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static int RESUME_NOT_FOUND = -1;

    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        if (Objects.isNull(r)) {
            System.out.println("ERROR. Cannot update. Resume cannot be null");
            return;
        }
        // check if resume present
        int index = obtainResumeIndexInStorage(r);
        if (index == RESUME_NOT_FOUND) {
            System.out.println("ERROR. Cannot update. The Resume is not found in Storage");
            return;
        }
        storage[index] = r;
    }

    public void save(Resume r) {
        if (Objects.isNull(r)) {
            System.out.println("ERROR. Cannot save. Resume cannot be null");
            return;
        }
        if (size == storage.length) {
            System.out.println("ERROR. Cannot save Resume! Not enough space in Storage");
            return;
        }
        // check if resume not present
        int index = obtainResumeIndexInStorage(r);
        if (index != RESUME_NOT_FOUND) {
            System.out.println("ERROR. Cannot save. The Resume is present in Storage");
            return;
        }
        storage[size] = r;
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
        if (Objects.isNull(uuid)) {
            System.out.println("ERROR. Cannot delete. UUID cannot be null");
            return;
        }
        // check if resume present
        int index = obtainResumeIndexInStorage(get(uuid));
        if (index == RESUME_NOT_FOUND) {
            System.out.println("ERROR. Cannot delete. The Resume is not found in Storage");
            return;
        }
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
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

    private int obtainResumeIndexInStorage(Resume r) {
        for (int index = 0; index < size; index++) {
            if (storage[index].equals(r)) {
                return index;
            }
        }
        return RESUME_NOT_FOUND;
    }
}
