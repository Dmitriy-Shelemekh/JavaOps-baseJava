package storage;

import exception.StorageExistException;
import exception.StorageNotExistException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getElementSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Resume resume, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    public void update(Resume resume) {
        Object searchKey = getExistElementSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public void save(Resume resume) {
        Object searchKey = getNotExistElementSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistElementSearchKey(uuid);
        doDelete(searchKey);
    }

    public Resume getResume(String uuid) {
        Object searchKey = getExistElementSearchKey(uuid);
        return doGet(searchKey);
    }

    private Object getExistElementSearchKey(String uuid) {
        Object elementSearchKey = getElementSearchKey(uuid);
        if (!isExist(elementSearchKey)) {
            throw new StorageNotExistException(uuid);
        }

        return elementSearchKey;
    }

    private Object getNotExistElementSearchKey(String uuid) {
        Object elementSearchKey = getElementSearchKey(uuid);
        if (isExist(elementSearchKey)) {
            throw new StorageExistException(uuid);
        }

        return elementSearchKey;
    }
}