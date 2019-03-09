package storage;

import exception.StorageExistException;
import exception.StorageNotExistException;
import model.Resume;

/**
 * @param <K> - Search key
 */
public abstract class AbstractStorage<K> implements Storage {

    protected abstract K getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, K searchKey);

    protected abstract boolean isExist(K searchKey);

    protected abstract void doSave(Resume resume, K searchKey);

    protected abstract void doDelete(K searchKey);

    protected abstract Resume doGet(K searchKey);

    public void update(Resume resume) {
        K searchKey = getExistSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public void save(Resume resume) {
        K searchKey = getNotExistSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    public void delete(String uuid) {
        K searchKey = getExistSearchKey(uuid);
        doDelete(searchKey);
    }

    public Resume getResume(String uuid) {
        K searchKey = getExistSearchKey(uuid);
        return doGet(searchKey);
    }

    private K getExistSearchKey(String uuid) {
        K searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new StorageNotExistException(uuid);
        }

        return searchKey;
    }

    private K getNotExistSearchKey(String uuid) {
        K elementSearchKey = getSearchKey(uuid);
        if (isExist(elementSearchKey)) {
            throw new StorageExistException(uuid);
        }

        return elementSearchKey;
    }
}