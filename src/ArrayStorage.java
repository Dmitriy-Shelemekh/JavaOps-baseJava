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
        //Осторожно ArrayIndexOutOfBoundsException!
//        if (get(r.uuid) == null && storageSize < RESUME_LIMIT) {
            storage[storageSize] = r;
            storageSize++;
//        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }

        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (uuid.equals(storage[i].uuid)) {

                //Плохое решение.--------------------------------------------------------
                Resume[] arrStart = Arrays.copyOfRange(storage, 0, i);
                Resume[] arrEnd = Arrays.copyOfRange(storage, i + 1, storage.length);

                Resume[] arrResult = new Resume[arrStart.length + arrEnd.length + 1];

                System.arraycopy(arrStart, 0, arrResult, 0, arrStart.length);
                System.arraycopy(arrEnd, 0, arrResult, arrStart.length, arrEnd.length);

                storage = arrResult;
                //---------------------------------------------------------------------------

                //Это решения лучше.
                //Resume[] tmp = storage;
                //storage = (Resume[]) ArrayUtils.addAll(ArrayUtils.remove(tmp, i), new Resume[1]);

                storageSize--;
                return;
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
