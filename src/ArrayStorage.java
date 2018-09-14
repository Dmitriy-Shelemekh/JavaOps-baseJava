/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    void save(Resume r) {
        if (resumeCount >= storageLimit) {
            System.out.println(ErrorMessages.NO_FREE_SPACE_ERROR.getMsg());
            return;
        }

        int resumeIndex = getIndex(r.getUuid());

        if (resumeIndex > 0) {
            System.out.println(ErrorMessages.ALREADY_EXIST_NAME_ERROR.getMsg());
        } else {
            storage[resumeCount] = r;
            resumeCount++;
        }
    }

    @Override
    void delete(String uuid) {
        int resumeIndex = getIndex(uuid);

        if (resumeIndex < 0) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
        } else {
            if (resumeIndex == resumeCount - 1) {
                storage[resumeCount - 1] = null;
            } else {
                storage[resumeIndex] = storage[resumeCount - 1];
                storage[resumeCount - 1] = null;
            }

            resumeCount--;
        }
    }
}