package storage;

import model.*;
import utils.Period;

import java.time.LocalDate;
import java.util.*;

import static model.ContactType.*;
import static model.SectionType.*;

public class TestData {
    private static String OBJECTIVE_CONTENT = "Текст блока '" + OBJECTIVE.getName() + "'";
    private static String PERSONAL_CONTENT = "Текст блока '" + PERSONAL.getName() + "'";

    public static Resume createResume(String uuid, String name) {
        Resume resume = new Resume(uuid, name);

        resume.setContacts(createContracts());
        resume.setSections(createSections());

        return resume;
    }

    public static Map<SectionType, Section> createSections() {
        Map<SectionType, Section> sections = new HashMap<>();

        sections.put(OBJECTIVE, new TextSection(OBJECTIVE_CONTENT));
        sections.put(PERSONAL, new TextSection(PERSONAL_CONTENT));
        sections.put(ACHIEVEMENT, new ListSection(createStringsList()));
        sections.put(QUALIFICATIONS, new ListSection(createStringsList()));
        sections.put(EXPERIENCE, new OrganizationSection(createOrganizationsList()));
        sections.put(EDUCATION, new OrganizationSection(createOrganizationsList()));

        return sections;
    }

    public static Map<ContactType, Object> createContracts() {
        Map<ContactType, Object> contacts = new HashMap<>();

        contacts.put(PHONE_MOBILE, "+7(999)333-33-33");
        contacts.put(PHONE_HOME, "+7(495)333-33-33");
        contacts.put(SKYPE, new Link("test.skype", "skype:test.skype"));
        contacts.put(EMAIL, new Link("testWork@mail.com", "mailto:testWork@mail.com"));
        contacts.put(GITHUB, new Link("Профиль на GitHub", "https://github.com/testName"));
        contacts.put(HOME_PAGE, new Link("Домашняя страница", "https://testName.com"));

        return contacts;
    }

    private static List<String> createStringsList() {
        return new ArrayList<>(Arrays.asList(
                "- Строка 1",
                "- Строка 2",
                "- Строка 3",
                "- Строка 4"));
    }

    private static List<Organization> createOrganizationsList() {
        return new ArrayList<>(Arrays.asList(
                createOrganization("Организация 1", "http://organization.one"),
                createOrganization("Организация 2", "http://organization.two")
        ));
    }

    private static Organization createOrganization(String name, String url) {
        return new Organization(
                new Link(name, url),
                new ArrayList<>(Arrays.asList(
                        createOrganizationContent(new Period(
                                LocalDate.of(2011, 10, 1),
                                LocalDate.of(2012, 10, 1))),
                        createOrganizationContent(new Period(
                                LocalDate.of(2011, 10, 1),
                                LocalDate.of(2012, 10, 1))))));
    }

    private static OrganizationContent createOrganizationContent(Period period) {
        return new OrganizationContent(
                period,
                "Заголовок внутреннего блока 'Организация'",
                "Описание внутреннего блока 'Организация'");
    }
}