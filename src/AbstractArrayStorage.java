import java.util.Arrays;

public abstract class AbstractArrayStorage {
    int storageLimit = 10000;
    int resumeCount = 0;
    Resume[] storage = new Resume[storageLimit];

    abstract void save(Resume r);

    abstract void delete(String uuid);

    Resume[] getAll() {
        return Arrays.copyOf(storage, resumeCount);
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

    void clear() {
        Arrays.fill(storage, 0, resumeCount, null);
        resumeCount = 0;
    }

    void update(Resume r) {
        int storageIndex = getIndex(r.getUuid());

        if (storageIndex < 0) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
        } else {
            storage[storageIndex] = r;
        }
    }

    int getIndex(String id) {
        for (int i = 0; i < resumeCount; i++) {
            if (id.equals(storage[i].getUuid())) {
                return i;
            }
        }

        return -1;
    }

    int getResumeCount() {
        return resumeCount;
    }
}
