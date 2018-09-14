/**
 * Initial resume class
 */

public class Resume {

    // Unique identifier
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    int compareTo(Resume r) {
        return this.uuid.compareToIgnoreCase(r.uuid);
    }

    @Override
    public String toString() {
        return uuid;
    }
}