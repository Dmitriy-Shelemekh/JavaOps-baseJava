import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int RESUME_LIMIT = 10000;
    private int resumeCount = 0;
    private Resume[] storage = new Resume[RESUME_LIMIT];

    public void update(Resume r) {
        if (!isExist(r.getUuid())) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
        } else {
            get(r.getUuid()).setUuid(r.getUuid());
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

        if (isExist(r.getUuid())) {
            System.out.println(ErrorMessages.ALREADY_EXIST_NAME_ERROR.getMsg());
            return;
        }

        storage[resumeCount] = r;
        resumeCount++;
    }

    Resume get(String uuid) {
        if (!isExist(uuid)) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
            return null;
        }

        for (int i = 0; i < resumeCount; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }

        return null;
    }

    void delete(String uuid) {
        if (!isExist(uuid)) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
            return;
        }

        for (int i = 0; i < resumeCount; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[resumeCount - 1];
                storage[resumeCount - 1] = null;
                resumeCount--;
                return;
            }
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

    private boolean isExist(String id) {
        for (Resume r : getAll()) {
            if (id.equals(r.getUuid())) {
                return true;
            }
        }

        return false;
    }
}