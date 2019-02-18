package storage;

import model.ContactType;
import model.Link;
import model.Resume;

import java.util.HashMap;
import java.util.Map;

import static model.ContactType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Some Test Name");

        Map<ContactType, Object> contracts = new HashMap<>();
        contracts.put(PHONE_MOBILE, "+7(999)333-33-33");
        contracts.put(PHONE_HOME, "+7(495)333-33-33");
        contracts.put(SKYPE, new Link("test.skype", "skype:test.skype"));
        contracts.put(EMAIL, new Link("testWork@mail.com", "mailto:testWork@mail.com"));
        contracts.put(GITHUB, new Link("Профиль на GitHub", "https://github.com/testName"));
        contracts.put(HOME_PAGE, new Link("Домашняя страница", "https://testName.com"));

        resume.setContracts(contracts);
    }
}
