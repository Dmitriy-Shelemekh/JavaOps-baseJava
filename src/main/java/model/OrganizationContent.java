package model;

import lombok.Getter;
import utils.Period;

import java.time.LocalDate;
import java.util.Objects;

@Getter
public class OrganizationContent {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;

    public OrganizationContent(Period period, String title, String description) {
        Objects.requireNonNull(period, "Period must be not null");
        Objects.requireNonNull(title, "Title must be not null");
        this.startDate = period.getStartDate();
        this.endDate = period.getEndDate();
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationContent that = (OrganizationContent) o;
        return Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrganizationContent{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}