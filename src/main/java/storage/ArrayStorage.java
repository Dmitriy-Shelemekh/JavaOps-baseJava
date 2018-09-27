package storage;


import model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    public int getIndex(String id) {
        for (int i = 0; i < size; i++) {
            if (id.equals(storage[i].getUuid())) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void insertElement(Resume r, int index) {
        storage[size] = r;
    }

    @Override
    public void deleteElement(int index) {
        storage[index] = storage[size - 1];
    }
}