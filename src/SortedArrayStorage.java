public class SortedArrayStorage extends AbstractArrayStorage {
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
            for (int i = 0; i < resumeCount; i++) {
                if (r.compareTo(storage[i]) > 0 && r.compareTo(storage[i + 1]) < 0) {
                    System.arraycopy(storage, i, storage, i + 1, resumeCount);
                    storage[i + 1] = r;
                    resumeCount++;
                    return;
                }
            }

            System.arraycopy(storage, 0, storage, resumeCount, resumeCount);
            storage[0] = r;
            resumeCount++;
        }
    }

    @Override
    void delete(String uuid) {
        int resumeIndex = getIndex(uuid);

        if (resumeIndex < 0) {
            System.out.println(ErrorMessages.NO_IN_STORAGE_ERROR.getMsg());
        } else {
            System.arraycopy(storage, resumeIndex + 1, storage, resumeIndex, resumeCount);
            resumeCount--;
        }
    }
}
