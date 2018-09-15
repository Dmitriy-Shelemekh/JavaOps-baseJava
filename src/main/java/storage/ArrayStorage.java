package main.java.storage;

import main.java.model.Errors;
import main.java.model.Resume;

/**
 * Array based main.java.storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
//    private int storageLimit = 10000;
//    private int resumeCount = 0;
//    private Resume[] storage = new Resume[storageLimit];

//    @Override
//    public Resume get(String uuid) {
//        return null;
//    }

    @Override
    protected int getIndex(String id) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        if (size >= STORAGE_LIMIT) {
            System.out.println(Errors.NO_FREE_SPACE);
            return;
        }

        int resumeIndex = getIndex(r.getUuid());

        if (resumeIndex > 0) {
            System.out.println(Errors.ALREADY_EXIST);
        } else {
            storage[size] = r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int resumeIndex = getIndex(uuid);

        if (resumeIndex < 0) {
            System.out.println(Errors.NOT_IN_STORAGE);
        } else {
            storage[resumeIndex] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

//    @Override
//    public Resume[] getAll() {
//        return Arrays.copyOf(storage, size);
//    }

    @Override
    public int size() {
        return 0;
    }

//    private int getIndex(String id) {
//        for (int i = 0; i < size; i++) {
//            if (id.equals(main.java.storage[i].getUuid())) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
}