package main.java.model;

/**
 * Initial resume class
 */

public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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