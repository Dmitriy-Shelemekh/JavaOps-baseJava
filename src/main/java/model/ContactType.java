package model;

public enum ContactType {
    PHONE_MOBILE("Мобильный тел."),
    PHONE_HOME("Домашний тел."),
    EMAIL("Почта"),
    SKYPE("Skype"),
    GITHUB("Профиль GitHub"),
    HOME_PAGE("Домашняя страница");

    private final String value;

    ContactType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}