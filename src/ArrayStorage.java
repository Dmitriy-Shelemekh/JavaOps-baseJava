import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int RESUME_LIMIT = 10000;
    private Resume[] storage = new Resume[RESUME_LIMIT];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        if (get(r.uuid) == null && size() < RESUME_LIMIT) {
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
                Resume[] tmp = storage;
                storage = (Resume[]) ArrayUtils.addAll(ArrayUtils.remove(tmp, i), new Resume[1]);
                return;
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

        for (int i = 0; i < RESUME_LIMIT; i++) {
            if (storage[i] != null) {
                count++;
            }
        }

        return count;
    }
}
