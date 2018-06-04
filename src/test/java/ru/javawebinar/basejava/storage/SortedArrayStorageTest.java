package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Test
    void getIndex() {
        SortedArrayStorage sortedArrayStorage = (SortedArrayStorage) this.storage;
        Assertions.assertEquals(2, sortedArrayStorage.getIndex(UUID_3));
    }

    @Test
    void getIndexNotExist() {
        SortedArrayStorage sortedArrayStorage = (SortedArrayStorage) this.storage;
        Assertions.assertEquals(-1, sortedArrayStorage.getIndex(NOT_EXIST_UUID));
    }
}
