package storage;

import model.*;
import utils.Period;

import java.time.LocalDate;
import java.util.*;

import static model.ContactType.*;
import static model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Some Test Name");

        resume.setContacts(getFillContracts());
        resume.setSections(getFillSections());
    }

    private static Map<SectionType, Section> getFillSections() {
        Map<SectionType, Section> sections = new HashMap<>();

        String objective = "Текст блока 'Позиция'";
        String personal = "Текст блока 'Личные качетсва'";
        List<String> achievement = new ArrayList<>(Arrays.asList(
                "- Достижение 1",
                "- Достижение 2",
                "- Достижение 3",
                "- Достижение 4"));
        List<String> qualifications = new ArrayList<>(Arrays.asList(
                "- Квалификация 1",
                "- Квалификация 2",
                "- Квалификация 3",
                "- Квалификация 4"));
        List<Organization> experience = new ArrayList<>(Arrays.asList(
                new Organization(
                        new Link("Организация 1", "http://organization.one"),
                        new ArrayList<>(Arrays.asList(
                                createOrganizationContent(),
                                createOrganizationContent()))),
                new Organization(
                        new Link("Организация 2", "http://organization.two"),
                        new ArrayList<>(Arrays.asList(
                                createOrganizationContent(),
                                createOrganizationContent())))));

        List<Organization> education = experience; //TODO Пока просто для теста, потом переписать.

        sections.put(OBJECTIVE, new TextSection(objective));
        sections.put(PERSONAL, new TextSection(personal));
        sections.put(ACHIEVEMENT, new ListSection(achievement));
        sections.put(QUALIFICATIONS, new ListSection(qualifications));
        sections.put(EXPERIENCE, new OrganizationSection(experience));
        sections.put(EDUCATION, new OrganizationSection(education));

        return sections;
    }

    private static OrganizationContent createOrganizationContent() {
        return new OrganizationContent(
                new Period(
                        LocalDate.of(2011, 10, 1),
                        LocalDate.of(2012, 10, 1)),
                "Заголовок внутреннего блока Организация",
                "Описание внутреннего блока Организация");
    }

    private static Map<ContactType, Object> getFillContracts() {
        Map<ContactType, Object> contacts = new HashMap<>();

        contacts.put(PHONE_MOBILE, "+7(999)333-33-33");
        contacts.put(PHONE_HOME, "+7(495)333-33-33");
        contacts.put(SKYPE, new Link("test.skype", "skype:test.skype"));
        contacts.put(EMAIL, new Link("testWork@mail.com", "mailto:testWork@mail.com"));
        contacts.put(GITHUB, new Link("Профиль на GitHub", "https://github.com/testName"));
        contacts.put(HOME_PAGE, new Link("Домашняя страница", "https://testName.com"));

        return contacts;
    }
}
