import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int arrMaxSize = 10000;
    private Resume[] storage = new Resume[arrMaxSize];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        if (get(r.uuid) == null && size() < arrMaxSize) {
            storage[size()] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }

        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int count = 0;

        for (Resume r : storage) {
            if (r != null) {
                count++;
            }
        }

        return count;
    }
}
