package model;

import java.util.UUID;

public class Resume implements Comparable<Resume> {
    private final String uuid;
    private final String fullName;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        if (uuid == null || fullName == null) {
            throw new NullPointerException("Uuid/fullName must be not null!");
        }

        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode() + fullName.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) {
            return false;
        }

        return fullName.equals(resume.fullName);
    }

    @Override
    public int compareTo(Resume resume) {
        int result = fullName.compareTo(resume.fullName);
        return result != 0 ? result : uuid.compareTo(resume.uuid);
    }

    @Override
    public String toString() {
        return uuid + " " + fullName;
    }
}