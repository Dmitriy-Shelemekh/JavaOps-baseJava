package storage;

import exception.StorageExistException;
import exception.StorageNotExistException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Resume resume, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    public void update(Resume resume) {
        Object searchKey = getExistSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public void save(Resume resume) {
        Object searchKey = getNotExistSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        doDelete(searchKey);
    }

    public Resume getResume(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        return doGet(searchKey);
    }

    private Object getExistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new StorageNotExistException(uuid);
        }

        return searchKey;
    }

    private Object getNotExistSearchKey(String uuid) {
        Object elementSearchKey = getSearchKey(uuid);
        if (isExist(elementSearchKey)) {
            throw new StorageExistException(uuid);
        }

        return elementSearchKey;
    }
}