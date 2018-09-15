package main.java.storage;

import main.java.model.Errors;
import main.java.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;

//    public abstract void save(Resume r);

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
        int storageIndex = getIndex(uuid);

        if (storageIndex < 0) {
            System.out.println(Errors.NOT_IN_STORAGE);
            return null;
        } else {
            return storage[storageIndex];
        }
    }

//    public abstract void clear();
//    {
//        Arrays.fill(main.java.storage, 0, size, null);
//        size = 0;
//    }

//    public abstract void update(Resume r);
//    {
//        int storageIndex = getIndex(r.getUuid());
//
//        if (storageIndex < 0) {
//            System.out.println(main.java.modeljava.Errors.NOT_IN_STORAGE);
//        } else {
//            main.java.storage[storageIndex] = r;
//        }
//    }

    protected abstract int getIndex(String id);
//    {
//        for (int i = 0; i < size; i++) {
//            if (id.equals(storage[i].getUuid())) {
//                return i;
//            }
//        }
//
//        return -1;
//    }

    public int getSize() {
        return size;
    }
}
