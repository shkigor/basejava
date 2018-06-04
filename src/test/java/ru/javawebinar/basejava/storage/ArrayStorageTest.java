package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

    @Test
    void getIndex() {
        ArrayStorage arrayStorage = (ArrayStorage) this.storage;
        Assertions.assertEquals(2, arrayStorage.getIndex(UUID_3));
    }

    @Test
    void getIndexNotExist() {
        ArrayStorage arrayStorage = (ArrayStorage) this.storage;
        Assertions.assertEquals(-1, arrayStorage.getIndex(NOT_EXIST_UUID));
    }
}
