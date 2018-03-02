import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    void clear() {
        Arrays.fill(storage, 0, storageSize, null);
        storageSize = 0;
    }

    void save(Resume r) {
        if (Objects.isNull(r)) {
            return;
        }
        if (storageSize == storage.length) {
            System.out.println("Can't save! Not enough space");
            return;
        }
        storage[storageSize] = r;
        storageSize++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = storage[storageSize - 1];
                storageSize--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, storageSize);
    }

    int size() {
        return storageSize;
    }
}
