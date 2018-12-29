package storage;

import model.Resume;

public interface Storage {
    void clear();

    void save(Resume resume);

    void update(Resume resume);

    void delete(String uuid);

    Resume getResume(String uuid);

    Resume[] getAllResumes();

    int getSize();
}