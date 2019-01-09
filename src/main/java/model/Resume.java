package model;

import java.util.UUID;

public class Resume implements Comparable<Resume> {
    private String uuid;
    private String fullName;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        if (uuid == null || fullName == null) {
            throw new NullPointerException("Uuid/fullName must be not null");
        }

        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
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

        return uuid.equals(resume.uuid);
    }

    @Override
    public int compareTo(Resume resume) {
        return this.uuid.compareToIgnoreCase(resume.uuid);
    }

    @Override
    public String toString() {
        return uuid;
    }
}