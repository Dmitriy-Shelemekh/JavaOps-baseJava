package main.java.model;

public enum Errors {
    NOT_IN_STORAGE("Резюме нет в хранилище"),
    NO_FREE_SPACE("В хранилище нет свободного места"),
    ALREADY_EXIST("Такое резюме уже есть в хранилище");

    String message;

    Errors(String message) {
        this.message = message;
    }

    public String toString() {
        return this.message;
    }
}
