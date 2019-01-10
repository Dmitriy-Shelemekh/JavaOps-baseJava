package storage;

import model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    @Override
    public Integer getElementSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "Some Name");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }

    @Override
    public void insertElement(Resume resume, int index) {
        int inputIndex = Math.abs(index) - 1;
        System.arraycopy(storage, inputIndex, storage, inputIndex + 1, size - inputIndex);
        storage[inputIndex] = resume;
    }

    @Override
    public void fillDeletedElement(int index) {
        int moveCount = size - index - 1;
        if (moveCount > 0) {
            System.arraycopy(storage, index + 1, storage, index, moveCount);
        }
    }
}