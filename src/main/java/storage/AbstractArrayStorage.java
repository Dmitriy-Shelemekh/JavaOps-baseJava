package storage;

import exception.StorageOverflowException;
import model.Resume;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int getSize() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doUpdate(Resume resume, Object index) {
        storage[(Integer) index] = resume;
    }

    public List<Resume> getAllResumes() {
        List<Resume> allResumes = Arrays.asList(storage);

        List<Resume> result = allResumes.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return result;
    }

    @Override
    protected void doSave(Resume resume, Object index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageOverflowException(resume.getUuid());
        } else {
            insertElement(resume, (Integer) index);
            size++;
        }
    }

    @Override
    public void doDelete(Object index) {
        fillDeletedElement((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    public Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract Integer getSearchKey(String uuid);
}