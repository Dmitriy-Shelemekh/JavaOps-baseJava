package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 1000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doUpdate(Resume r, Object index) {
        storage[(Integer) index] = r;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected void doSave(Resume r, Object index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r, (Integer) index);
            size++;
        }
    }

//    public void save(Resume r) {
//        int index = getSearchKey(r.getUuid());
//        if (index >= 0) {
//            throw new ExistStorageException(r.getUuid());
//        } else if (size == STORAGE_LIMIT) {
//            throw new StorageException("Starage overflow", r.getUuid());
//        } else {
//            insertElement(r, index);
//            size++;
//        }
//    }

    public void doDelete(Object index) {
        fillDeletedElement((Integer) index);
        storage[size - 1] = null;
        size--;

//        int index = getSearchKey(uuid);
//        if (index < 0) {
//            throw new NotExistStorageException(uuid);
//        } else {
//            fillDeletedElement(index);
//            storage[size - 1] = null;
//        }
    }

    public Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    protected abstract Integer getSearchKey(String uuid);

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

//    @Override
//    protected void doDelete(Object searchKey) {
//
//    }

//    @Override
//    protected Resume doGet(Object searchKey) {
//        return null;
//    }
    //
    //    public void clear() {
//    @Override

//    }

//    @Override
//    public void delete(String uuid) {
//
//    }

//    @Override
//    public int getSize() {
//        return 0;
//    }

//    @Override
//    public int getSearchKey(String uuid) {
//        return 0;
//    }

    //    public static final int STORAGE_LIMIT = 10000;
//    Resume[] storage = new Resume[STORAGE_LIMIT];
//    int size = 0;
//
//    public void clear() {
//        Arrays.fill(storage, 0, size, null);
//        size = 0;
//    }
//
//    public void save(Resume r) {
//        int index = getSearchKey(r.getUuid());
//
//        if (isValid(index)) {
//            insertElement(r, index);
//            size++;
//        }
//    }
//
//    public void update(Resume r) {
//        int index = getSearchKey(r.getUuid());
//
//        if (index < 0) {
//            throw new NotExistStorageException(Errors.NOT_IN_STORAGE.toString());
//        } else {
//            storage[index] = r;
//        }
//    }
//
//    public void delete(String uuid) {
//        int index = getSearchKey(uuid);
//
//        if (index < 0) {
//            throw new IllegalArgumentException(Errors.NOT_IN_STORAGE.toString());
//        } else {
//            deleteElement(index);
//            storage[size - 1] = null;
//            size--;
//        }
//    }
//
//    public Resume[] getAll() {
//        return Arrays.copyOf(storage, size);
//    }
//
//    public Resume get(String uuid) {
//        int index = getSearchKey(uuid);
//
//        if (index < 0) {
//            throw new NotExistStorageException(Errors.NOT_IN_STORAGE.toString());
//        } else {
//            return storage[index];
//        }
//    }
//
//    public abstract int getSearchKey(String id);
//
//    public abstract void insertElement(Resume r, int index);
//
//    public abstract void deleteElement(int index);
//
//    public int getSize() {
//        return size;
//    }
//
//    private boolean isValid(int index) {
//        if (size >= STORAGE_LIMIT) {
//            throw new RuntimeException(Errors.NO_FREE_SPACE.toString());
//        }
//
//        if (index >= 0) {
//            throw new ExistStorageException(Errors.ALREADY_EXIST.toString()); //System.out.println(Errors.ALREADY_EXIST);
//        }
//
//        return true;
//    }
}