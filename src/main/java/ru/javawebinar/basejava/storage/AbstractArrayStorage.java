package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int NOT_FOUND = -1;
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        Objects.requireNonNull(resume, "ERROR update. Resume cannot be null");
        int index = getIndex(resume.getUuid());
        if (index <= NOT_FOUND) {
            System.out.println("ERROR update. Resume " + resume.getUuid() + " not exist");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        Objects.requireNonNull(resume, "ERROR save. Resume cannot be null");
        int position = getIndex(resume.getUuid());
        if (position > NOT_FOUND) {
            System.out.println("ERROR save. Resume " + resume.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            add(position, resume);
        }
    }

    public void delete(String uuid) {
        Objects.requireNonNull(uuid, "ERROR delete. uuid cannot be null");
        int index = getIndex(uuid);
        if (index <= NOT_FOUND) {
            System.out.println("ERROR delete. Resume " + uuid + " not exist");
        } else {
            remove(index);
        }
    }

    public Resume get(String uuid) {
        Objects.requireNonNull(uuid, "ERROR get. uuid cannot be null");
        int index = getIndex(uuid);
        if (index <= NOT_FOUND) {
            System.out.println("ERROR get. Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract void add(int index, Resume resume);
    protected abstract int getIndex(String uuid);
    protected abstract void remove(int index);
}
