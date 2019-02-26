package model;

import lombok.Getter;

@Getter
public enum SectionType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private String name;

    SectionType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}