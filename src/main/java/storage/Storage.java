package storage;

import model.Resume;

public interface Storage {
    void clear();

    void save(Resume r);

    void update(Resume r);

    void delete(String uuid);

    Resume getResume(String uuid);

    Resume[] getAllResumes();

    int getSize();
}