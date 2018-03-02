import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (Objects.isNull(storage[i])) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume r : storage) {
            if (Objects.nonNull(r) && r.toString().equals(uuid)) {
                return r;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (Objects.nonNull(storage[i]) && storage[i].toString().equals(uuid)) {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        final int resultStorageSize = size();
        Resume[] resultStorage = new Resume[resultStorageSize];
        int index = 0;

        for (Resume r : storage) {
            if (Objects.nonNull(r)) {
                resultStorage[index] = r;
                index++;
            }
        }
        return resultStorage;
    }

    int size() {
        int count = 0;
        for (Resume r : storage) {
            if (Objects.nonNull(r)) {
                count++;
            }
        }
        return count;
    }
}
