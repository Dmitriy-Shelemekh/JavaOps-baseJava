package main.java.storage;

import main.java.model.Errors;
import main.java.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
//    private int storageLimit = 10000;
//    private int resumeCount = 0;
//    private Resume[] storage = new Resume[storageLimit];


//    @Override
//    public Resume get(String uuid) {
//        return null;
//    }

    @Override
    public void clear() {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        if (size >= STORAGE_LIMIT) {
            System.out.println(Errors.NO_FREE_SPACE);
            return;
        }

        int resumeIndex = getIndex(r.getUuid());

        if (resumeIndex > 0) {
            System.out.println(Errors.ALREADY_EXIST);
        } else {
            for (int i = 0; i < size; i++) {
                if (r.compareTo(storage[i]) > 0 && r.compareTo(storage[i + 1]) < 0) {
                    System.arraycopy(storage, i, storage, i + 1, size);
                    storage[i + 1] = r;
                    size++;
                    return;
                }
            }

            System.arraycopy(storage, 0, storage, size, size);
            storage[0] = r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int resumeIndex = getIndex(uuid);

        if (resumeIndex < 0) {
            System.out.println(Errors.NOT_IN_STORAGE);
        } else {
            System.arraycopy(storage, resumeIndex + 1, storage, resumeIndex, size);
            size--;
        }
    }

    @Override
    public Resume[] getAll() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
