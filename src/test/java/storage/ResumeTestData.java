package storage;

import model.ContactType;
import model.Contract;
import model.Link;
import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Some Test Name");

        List<Contract> contracts = new ArrayList<>();
        contracts.add(new Contract(ContactType.PHONE_MOBILE, "+7(999)333-33-33"));
        contracts.add(new Contract(ContactType.PHONE_HOME, "+7(495)333-33-33"));
        contracts.add(new Contract(ContactType.SKYPE, new Link("test.skype", "skype:test.skype")));
        contracts.add(new Contract(ContactType.EMAIL, new Link("testHome@mail.com", "mailto:testHome@mail.com")));
        contracts.add(new Contract(ContactType.EMAIL, new Link("testWork@mail.com", "mailto:testWork@mail.com")));
        contracts.add(new Contract(ContactType.GITHUB, new Link("Профиль на GitHub", "https://github.com/testName")));
        contracts.add(new Contract(ContactType.HOME_PAGE, new Link("Домашняя страница", "https://testName.com")));

        resume.setContracts(contracts);
    }
}
