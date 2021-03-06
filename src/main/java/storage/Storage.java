package storage;

import model.Resume;

import java.util.List;

public interface Storage {
    void clear();

    void save(Resume resume);

    void update(Resume resume);

    void delete(String uuid);

    Resume getResume(String uuid);

    List<Resume> getAllResumes();

    int getSize();
}