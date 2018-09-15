package main.java.storage;

import main.java.model.Errors;
import main.java.model.Resume;

import java.util.List;

/**
 * Array based main.java.storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    private int storageLimit = 10000;
    private int resumeCount = 0;
    private Resume[] storage = new Resume[storageLimit];

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        if (resumeCount >= storageLimit) {
            System.out.println(Errors.NO_FREE_SPACE);
            return;
        }

        int resumeIndex = getIndex(r.getUuid());

        if (resumeIndex > 0) {
            System.out.println(Errors.ALREADY_EXIST);
        } else {
            storage[resumeCount] = r;
            resumeCount++;
        }
    }

    @Override
    public void delete(String uuid) {
        int resumeIndex = getIndex(uuid);

        if (resumeIndex < 0) {
            System.out.println(Errors.NOT_IN_STORAGE);
        } else {
            storage[resumeIndex] = storage[resumeCount - 1];
            storage[resumeCount - 1] = null;
            resumeCount--;
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

//    private int getIndex(String id) {
//        for (int i = 0; i < resumeCount; i++) {
//            if (id.equals(main.java.storage[i].getUuid())) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
}