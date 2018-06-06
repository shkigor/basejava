package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public abstract class AbstractArrayStorageTest {

    protected final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String NOT_EXIST_UUID = "NOT_EXIST_UUID";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void init() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        final Resume resume = new Resume(UUID_3);
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        final Resume resume = new Resume();
        storage.update(resume);
    }

    @Test(expected = NullPointerException.class)
    public void updateNull() {
        storage.update(null);
    }

    @Test
    public void save() {
        final Resume resume = new Resume();
        storage.save(resume);
        assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        final Resume resume = new Resume(UUID_3);
        storage.save(resume);
    }

    @Test(expected = StorageException.class)
    public void saveStorageOverflow() {
        for (int i = 0; i < 10000; i++) {
            Resume resume = new Resume();
            storage.save(resume);
        }
    }

    @Test(expected = NullPointerException.class)
    public void saveNull() {
        storage.save(null);
    }

    @Test
    public void delete() {
        storage.delete(UUID_3);
        assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(NOT_EXIST_UUID);
    }

    @Test(expected = NullPointerException.class)
    public void deleteNull() {
        storage.delete(null);
    }

    @Test
    public void get() {
        Resume result = storage.get(UUID_3);
        assertEquals(UUID_3, result.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(NOT_EXIST_UUID);
    }

    @Test(expected = NullPointerException.class)
    public void getNull() {
        storage.get(null);
    }

    @Test
    public void getAll() {
        Resume[] result = storage.getAll();
        assertArrayEquals(new Resume[] { new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3) }, result);
    }
}