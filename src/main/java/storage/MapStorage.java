package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }

//    @Override
//    public void clear() {
//
//    }
//
//    @Override
//    public void save(Resume r) {
//
//    }
//
//    @Override
//    public void update(Resume r) {
//
//    }
//
//    @Override
//    public void delete(String uuid) {
//
//    }
//
//    @Override
//    public Resume get(String uuid) {
//        return null;
//    }
//
//    @Override
//    public Resume[] getAll() {
//        return new Resume[0];
//    }
//
//    @Override
//    public int getSize() {
//        return 0;
//    }
//
//    @Override
//    public int getSearchKey(String uuid) {
//        return 0;
//    }
}
