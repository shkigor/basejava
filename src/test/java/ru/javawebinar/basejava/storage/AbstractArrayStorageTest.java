package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.*;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {

    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

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
    }

    @Test
    void update() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }
}