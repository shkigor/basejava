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
        int sizeResume = size();
        if (sizeResume == storage.length) {
            System.out.println("Can't save! Not enough space");
            return;
        }
        storage[sizeResume] = r;
        storageSize++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].toString().intern() == uuid.intern()) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int removedItemIndex = -1;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].toString().intern() == uuid.intern()) {
                storage[i] = null;
                storageSize--;
                removedItemIndex = i;
                break;
            }
        }
        if (removedItemIndex != -1) {
            // Move items
            for (int i = removedItemIndex; i < storageSize + 1; i++) {
                if (i + 1 < storage.length && Objects.nonNull(storage[i + 1])) {
                    storage[i] = storage[i + 1];
                    storage[i + 1] = null;
                }
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
        int count = 0;
        for (Resume r : storage) {
            if (Objects.nonNull(r)) {
                count++;
            } else {
                break;
            }
        }
        storageSize = count;
        return count;
    }
}
