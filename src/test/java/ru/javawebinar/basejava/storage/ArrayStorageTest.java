package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    public ArrayStorageTest() {
        storage = new ArrayStorage();
    }
    @BeforeEach
    void init() {
        System.out.println("--ArrayStorageTest init BeforeEach");
    }

}
