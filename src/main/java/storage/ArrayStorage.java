package main.java.storage;

import main.java.model.Errors;
import main.java.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    public void save(Resume r) {
        if (size >= STORAGE_LIMIT) {
            System.out.println(Errors.NO_FREE_SPACE);
            return;
        }

        if (getIndex(r.getUuid()) > 0) {
            System.out.println(Errors.ALREADY_EXIST);
        } else {
            storage[size] = r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index < 0) {
            System.out.println(Errors.NOT_IN_STORAGE);
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    protected int getIndex(String id) {
        for (int i = 0; i < size; i++) {
            if (id.equals(storage[i].getUuid())) {
                return i;
            }
        }

        return -1;
    }
}