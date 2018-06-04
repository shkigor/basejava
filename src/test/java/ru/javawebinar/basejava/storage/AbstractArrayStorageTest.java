package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.*;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {

    protected final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String NOT_EXIST_UUID = "NOT_EXIST_UUID";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach AbstractArrayStorageTest setUp");
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach AbstractArrayStorageTest tearDown");
    }

    @Test
    void size() {
        Assertions.assertEquals(3, storage.size());
    }

    @Test
    void clear() {
        storage.clear();
        Assertions.assertEquals(0, storage.size());
    }

    @Test
    void update() {
        final Resume resume = new Resume(UUID_3);
        storage.update(resume);
        Assertions.assertEquals(resume, storage.get(UUID_3));
    }

    @Test
    void updateNotExist() {
        final Resume resume = new Resume();
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.update(resume));
    }

    @Test
    void updateNull() {
        Assertions.assertThrows(NullPointerException.class, () -> storage.update(null));
    }

    @Test
    void save() {
        final Resume resume = new Resume();
        storage.save(resume);
        Assertions.assertEquals(4, storage.size());
    }

    @Test
    void saveExist() {
        final Resume resume = new Resume(UUID_3);
        Assertions.assertThrows(ExistStorageException.class, () -> storage.save(resume));
    }

    @Test
    void saveNull() {
        Assertions.assertThrows(NullPointerException.class, () -> storage.save(null));
    }

    @Test
    void delete() {
        storage.delete(UUID_3);
        Assertions.assertEquals(2, storage.size());
    }

    @Test
    void deleteNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.delete(NOT_EXIST_UUID));
    }

    @Test
    void deleteNull() {
        Assertions.assertThrows(NullPointerException.class, () -> storage.delete(null));
    }

    @Test
    void get() {
        Resume result = storage.get(UUID_3);
        Assertions.assertEquals(UUID_3, result.getUuid());
    }

    @Test
    void getNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(NOT_EXIST_UUID));
    }

    @Test
    void getNull() {
        Assertions.assertThrows(NullPointerException.class, () -> storage.get(null));
    }

    @Test
    void getAll() {
        Resume[] result = storage.getAll();
        Assertions.assertArrayEquals(new Resume[] { new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3) }, result);
    }
}