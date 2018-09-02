import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int RESUME_LIMIT = 10000;
    private static int storageSize = 0;
    private Resume[] storage = new Resume[RESUME_LIMIT];

    void clear() {
        Arrays.fill(storage, null);
        storageSize = 0;
    }

    void save(Resume r) {
        if (get(r.uuid) == null && size() < RESUME_LIMIT) {
            storage[size()] = r;
            storageSize++;
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
                storageSize--;
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
        return storageSize;
    }
}
