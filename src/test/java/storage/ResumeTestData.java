package storage;

import model.*;

import java.util.HashMap;
import java.util.Map;

import static model.ContactType.*;
import static model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Some Test Name");
        Map<ContactType, Object> contacts = new HashMap<>();
        Map<SectionType, Section> sections = new HashMap<>();

        contacts.put(PHONE_MOBILE, "+7(999)333-33-33");
        contacts.put(PHONE_HOME, "+7(495)333-33-33");
        contacts.put(SKYPE, new Link("test.skype", "skype:test.skype"));
        contacts.put(EMAIL, new Link("testWork@mail.com", "mailto:testWork@mail.com"));
        contacts.put(GITHUB, new Link("Профиль на GitHub", "https://github.com/testName"));
        contacts.put(HOME_PAGE, new Link("Домашняя страница", "https://testName.com"));
        resume.setContacts(contacts);

        sections.put(OBJECTIVE, new TextSection("Позиция"));
        sections.put(PERSONAL, new TextSection("Личные качества"));
        sections.put(ACHIEVEMENT, new TextSection("Достижения"));
        sections.put(QUALIFICATIONS, new TextSection("Квалификация"));
        sections.put(EXPERIENCE, new TextSection("Опыт работы"));
        sections.put(EDUCATION, new TextSection("Образование"));
        resume.setSections(sections);
    }
}
