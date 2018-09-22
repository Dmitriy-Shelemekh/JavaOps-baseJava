package model;

public class Resume implements Comparable<Resume> {
    private String uuid;

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
    public int compareTo(Resume r) {
        return this.uuid.compareToIgnoreCase(r.uuid);
    }

    @Override
    public String toString() {
        return uuid;
    }
}