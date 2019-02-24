package model;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Organization {
    private final Link homePage;
    private final List<OrganizationContent> content;

    public Organization(Link link, List<OrganizationContent> content) {
        this.homePage = link;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", content=" + content +
                '}';
    }
}