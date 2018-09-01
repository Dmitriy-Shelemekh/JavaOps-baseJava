import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int arrMaxSize = 10000;
    private Resume[] storage = new Resume[arrMaxSize];

    private Resume[] sort(Resume[] resumes) {
        for (int i = 0; i < resumes.length - 1; i++) {
            if (resumes[i] == null) {
                Resume tmp = resumes[i];
                resumes[i] = resumes[i + 1];
                resumes[i + 1] = tmp;
            }
        }
        return resumes;
    }

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
                return;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(sort(storage), size());
    }

    int size() {
        int count = 0;

        for (int i = 0; i < arrMaxSize; i++) {
            if (storage[i] != null) {
                count++;
            }
        }

        return count;
    }
}
