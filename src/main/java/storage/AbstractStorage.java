package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Resume resume, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    public void update(Resume resume) {
        Object searchKey = getExistKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public void save(Resume resume) {
        Object searchKey = getNotExistKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistKey(uuid);
        return doGet(searchKey);
    }

    private Object getExistKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}