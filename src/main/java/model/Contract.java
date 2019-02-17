package model;

import lombok.Data;

@Data
public class Contract {
    private ContactType type;
    private String value;
    private Link link;

    public Contract(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Contract(ContactType type, Link link) {
        this.type = type;
        this.link = link;
        this.value = link.getName();
    }
}