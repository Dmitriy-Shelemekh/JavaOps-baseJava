package main.java.storage;

import main.java.model.Errors;
import main.java.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;

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

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);

        if (index < 0) {
            System.out.println(Errors.NOT_IN_STORAGE);
            return null;
        } else {
            return storage[index];
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());

        if (index < 0) {
            System.out.println(Errors.NOT_IN_STORAGE);
        } else {
            storage[index] = r;
        }
    }

    protected abstract int getIndex(String id);

    public int getSize() {
        return size;
    }
}
