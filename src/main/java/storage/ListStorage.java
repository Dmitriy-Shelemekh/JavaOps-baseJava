package storage;

import model.Resume;

public class ListStorage extends AbstractStorage {
    @Override
    public void clear() {

    }

    @Override
    public void save(Resume r) {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getSearchKey(String uuid) {
        return 0;
    }
}
