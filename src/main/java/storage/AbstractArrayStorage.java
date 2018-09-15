package main.java.storage;

import main.java.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    public static final int STORAGE_LIMIT = 10000;
    int resumeCount = 0;
    Resume[] storage = new Resume[STORAGE_LIMIT];

    public abstract void save(Resume r);

    public abstract void delete(String uuid);

    public Resume[] getAll() {
        return Arrays.copyOf(storage, resumeCount);
    }

    public abstract Resume get(String uuid);
//    {
//        int storageIndex = getIndex(uuid);
//
//        if (storageIndex < 0) {
//            System.out.println(main.java.modeljava.Errors.NOT_IN_STORAGE);
//            return null;
//        } else {
//            return main.java.storage[storageIndex];
//        }
//    }

    public abstract void clear();
//    {
//        Arrays.fill(main.java.storage, 0, resumeCount, null);
//        resumeCount = 0;
//    }

    public abstract void update(Resume r);
//    {
//        int storageIndex = getIndex(r.getUuid());
//
//        if (storageIndex < 0) {
//            System.out.println(main.java.modeljava.Errors.NOT_IN_STORAGE);
//        } else {
//            main.java.storage[storageIndex] = r;
//        }
//    }

    public int getIndex(String id) {
        for (int i = 0; i < resumeCount; i++) {
            if (id.equals(storage[i].getUuid())) {
                return i;
            }
        }

        return -1;
    }

    public int getResumeCount() {
        return resumeCount;
    }
}
