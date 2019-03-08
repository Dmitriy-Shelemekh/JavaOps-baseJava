package utils;

import lombok.Getter;

import java.time.LocalDate;


@Getter
public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Period(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Period(LocalDate startDate) {
        this.startDate = startDate;
        endDate = LocalDate.now();
    }
}