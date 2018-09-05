import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int RESUME_LIMIT = 10000;
    private static int resumeCount = 0;
    private Resume[] storage = new Resume[RESUME_LIMIT];

    public void update(Resume r, String id) {
        if (!isResumeInStorage(r.getUuid())) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
            return;
        }

        if (isResumeInStorage(id)) {
            System.out.println(ErrorMessages.ALREADY_EXIST_NAME_ERROR.getMsg());
            return;
        }

        if (isResumeInStorage(r.getUuid())) {
            Resume resume = get(r.getUuid());
            resume.setUuid(id);
        }
    }

    void clear() {
        Arrays.fill(storage, null);
        resumeCount = 0;
    }

    void save(Resume r) {
        if (resumeCount >= RESUME_LIMIT) {
            System.out.println(ErrorMessages.NO_FREE_SPACE_ERROR.getMsg());
            return;
        }

        if (isResumeInStorage(r.getUuid())) {
            System.out.println(ErrorMessages.ALREADY_EXIST_NAME_ERROR.getMsg());
            return;
        }

        storage[resumeCount] = r;
        resumeCount++;
    }

    Resume get(String uuid) {
        Resume resume = null;

        if (!isResumeInStorage(uuid)) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
            return resume;
        }

        for (int i = 0; i < resumeCount; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }

        return resume;
    }

    void delete(String uuid) {
        if (!isResumeInStorage(uuid)) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
            return;
        }

        for (int i = 0; i < resumeCount; i++) {
            if (uuid.equals(storage[i].getUuid())) {

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

    public boolean isResumeInStorage(String id) {
        boolean result = false;

        for (Resume r : getAll()) {
            if (id.equals(r.getUuid())) {
                result = true;
            }
        }

        return result;
    }
}