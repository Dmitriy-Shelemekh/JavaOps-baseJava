package storage;


import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    public void insertElement(Resume r, int index) {
        int inputIndex = Math.abs(index) - 1;
        System.arraycopy(storage, inputIndex, storage, inputIndex + 1, size - inputIndex);
        storage[inputIndex] = r;
    }

    @Override
    public void fillDeletedElement(int index) {
        int moveCount = size - index - 1;
        if (moveCount > 0) {
            System.arraycopy(storage, index + 1, storage, index, moveCount);
        }
    }
}