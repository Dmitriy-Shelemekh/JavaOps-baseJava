package main.java.storage;

import main.java.model.Errors;
import main.java.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;

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

    protected abstract int getIndex(String id);

    public int getSize() {
        return size;
    }

    boolean isValid(Resume r) {
        if (size >= STORAGE_LIMIT) {
            System.out.println(Errors.NO_FREE_SPACE);
            return false;
        }

        if (getIndex(r.getUuid()) > 0) {
            System.out.println(Errors.ALREADY_EXIST);
            return false;
        }

        return true;
    }
}