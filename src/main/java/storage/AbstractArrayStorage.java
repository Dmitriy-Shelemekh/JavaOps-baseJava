package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Errors;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    public static final int STORAGE_LIMIT = 10000;
    Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());

        if (isValid(index)) {
            insertElement(r, index);
            size++;
        }
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());

        if (index < 0) {
            throw new NotExistStorageException(Errors.NOT_IN_STORAGE.toString());
        } else {
            storage[index] = r;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index < 0) {
            throw new IllegalArgumentException(Errors.NOT_IN_STORAGE.toString());
        } else {
            deleteElement(index);
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
            throw new NotExistStorageException(Errors.NOT_IN_STORAGE.toString());
        } else {
            return storage[index];
        }
    }

    public abstract int getIndex(String id);

    public abstract void insertElement(Resume r, int index);

    public abstract void deleteElement(int index);

    public int getSize() {
        return size;
    }

    private boolean isValid(int index) {
        if (size >= STORAGE_LIMIT) {
            throw new RuntimeException(Errors.NO_FREE_SPACE.toString());
        }

        if (index >= 0) {
            throw new ExistStorageException(Errors.ALREADY_EXIST.toString()); //System.out.println(Errors.ALREADY_EXIST);
        }

        return true;
    }
}