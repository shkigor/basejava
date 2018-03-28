package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.ArrayStorage;
import ru.javawebinar.basejava.storage.SortedArrayStorage;
import ru.javawebinar.basejava.storage.Storage;

import java.util.Arrays;

/**
 * Test for ru.javawebinar.basejava.storage.ArrayStorage
 */
public class MainTestArrayStorage {
    //    private static final Storage ARRAY_STORAGE = new ArrayStorage();
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1");
        final Resume r2 = new Resume("uuid2");
        final Resume r3 = new Resume("uuid3");
        final Resume r4 = new Resume("uuid4");

        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r2);
//        ARRAY_STORAGE.save(null);
        printAll();

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        ARRAY_STORAGE.update(r2);
//        ARRAY_STORAGE.update(null);
        final Resume r5 = new Resume("uuid5");
        ARRAY_STORAGE.update(r5);

        System.out.println("Index of r2: " + Arrays.binarySearch(ARRAY_STORAGE.getAll(), 0, ARRAY_STORAGE.size(), r2));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
//        ARRAY_STORAGE.delete(null);
        ARRAY_STORAGE.delete(r4.getUuid());
        ARRAY_STORAGE.delete("dummy");
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
