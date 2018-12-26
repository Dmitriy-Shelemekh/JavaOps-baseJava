package storage;

import exception.StorageExistException;
import exception.StorageNotExistException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getElementIndex(String uuid);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Resume resume, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    public void update(Resume resume) {
        Object searchKey = getExistElementIndex(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public void save(Resume resume) {
        Object searchKey = getNotExistElementIndex(resume.getUuid());
        doSave(resume, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistElementIndex(uuid);
        doDelete(searchKey);
    }

    public Resume getResume(String uuid) {
        Object searchKey = getExistElementIndex(uuid);
        return doGet(searchKey);
    }

    private Object getExistElementIndex(String uuid) {
        Object elementIndex = getElementIndex(uuid);
        if (!isExist(elementIndex)) {
            throw new StorageNotExistException(uuid);
        }

        return elementIndex;
    }

    private Object getNotExistElementIndex(String uuid) {
        Object elementIndex = getElementIndex(uuid);
        if (isExist(elementIndex)) {
            throw new StorageExistException(uuid);
        }

        return elementIndex;
    }
}