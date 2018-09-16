package main.java.storage;

import main.java.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    public void insertElement(Resume r, int index) {
        int inputIndex = Math.abs(index) - 1;
        System.arraycopy(storage, inputIndex, storage, inputIndex + 1, size - inputIndex);
        storage[inputIndex] = r;
    }

    @Override
    public void deleteElement(int index) {
        System.arraycopy(storage, index + 1, storage, index, size);
    }
}