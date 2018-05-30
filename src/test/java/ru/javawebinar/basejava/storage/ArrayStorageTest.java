package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.model.Resume;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }
    @BeforeEach
    void init() {
        System.out.println("--ArrayStorageTest init BeforeEach");
    }

    @Test
    void add() {
        ArrayStorage arrayStorage = (ArrayStorage) getStorage();
        arrayStorage.add(-1000, new Resume("asd"));
        Assertions.assertEquals(3, getStorage().size());
    }

}
