import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int RESUME_LIMIT = 10000;
    private int resumeCount = 0;
    private Resume[] storage = new Resume[RESUME_LIMIT];

    public void update(Resume r) {
        int storageIndex = getIndex(r.getUuid());

        if (storageIndex < 0) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
        } else {
            storage[storageIndex] = r;
        }
    }

    void clear() {
        Arrays.fill(storage, 0, resumeCount - 1, null);
        resumeCount = 0;
    }

    void save(Resume r) {
        if (resumeCount >= RESUME_LIMIT) {
            System.out.println(ErrorMessages.NO_FREE_SPACE_ERROR.getMsg());
            return;
        }

        int storageIndex = getIndex(r.getUuid());

        if (storageIndex > 0) {
            System.out.println(ErrorMessages.ALREADY_EXIST_NAME_ERROR.getMsg());
        } else {
            storage[resumeCount] = r;
            resumeCount++;
        }

    }

    Resume get(String uuid) {
        int storageIndex = getIndex(uuid);

        if (storageIndex < 0) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
            return null;
        } else {
            return storage[storageIndex];
        }
    }

    void delete(String uuid) {
        int storageIndex = getIndex(uuid);

        if (storageIndex < 0) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
        } else {
            storage[storageIndex] = storage[resumeCount - 1];
            storage[resumeCount - 1] = null;
            resumeCount--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, resumeCount);
    }

    int size() {
        return resumeCount;
    }

    private int getIndex(String id) {
        for (int i = 0; i < resumeCount; i++) {
            if (id.equals(storage[i].getUuid())) {
                return i;
            }
        }

        return -1;
    }
}