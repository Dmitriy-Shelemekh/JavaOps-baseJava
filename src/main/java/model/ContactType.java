package model;

public enum ContactType {
    PHONE_MOBILE("Мобильный тел."),
    PHONE_HOME("Домашний тел."),
    EMAIL("Почта"),
    SKYPE("Skype"),
    GITHUB("Профиль GitHub"),
    HOME_PAGE("Домашняя страница");

    private final String name;

    ContactType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}