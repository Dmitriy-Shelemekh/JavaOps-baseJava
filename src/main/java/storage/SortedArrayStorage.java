package main.java.storage;

import main.java.model.Errors;
import main.java.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void save(Resume r) {
        if (size >= STORAGE_LIMIT) {
            System.out.println(Errors.NO_FREE_SPACE);
            return;
        }

        if (getIndex(r.getUuid()) > 0) {
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
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}