package model;

import lombok.Data;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Data
public class Resume implements Comparable<Resume> {
    private final String uuid;
    private final String fullName;
    private Map<ContactType, Object> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "Uuid must be not null");
        Objects.requireNonNull(fullName, "FullName must be not null");

        this.uuid = uuid;
        this.fullName = fullName;
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