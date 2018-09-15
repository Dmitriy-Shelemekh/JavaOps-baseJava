package main.java.storage;

import main.java.model.Errors;
import main.java.model.Resume;

public class SortedArrayStorage extends AbstractArrayStorage {
    private int storageLimit = 10000;
    private int resumeCount = 0;
    private Resume[] storage = new Resume[storageLimit];

    @Override
    protected int getIndex(String id) {
        return 0;
    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        if (resumeCount >= storageLimit) {
            System.out.println(Errors.NO_FREE_SPACE);
            return;
        }

        int resumeIndex = getIndex(r.getUuid());

        if (resumeIndex > 0) {
            System.out.println(Errors.ALREADY_EXIST);
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
    public void delete(String uuid) {
        int resumeIndex = getIndex(uuid);

        if (resumeIndex < 0) {
            System.out.println(Errors.NOT_IN_STORAGE);
        } else {
            System.arraycopy(storage, resumeIndex + 1, storage, resumeIndex, resumeCount);
            resumeCount--;
        }
    }

    @Override
    public Resume[] getAll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

//        private int getIndex(String id) {
//        for (int i = 0; i < resumeCount; i++) {
//            if (id.equals(main.java.storage[i].getUuid())) {
//                return i;
//            }
//        }
//
//        return -1;

}
