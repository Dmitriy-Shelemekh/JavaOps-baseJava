package storage;


import model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void insertElement(Resume r, int index) {
        storage[size] = r;
    }

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

//    @Override
//    protected void fillDeletedElement(int index) {
//        storage[index] = storage[size - 1];
//    }
//
//    @Override
//    protected void insertElement(Resume r, int index) {
//        storage[size] = r;
//    }
//
//    @Override
//    protected Integer getSearchKey(String uuid) {
//        for (int i = 0; i < size; i++) {
//            if (uuid.equals(storage[i].getUuid())) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
    //    @Override
//    public int getSearchKey(String id) {
//        for (int i = 0; i < size; i++) {
//            if (id.equals(storage[i].getUuid())) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
//
//    @Override
//    public void insertElement(Resume r, int index) {
//        storage[size] = r;
//    }
//
//    @Override
//    public void deleteElement(int index) {
//        storage[index] = storage[size - 1];
//    }
}