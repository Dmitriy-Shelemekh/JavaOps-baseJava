package main.java.storage;

import main.java.model.Errors;
import main.java.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());

        if (isValid(index)) {
            int inputIndex = Math.abs(index) - 1;
            System.arraycopy(storage, inputIndex, storage, inputIndex + 1, size - inputIndex);
            storage[index] = r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index < 0) {
            System.out.println(Errors.NOT_IN_STORAGE);
        } else {
            System.arraycopy(storage, index + 1, storage, index, size);
            size--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}