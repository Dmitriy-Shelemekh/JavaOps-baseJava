package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

//    @Override
//    public void delete(String uuid) {
//
//    }

    private List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        list.set((Integer) searchKey, r);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        list.add(r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return list.get((Integer) searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        list.remove(((Integer) searchKey).intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
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
